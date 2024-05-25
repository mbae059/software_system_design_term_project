
public class AdvancedFloorDisplay extends AbstractFloorDisplay {
	public AdvancedFloorDisplay(ElevatorController elevatorController, IFloorDisplayImplementor iFloorDisplayImplementor) {
		super(elevatorController, iFloorDisplayImplementor);
	}
	@Override
	public void showFloor(Floor floor) {
		IFloorDisplayImplementor iFloorDisplayImplementor = getiFloorDisplayImplementor();
		iFloorDisplayImplementor.showCurrentPosition(floor);
		iFloorDisplayImplementor.expressCurrentPositionByVoice(floor);
	}
	@Override
	public void showDirection(Direction direction) {
		IFloorDisplayImplementor iFloorDisplayImplementor = getiFloorDisplayImplementor();
		iFloorDisplayImplementor.showDirection(direction);
		iFloorDisplayImplementor.expressDirectionByVoice(direction);
	}
}
