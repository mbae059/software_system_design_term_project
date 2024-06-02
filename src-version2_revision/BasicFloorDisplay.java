package theClasses;

public class BasicFloorDisplay extends AbstractFloorDisplay {
	public BasicFloorDisplay(ElevatorController elevatorController, IFloorDisplayImplementor iFloorDisplayImplementor) {
		super(elevatorController, iFloorDisplayImplementor);
	}
	
	@Override
	public void showFloor(int floor) {
		IFloorDisplayImplementor iFloorDisplayImplementor = getiFloorDisplayImplementor();
		iFloorDisplayImplementor.showCurrentPosition(floor);
	}
	@Override
	public void showDirection(ElevatorDirection elevatorDirection) {
		IFloorDisplayImplementor iFloorDisplayImplementor = getiFloorDisplayImplementor();
		iFloorDisplayImplementor.showDirection(elevatorDirection);
	}
}
