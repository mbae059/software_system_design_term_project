
public class ControlRoomDisplay {
	private ElevatorController elevatorController ;

	public ControlRoomDisplay(ElevatorController elevatorController) {
		this.elevatorController = elevatorController;
	}
	public void update() {
		int currentFloor = elevatorController.getCurrentFloor() ;
		System.out.println("Control Room: " + currentFloor) ;
	}
}
