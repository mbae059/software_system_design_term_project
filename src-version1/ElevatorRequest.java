public class ElevatorRequest {
	private final int floor;
	private SimpleElevatorManager simpleElevatorManager;

	public ElevatorRequest(int floor, SimpleElevatorManager simpleElevatorManager) {
		this.floor = floor;
		this.simpleElevatorManager = simpleElevatorManager;
	}
	public void up() { simpleElevatorManager.requestElevator(floor, ElevatorDirection.UP); }
	public void down() { simpleElevatorManager.requestElevator(floor, ElevatorDirection.DOWN); }
}
