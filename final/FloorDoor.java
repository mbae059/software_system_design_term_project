public abstract class FloorDoor {
	protected final Floor floor ;
	public FloorDoor(Floor floor) {
		this.floor = floor;
	}
	public abstract void open();
	public abstract void close();
	public abstract DoorStatus getDoorStatus();

	public final Floor getFloor() { return floor; }
}