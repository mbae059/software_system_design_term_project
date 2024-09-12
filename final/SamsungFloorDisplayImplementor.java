public class SamsungFloorDisplayImplementor implements IFloorDisplayImplementor {
	private String activated = "yes";
	public void activateDisplay() {
		activated = "yes";
	}
	public void deactivateDisplay() {
		activated = "no";
	}
	public void showCurrentPosition(Floor floor) {
		if ( activated.equals("no") ) return;
		System.out.println("Samsung Display: Current Position " + floor);
	}
	public void expressCurrentPositionByVoice(Floor floor) {
		if ( activated.equals("no") ) return;
		System.out.println("Samsung Voice: Current Position " + floor);
	}
	public void showDirection(Direction direction) {
		if ( activated.equals("no") ) return;
		System.out.println("Samsung Display: Current Direction " + direction);
	}
	public void expressDirectionByVoice(Direction direction) {
		if ( activated.equals("no") ) return;
		System.out.println("Samsung Voice: Current Direction " + direction);
	}
}
