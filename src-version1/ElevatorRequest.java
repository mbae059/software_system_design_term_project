public class ElevatorRequest {
	private final int floor;
	private SimpleEM em;

	public ElevatorRequest(int floor, SimpleEM em) {
		this.floor = floor;
		this.em = em;
	}
	public void up() { em.requestElevator(floor, ElevatorDirection.UP); }
	public void down() { em.requestElevator(floor, ElevatorDirection.DOWN); }
}
