public class BasicFloorDisplay extends AbstractFloorDisplay {
	public BasicFloorDisplay(ElevatorController elevatorController, IFloorDisplayImplementor iFloorDisplayImplementor) {
		super(elevatorController, iFloorDisplayImplementor);
	}
	
	@Override
	public void showFloor(Floor floor) {
		IFloorDisplayImplementor iFloorDisplayImplementor = getiFloorDisplayImplementor();
		iFloorDisplayImplementor.showCurrentPosition(floor);
	}
	@Override
	public void showDirection(Direction direction) {
		IFloorDisplayImplementor iFloorDisplayImplementor = getiFloorDisplayImplementor();
		iFloorDisplayImplementor.showDirection(direction);
	}
}
