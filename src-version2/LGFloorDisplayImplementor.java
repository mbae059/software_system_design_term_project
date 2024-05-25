
public class LGFloorDisplayImplementor implements IFloorDisplayImplementor {
	private boolean activated = true;
	public void activateDisplay() {
		activated = true;
	}
	public void deactivateDisplay() {
		activated = false;
	}
	@Override
	public void showCurrentPosition(Floor floor) {
		if (!activated) return;
		System.out.println("LG Display: Current Position " + floor);
	}
	public void expressCurrentPositionByVoice(Floor floor) {
		if (!activated) return;
		System.out.println("LG Voice: Current Position " + floor);
	}
	public void showDirection(Direction direction) {
		if (!activated) return;
		System.out.println("LG Display: Current Direction " + direction);
	}
	public void expressDirectionByVoice(Direction direction) {
		if (!activated) return;
		System.out.println("LG Voice: Current Direction " + direction);
	}
}
