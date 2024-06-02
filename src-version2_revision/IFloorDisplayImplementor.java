package theClasses;
public interface IFloorDisplayImplementor {
	public void activateDisplay();
	public void deactivateDisplay();
	
	public void showCurrentPosition(int floor);
	public void expressCurrentPositionByVoice(int floor);
	public void showDirection(ElevatorDirection direction);
	public void expressDirectionByVoice(ElevatorDirection direction);
}
