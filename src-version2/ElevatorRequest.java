public class ElevatorRequest {
	private final Floor floor;
	private SimpleElevatorManager elevatorManager;
	public ElevatorRequest(Floor floor, SimpleElevatorManager elevatorManager) {
		this.floor = floor;
		this.elevatorManager = elevatorManager;
	}
	public void up() { elevatorManager.requestElevator(floor, Direction.UP);}
	public void down() { elevatorManager.requestElevator(floor, Direction.DOWN);}
}