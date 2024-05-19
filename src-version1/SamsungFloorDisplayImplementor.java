
public class SamsungFloorDisplayImplementor implements IFloorDisplayImplementor {
	private String activated = "yes";
	public void activateDisplay() {
		activated = "yes";
	}
	public void deactivateDisplay() {
		activated = "no";
	}
	public void showCurrentPosition(int floor) {
		if ( activated.equals("no") ) return;
		System.out.println("Samsung Display: Current Position " + floor);
	}
	public void expressCurrentPositionByVoice(int floor) {
		if ( activated.equals("no") ) return;
		System.out.println("Samsung Voice: Current Position " + floor);
	}
	public void showDirection(ElevatorDirection elevatorDirection) {
		if ( activated.equals("no") ) return;
		System.out.println("Samsung Display: Current Direction " + elevatorDirection);
	}
	public void expressDirectionByVoice(ElevatorDirection elevatorDirection) {
		if ( activated.equals("no") ) return;
		System.out.println("Samsung Voice: Current Direction " + elevatorDirection);
	}
}
