
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int floorCount = 5;

		List<ElevatorController> elevatorControllers = createElevatorControllers(floorCount);
		
		SimpleElevatorManager em = new SimpleElevatorManager(elevatorControllers);
		
		List<ElevatorRequest> requestButtons = new ArrayList<>();
		for ( int i = 0; i < floorCount; i ++ ) {
			int floor = i+1;
			ElevatorRequest requestButton = new ElevatorRequest(floor,em);
			requestButtons.add(requestButton);
		}
		requestButtons.getFirst().down();
	}

	private static List<ElevatorController> createElevatorControllers(int floorCount) {
		List<ElevatorController> elevatorControllers = new ArrayList<>();
		
		// Devices for Elevator 1
		ElevatorMotor elevatorMotor1 = new ElevatorMotor(DeviceVendor.Samsung);
		JavaDoorTimer doorTimer1 = new JavaDoorTimer();
			
		ElevatorDoor elevatorDoor1 = new ElevatorDoor(DeviceVendor.Samsung);
		List<FloorDoor> floorDoors1 = createFloorDoors(floorCount, DeviceVendor.Samsung);
		
		// every floor stop
		ElevatorController elevatorController1 = new ElevatorController(ElevatorControllerKind.EVERY_FLOOR_STOP,
				elevatorMotor1, elevatorDoor1, floorDoors1, doorTimer1);
		doorTimer1.setDoorTimeout(elevatorController1);
		elevatorMotor1.setElevatorController(elevatorController1);


		// Devices for Elevator 2
		ElevatorMotor elevatorMotor2 = new ElevatorMotor(DeviceVendor.Hyundai);
		ElevatorDoor elevatorDoor2 = new ElevatorDoor(DeviceVendor.Hyundai);
		List<FloorDoor> floorDoors2 = createFloorDoors(floorCount, DeviceVendor.Hyundai);

		// demand only stop
		ElevatorController elevatorController2 = new ElevatorController(ElevatorControllerKind.DEMAND_ONLY_STOP,
					elevatorMotor2, elevatorDoor2, floorDoors2, null);
		elevatorMotor2.setElevatorController(elevatorController2);

		ControlRoomDisplay controlRoomDisplay = new ControlRoomDisplay(elevatorController1);
		elevatorController1.setControlRoomDisplay(controlRoomDisplay);
		ElevatorInsideDisplay elevatorInsideDisplay = new ElevatorInsideDisplay(elevatorController1);
		elevatorController1.setElevatorInsideDisplay(elevatorInsideDisplay);

		IFloorDisplayImplementor imp = new SamsungFloorDisplayImplementor();
		AdvancedFloorDisplay advancedFloorDisplay = new AdvancedFloorDisplay(elevatorController2, imp);
		elevatorController2.setAbstractFloorDisplay(advancedFloorDisplay);


		elevatorControllers.add(elevatorController1);
		elevatorControllers.add(elevatorController2);

		return elevatorControllers;
	}

	private static List<FloorDoor> createFloorDoors(int floorCount, DeviceVendor vendor) {
		List<FloorDoor> floorDoors = new ArrayList<>();
		
		for ( int i = 0 ; i < floorCount; i ++ )
			floorDoors.add(new FloorDoor(vendor, i));
		return floorDoors;
	}
}
