import java.util.ArrayList;
import java.util.List;

class ElevatorController {

	private ElevatorControllerKind elevatorControllerKind;
	private ElevatorMotor elevatorMotor;
	private ElevatorDoor elevatorDoor;
	private List<FloorDoor> floorDoors;
	private JavaDoorTimer javaDoorTimer;
	
	private List<Integer> floorsToBeVisited = new ArrayList<>();
	private int currentFloor = 1;
	private ElevatorDirection elevatorDirection = ElevatorDirection.STOP;
	
	private ControlRoomDisplay controlRoomDisplay;
	private ElevatorInsideDisplay elevatorInsideDisplay;
	private AbstractFloorDisplay abstractFloorDisplay;
	
	public ElevatorController(ElevatorControllerKind elevatorControllerKind, ElevatorMotor elevatorMotor,
							  ElevatorDoor elevatorDoor, List<FloorDoor> floorDoors,
							  JavaDoorTimer doorTimer) {
		this.elevatorControllerKind = elevatorControllerKind;
		this.elevatorMotor = elevatorMotor;
		this.elevatorDoor = elevatorDoor;
		this.floorDoors = floorDoors;
		this.javaDoorTimer = doorTimer;
		
		if ( doorTimer != null )
			doorTimer.setDoorTimeout(this);
	}
	public void stop() {
		// elevatorMotor, elevatorDoor, floorDoors should not be null
		if ( getElevatorDirection() != ElevatorDirection.STOP) {
			elevatorMotor.stop();
			setCurrentDirection(ElevatorDirection.STOP);
		}
		// open doors
		elevatorDoor.open() ;
		floorDoors.get(getCurrentFloor()).open() ;
		if ( javaDoorTimer != null ) javaDoorTimer.start() ;
	}
	public void goTo(int destination) {
		// elevatorMotor should not be null
		if ( ! floorsToBeVisited.contains(destination) )
			floorsToBeVisited.add(destination) ;
		
		if ( getElevatorDirection() == ElevatorDirection.STOP ) {
			ElevatorDirection nextDirection;
			if ( floorsToBeVisited.isEmpty() ) nextDirection = ElevatorDirection.STOP ;
			
			if ( destination > currentFloor ) nextDirection = ElevatorDirection.UP ;
			else nextDirection = ElevatorDirection.DOWN ;
			if ( nextDirection != ElevatorDirection.STOP) {
				elevatorMotor.move(getCurrentFloor(), nextDirection) ;
				setCurrentDirection(nextDirection);
			}
		}
	}
	public void approaching(int floor) {
		// elevatorMotor, elevatorDoor, floorDoors should not be null
		System.out.println("\nApproaching " + floor + "th floor") ;
		setCurrentFloor(floor);
		
		boolean needToStop;
		if ( elevatorControllerKind == ElevatorControllerKind.EVERY_FLOOR_STOP )
			needToStop = true;
		else
			needToStop = getFloorsToBeVisited().contains(floor);
			
		if ( needToStop ) {
			elevatorMotor.stop() ;
			setCurrentDirection(ElevatorDirection.STOP);
			
			// open doors
			elevatorDoor.open() ;
			floorDoors.get(getCurrentFloor()).open() ;
			if ( javaDoorTimer != null ) javaDoorTimer.start() ;
			
			floorsToBeVisited.remove(floor) ;
		}
	}
	public void doorTimeout() {
		// elevatorMotor, elevatorDoor, floorDoors should not be null
		ElevatorDirection nextDirection;
		if ( floorsToBeVisited.isEmpty() ) nextDirection = ElevatorDirection.STOP ;
		
		final int destination = floorsToBeVisited.getFirst() ;
		if ( destination > getCurrentFloor() ) nextDirection = ElevatorDirection.UP ;
		else nextDirection = ElevatorDirection.DOWN ;
		
		elevatorDoor.close() ;
		floorDoors.get(getCurrentFloor()).close() ;
		if ( javaDoorTimer != null ) javaDoorTimer.stop() ;
		
		if ( nextDirection != ElevatorDirection.STOP ) {
			elevatorMotor.move(getCurrentFloor(), nextDirection) ;
			setCurrentDirection(nextDirection);
		}
	}
	public void openDoor() {
		// elevatorDoor, floorDoors should not be null

		if ( getElevatorDirection() == ElevatorDirection.STOP  ) {
			// open doors
			elevatorDoor.open() ;
			floorDoors.get(getCurrentFloor()).open() ;
			if ( javaDoorTimer != null ) javaDoorTimer.start() ;
		}
	}
	public void closeDoor() {
		// elevatorDoor, floorDoors should not be null
		if ( getElevatorDirection() == ElevatorDirection.STOP ) {
			// closeDoor
			elevatorDoor.close() ;
			floorDoors.get(getCurrentFloor()).close() ;
			if ( javaDoorTimer != null ) javaDoorTimer.stop() ;
		}
	}
	public List<Integer> getFloorsToBeVisited() {
		return floorsToBeVisited;
	}
	public DoorStatus getDoorStatus(int floor) {
		// elevatorDoor, floorDoors should not be null
		DoorStatus elevatorDoorStatus = elevatorDoor.getDoorStatus();
		DoorStatus floorDoorStatus = floorDoors.get(floor).getDoorStatus();

		return elevatorDoorStatus==DoorStatus.CLOSED && floorDoorStatus==DoorStatus.CLOSED ? DoorStatus.CLOSED : DoorStatus.OPEN;
	}
	public int getCurrentFloor() {
		return currentFloor ;
	}
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
		
		controlRoomDisplay.update();
		elevatorInsideDisplay.update();
		abstractFloorDisplay.update();
	}
	public ElevatorDirection getElevatorDirection() {
		return elevatorDirection;
	}
	public void setCurrentDirection(ElevatorDirection elevatorDirection) {
		this.elevatorDirection = elevatorDirection;
		
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