public class ElevatorDestinationRequest {
	private final ElevatorController elevatorController;
	private int floor;
	
	public ElevatorDestinationRequest(int floor, ElevatorController elevatorController) {
		this.floor = floor;
		this.elevatorController = elevatorController;
	}
	public void pressed() {
		elevatorController.goTo(floor);
	}
}
