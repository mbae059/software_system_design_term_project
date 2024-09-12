import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int floorCount = 5;
		
        FacadeFloorDisplay facade = new FacadeFloorDisplay();
        facade.addDisplayImplementor(new SamsungFloorDisplayImplementor());
        facade.addDisplayImplementor(new LGFloorDisplayImplementor());
        facade.addDisplayImplementor(new HyundaiFloorDisplayImplementor());
        
        
		List<ElevatorController> elevatorControllers = createElevatorControllers(floorCount, facade);
		
		SimpleElevatorManager simpleElevatorManager = new SimpleElevatorManager(elevatorControllers);
		
		List<ElevatorRequest> requestButtons = new ArrayList<>();
		for ( int i = 0; i < floorCount; i ++ ) {
			Floor floor = new Floor(i+1);
			ElevatorRequest requestButton = new ElevatorRequest(floor, simpleElevatorManager);
			requestButtons.add(requestButton);
		}
		requestButtons.get(0).down();
	}

	private static ElevatorController getElevatorController(
			DeviceVendor deviceVendor,
			ElevatorControllerKind elevatorControllerKind,
			int floorCount,
			JavaDoorTimer doorTimer,
			FloorDisplayFacade facade) {
		ElevatorFactory elevatorFactory = ElevatorFactoryFactory.getElevatorFactory(deviceVendor);

		ElevatorMotor elevatorMotor = elevatorFactory.getElevatorMotor();
		ElevatorDoor elevatorDoor = elevatorFactory.getElevatorDoor();
		List<FloorDoor> floorDoors = createFloorDoors(floorCount, elevatorFactory);

		ElevatorController elevatorController = new ElevatorController(elevatorControllerKind,
				elevatorMotor, elevatorDoor, floorDoors, doorTimer, facade);

		if (doorTimer != null) {
			doorTimer.setDoorTimeout(elevatorController);
		}
		elevatorMotor.setElevatorController(elevatorController);
		return elevatorController;
	}
	private static List<ElevatorController> createElevatorControllers(int floorCount, FloorDisplayFacade facade) {
		List<ElevatorController> elevatorControllers = new ArrayList<>();

		ElevatorController elevatorController1 = getElevatorController(DeviceVendor.Samsung, ElevatorControllerKind.EveryFloorStop, floorCount, new JavaDoorTimer(), facade);
		//Set Display for Elevator 1
		setControlRoomDisplay(elevatorController1, new ControlRoomDisplay(elevatorController1));
		setElevatorInsideDisplay(elevatorController1, new ElevatorInsideDisplay(elevatorController1));
		setAbstractFloorDisplay(elevatorController1, null);


		ElevatorController elevatorController2 = getElevatorController(DeviceVendor.Hyundai, ElevatorControllerKind.DemandOnly, floorCount, null, facade);
		//Set Display for Elevator 2
		setControlRoomDisplay(elevatorController2, null);
		setElevatorInsideDisplay(elevatorController1, null);
		IFloorDisplayImplementor imp = new SamsungFloorDisplayImplementor();
		AdvancedFloorDisplay advancedFloorDisplay = new AdvancedFloorDisplay(elevatorController2, imp);
		setAbstractFloorDisplay(elevatorController2, advancedFloorDisplay);

		//attach observer to Elevator 2

		elevatorControllers.add(elevatorController1);
		elevatorControllers.add(elevatorController2);

		return elevatorControllers;
	}

	private static List<FloorDoor> createFloorDoors(int floorCount, ElevatorFactory elevatorFactory) {
		List<FloorDoor> floorDoors = new ArrayList<>();
		for ( int i = 0 ; i < floorCount; i ++ )
			floorDoors.add(elevatorFactory.getFloorDoor(new Floor(floorCount)));
		return floorDoors;
	}

	private static void setControlRoomDisplay(ElevatorController elevatorController, ControlRoomDisplay controlRoomDisplay) {
		elevatorController.setControlRoomDisplay(controlRoomDisplay);
		elevatorController.attach(controlRoomDisplay);
	}

	private static void setElevatorInsideDisplay(ElevatorController elevatorController, ElevatorInsideDisplay elevatorInsideDisplay) {
		elevatorController.setElevatorInsideDisplay(elevatorInsideDisplay);
		elevatorController.attach(elevatorInsideDisplay);
	}

	private static void setAbstractFloorDisplay(ElevatorController elevatorController, AbstractFloorDisplay abstractFloorDisplay) {
		elevatorController.setAbstractFloorDisplay(abstractFloorDisplay);
		elevatorController.attach(abstractFloorDisplay);
	}
}

