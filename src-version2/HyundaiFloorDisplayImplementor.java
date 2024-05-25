
public class HyundaiFloorDisplayImplementor implements IFloorDisplayImplementor {
	private boolean activated = true;
	public void activateDisplay() {
		activated = true;
	}
	public void deactivateDisplay() {
		activated = false;
	}
	public void showCurrentPosition(Floor floor) {
		if ( ! activated ) return;
		System.out.println("Hyundai Display: Current Position " + floor);
	}
	public void expressCurrentPositionByVoice(Floor floor) {
		if ( ! activated ) return;
		System.out.println("Hyundai Voice: Current Position " + floor);
	}
	public void showDirection(Direction direction) {
		if ( ! activated ) return;
		System.out.println("Hyundai Display: Current Direction " + direction);
	}
	public void expressDirectionByVoice(Direction direction) {
		if ( ! activated ) return;
		System.out.println("Hyundai Voice: Current Direction " + direction);
	}
}
