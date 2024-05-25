public class ElevatorDestinationRequest {
	private final ElevatorController elevatorController;
	private Floor floor;
	
	public ElevatorDestinationRequest(Floor floor, ElevatorController elevatorController) {
		this.floor = floor;
		this.elevatorController = elevatorController;
	}
	public void pressed() {
		elevatorController.goTo(floor);
	}
}
