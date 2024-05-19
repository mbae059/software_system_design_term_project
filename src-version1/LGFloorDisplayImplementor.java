
public class LGFloorDisplayImplementor implements IFloorDisplayImplementor {
	private int activated = 1;
	public void activateDisplay() {
		activated = 1;
	}
	public void deactivateDisplay() {
		activated = 0;
	}
	@Override
	public void showCurrentPosition(int floor) {
		if ( activated == 0 ) return;
		System.out.println("LG Display: Current Position " + floor);
	}
	public void expressCurrentPositionByVoice(int floor) {
		if ( activated == 0 ) return;
		System.out.println("LG Voice: Current Position " + floor);
	}
	public void showDirection(ElevatorDirection elevatorDirection) {
		if ( activated == 0 ) return;
		System.out.println("LG Display: Current Direction " + elevatorDirection);
	}
	public void expressDirectionByVoice(ElevatorDirection elevatorDirection) {
		if ( activated == 0 ) return;
		System.out.println("LG Voice: Current Direction " + elevatorDirection);
	}
}
