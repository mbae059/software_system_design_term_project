import java.util.ArrayList;
import java.util.List;

class ElevatorController {

	private ElevatorControllerKind kind;
	private ElevatorMotor elevatorMotor;
	private ElevatorDoor elevatorDoor;
	private List<FloorDoor> floorDoors;
	private JavaDoorTimer doorTimer;
	
	private List<Floor> floorstobeVisited = new ArrayList<>();
	private Floor currentFloor = new Floor(1);
	private Direction currentDirection = Direction.IDLE;
	
	private ControlRoomDisplay controlRoomDisplay;
	private ElevatorInsideDisplay elevatorInsideDisplay;
	private AbstractFloorDisplay abstractFloorDisplay;
	
	public ElevatorController(ElevatorControllerKind elevatorControllerKind, ElevatorMotor elevatorMotor,
							  ElevatorDoor elevatorDoor, List<FloorDoor> floorDoors,
							  JavaDoorTimer doorTimer) {
		this.kind = elevatorControllerKind;
		this.elevatorMotor = elevatorMotor;
		this.elevatorDoor = elevatorDoor;
		this.floorDoors = floorDoors;
		this.doorTimer = doorTimer;
		
		if ( doorTimer != null )
			doorTimer.setDoorTimeout(this);
	}
	public void stop() {
		if (isElevatorMoving()) {
			stopElevator();
		}
		doOpenDoor();
	}

	private void stopElevator() {
		assert elevatorMotor != null;
		elevatorMotor.stop();
		setCurrentDirection(Direction.IDLE);
	}

	private void doOpenDoor() {
		assert elevatorDoor != null;
		elevatorDoor.open();
		openFloorDoor();
	}

	private void openFloorDoor() {
		assert floorDoors.get(getCurrentFloor().getFloor()) != null;
		floorDoors.get(getCurrentFloor().getFloor()).open();
		if(hasDoorTimer()) doorTimer.start();
	}

	private boolean hasDoorTimer() {
		return doorTimer != null;
	}
	public void goTo(Floor destination) {
		// elevatorMotor should not be null
		if (isNewDestination(destination)) {
			addDestination(destination);
		}
		if(isElevatorMoving()) return;

		if(hasNextDestination()) {
			moveElevator(determineMovingDirection());
		}
	}

	private boolean isNewDestination(Floor destination) {
		return !floorstobeVisited.contains(destination);
	}

	private void addDestination(Floor floor) {
		floorstobeVisited.add(floor);
	}

	private boolean isElevatorMoving() {
		return currentDirection != Direction.IDLE;
	}

	private boolean hasNextDestination() {
		return determineMovingDirection() != Direction.IDLE;
	}

	private Direction determineMovingDirection() {
		final boolean noMoreDestinationFloors = floorstobeVisited.isEmpty();
		if (noMoreDestinationFloors) {
			return Direction.IDLE;
		}
		final Floor destination = floorstobeVisited.getFirst();
		if(destination.isUpperThan(currentFloor)) return Direction.UP;
		else return Direction.DOWN;
	}

	private void moveElevator(Direction nextDirection) {
		assert elevatorDoor != null;
		elevatorMotor.move(getCurrentFloor(), nextDirection);
		setCurrentDirection(nextDirection);
	}
	public void approaching(Floor floor) {
		// elevatorMotor, elevatorDoor, floorDoors should not be null
		doApproaching(floor);
		if(!needToStop(floor)) return;

		stopElevator();
		doOpenDoor();

		removeDestination(floor);
	}

	private boolean needToStop(Floor floor) {
		boolean needToStop;
		if ( kind == ElevatorControllerKind.EveryFloorStop ) needToStop = true;
		else needToStop = getFloorstobeVisited().contains(floor);
		return needToStop;
	}
	private void doApproaching(Floor floor) {
		System.out.println("\nApproaching " + floor + "th floor") ;
		setCurrentFloor(floor);
	}
	private boolean removeDestination(Floor floor) {
		return floorstobeVisited.remove(floor);
	}
	public void doorTimeout() {
		// elevatorMotor, elevatorDoor, floorDoors should not be null
		Direction nextDirection;
		if ( floorstobeVisited.isEmpty() ) nextDirection = Direction.IDLE ;
		
		final Floor destination = floorstobeVisited.getFirst() ;
		if ( destination.getFloor() > getCurrentFloor().getFloor() ) nextDirection = Direction.UP ;
		else nextDirection = Direction.DOWN ;
		
		elevatorDoor.close() ;
		floorDoors.get(getCurrentFloor().getFloor()).close() ;
		if ( doorTimer != null ) doorTimer.stop() ;
		
		if ( nextDirection != Direction.IDLE ) {
			elevatorMotor.move(getCurrentFloor(), nextDirection) ;
			setCurrentDirection(nextDirection);
		}
	}
	public void openDoor() {
		// elevatorDoor, floorDoors should not be null

		if ( getElevatorDirection() == Direction.IDLE  ) {
			// open doors
			elevatorDoor.open() ;
			floorDoors.get(getCurrentFloor().getFloor()).open() ;
			if ( doorTimer != null ) doorTimer.start() ;
		}
	}
	public void closeDoor() {
		// elevatorDoor, floorDoors should not be null
		if ( getElevatorDirection() == Direction.IDLE ) {
			// closeDoor
			elevatorDoor.close() ;
			floorDoors.get(getCurrentFloor().getFloor()).close() ;
			if ( doorTimer != null ) doorTimer.stop() ;
		}
	}
	public List<Floor> getFloorstobeVisited() {
		return floorstobeVisited;
	}
	public DoorStatus getDoorStatus(Floor floor) {
		// elevatorDoor, floorDoors should not be null
		DoorStatus elevatorDoorStatus = elevatorDoor.getDoorStatus();
		DoorStatus floorDoorStatus = floorDoors.get(floor.getFloor()).getDoorStatus();

		return elevatorDoorStatus==DoorStatus.CLOSED && floorDoorStatus==DoorStatus.CLOSED ? DoorStatus.CLOSED : DoorStatus.OPEN;
	}
	public Floor getCurrentFloor() {
		return currentFloor ;
	}
	public void setCurrentFloor(Floor currentFloor) {
		this.currentFloor = currentFloor;
		
		controlRoomDisplay.update();
		elevatorInsideDisplay.update();
		abstractFloorDisplay.update();
	}
	public Direction getElevatorDirection() {
		return currentDirection;
	}
	public void setCurrentDirection(Direction elevatorDirection) {
		this.currentDirection = elevatorDirection;
		
		controlRoomDisplay.update();
		elevatorInsideDisplay.update();
		abstractFloorDisplay.update();
	}
	public ControlRoomDisplay getControlRoomDisplay() {
		return controlRoomDisplay;
	}
	public void setControlRoomDisplay(ControlRoomDisplay controlRoomDisplay) {
		this.controlRoomDisplay = controlRoomDisplay;
	}
	public ElevatorInsideDisplay getElevatorInsideDisplay() {
		return elevatorInsideDisplay;
	}
	public void setElevatorInsideDisplay(ElevatorInsideDisplay elevatorInsideDisplay) {
		this.elevatorInsideDisplay = elevatorInsideDisplay;
	}
	public AbstractFloorDisplay getAbstractFloorDisplay() {
		return abstractFloorDisplay;
	}
	public void setAbstractFloorDisplay(AbstractFloorDisplay abstractFloorDisplay) {
		this.abstractFloorDisplay = abstractFloorDisplay;
	}
}