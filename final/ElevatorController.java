import java.util.ArrayList;
import java.util.List;

class ElevatorController extends ElevatorControllerSubject {
	
	
	private ElevatorControllerKind kind;

	private ElevatorMotor elevatorMotor;
	private ElevatorDoor elevatorDoor;
	private List<FloorDoor> floorDoors;
	private JavaDoorTimer doorTimer;
	private FloorDisplayFacade facade;
	
	private List<Floor> floorstobeVisited = new ArrayList<>();
	private Floor currentFloor = new Floor(1);
	private Direction currentDirection = Direction.IDLE;
	
	private ControlRoomDisplay controlRoomDisplay;
	private ElevatorInsideDisplay elevatorInsideDisplay;
	private AbstractFloorDisplay abstractFloorDisplay;
	
	public ElevatorController(ElevatorControllerKind elevatorControllerKind, ElevatorMotor elevatorMotor,
							  ElevatorDoor elevatorDoor, List<FloorDoor> floorDoors,
							  JavaDoorTimer doorTimer,
	                          FloorDisplayFacade facade) {
		this.kind = elevatorControllerKind;
		this.elevatorMotor = elevatorMotor;
		this.elevatorDoor = elevatorDoor;
		this.floorDoors = floorDoors;
		this.doorTimer = doorTimer;
		this.facade = facade;
		
		if ( doorTimer != null )
			doorTimer.setDoorTimeout(this);
	}
	public void stop() {
		if (isElevatorMoving()) {
			stopElevator();
		}
		doOpenDoor();
	}

	private void hasElevatorMotor() {
		assert elevatorMotor!=null;
	}

	private void hasElevatorDoor() {
		assert elevatorDoor!=null;
	}

	private void hasFloorDoors() {
		assert floorDoors != null;
	}
	private void stopElevator() {
		hasElevatorMotor();
		elevatorMotor.stop();
		setCurrentDirection(Direction.IDLE);
	}

	private void doOpenDoor() {
		hasElevatorDoor();
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
		hasElevatorMotor();

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
//		final Floor destination = floorstobeVisited.getFirst();
		final Floor destination = floorstobeVisited.get(0);
		if(destination.isUpperThan(currentFloor)) return Direction.UP;
		else return Direction.DOWN;
	}

	private void moveElevator(Direction nextDirection) {
		assert elevatorDoor != null;
		elevatorMotor.move(getCurrentFloor(), nextDirection);
		setCurrentDirection(nextDirection);
	}
	public void approaching(Floor floor) {
		hasElevatorMotor();
		hasElevatorDoor();
		hasFloorDoors();

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
		hasElevatorMotor();
		hasElevatorDoor();
		hasFloorDoors();

		doCloseDoor();
		if (hasNextDestination()) {
			moveElevator(determineMovingDirection());
		}
	}

	private void doCloseDoor() {
		elevatorDoor.close() ;
		floorDoors.get(getCurrentFloor().getFloor()).close() ;
		if ( doorTimer != null ) doorTimer.stop();
	}


	public void openDoor() {
		hasElevatorDoor();
		hasFloorDoors();

		if ( getElevatorDirection() == Direction.IDLE  ) {
			elevatorDoor.open() ;
			floorDoors.get(getCurrentFloor().getFloor()).open() ;
			if ( doorTimer != null ) doorTimer.start() ;
		}
	}
	public void closeDoor() {
		hasElevatorDoor();
		hasFloorDoors();

		if ( getElevatorDirection() == Direction.IDLE ) {
			elevatorDoor.close() ;
			floorDoors.get(getCurrentFloor().getFloor()).close() ;
			if ( doorTimer != null ) doorTimer.stop() ;
		}
	}
	public List<Floor> getFloorstobeVisited() {
		return floorstobeVisited;
	}
	public DoorStatus getDoorStatus(Floor floor) {
		hasElevatorDoor();
		hasFloorDoors();

		DoorStatus elevatorDoorStatus = elevatorDoor.getDoorStatus();
		DoorStatus floorDoorStatus = floorDoors.get(floor.getFloor()).getDoorStatus();

		return elevatorDoorStatus==DoorStatus.CLOSED && floorDoorStatus==DoorStatus.CLOSED ? DoorStatus.CLOSED : DoorStatus.OPEN;
	}
	
	public void setCurrentFloor(Floor currentFloor) {
		this.currentFloor = currentFloor;

		notifyObservers();
	}
	
	public void setCurrentDirection(Direction elevatorDirection) {
		this.currentDirection = elevatorDirection;

		notifyObservers();
	}
	
	
	public Floor getCurrentFloor() {
		return currentFloor ;
	}
	public Direction getElevatorDirection() {
		return currentDirection;
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