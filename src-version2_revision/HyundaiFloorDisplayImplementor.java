package theClasses;
public class HyundaiFloorDisplayImplementor implements IFloorDisplayImplementor {
	private boolean activated = true;
	public void activateDisplay() {
		activated = true;
	}
	public void deactivateDisplay() {
		activated = false;
	}
	public void showCurrentPosition(int floor) {
		if ( ! activated ) return;
		System.out.println("Hyundai Display: Current Position " + floor);
	}
	public void expressCurrentPositionByVoice(int floor) {
		if ( ! activated ) return;
		System.out.println("Hyundai Voice: Current Position " + floor);
	}
	public void showDirection(ElevatorDirection elevatorDirection) {
		if ( ! activated ) return;
		System.out.println("Hyundai Display: Current Direction " + elevatorDirection);
	}
	public void expressDirectionByVoice(ElevatorDirection elevatorDirection) {
		if ( ! activated ) return;
		System.out.println("Hyundai Voice: Current Direction " + elevatorDirection);
	}
}
