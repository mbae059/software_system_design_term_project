
abstract class AbstractFloorDisplay {
	protected ElevatorController elevatorController ;
	private IFloorDisplayImplementor iFloorDisplayImplementor;
	
	public AbstractFloorDisplay(ElevatorController elevatorController, IFloorDisplayImplementor iFloorDisplayImplementor) {
		this.elevatorController = elevatorController;
		this.iFloorDisplayImplementor = iFloorDisplayImplementor;
	}
	public void update() {
		Floor currentFloor = elevatorController.getCurrentFloor() ;
		Direction elevatorDirection = elevatorController.getElevatorDirection();
		showFloor(currentFloor);
		showDirection(elevatorDirection);
	}
	public void displayOn() { iFloorDisplayImplementor.activateDisplay(); }
	public void displayOff() { iFloorDisplayImplementor.deactivateDisplay(); }
	public void setDisplay(boolean set) {
		if (set) iFloorDisplayImplementor.activateDisplay();
		else iFloorDisplayImplementor.deactivateDisplay();
	}
	protected IFloorDisplayImplementor getiFloorDisplayImplementor() { return iFloorDisplayImplementor; }
	public abstract void showFloor(Floor floor);
	public abstract void showDirection(Direction direction);
}
