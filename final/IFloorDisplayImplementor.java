public interface IFloorDisplayImplementor {
	public void activateDisplay();
	public void deactivateDisplay();
	
	public void showCurrentPosition(Floor floor);
	public void expressCurrentPositionByVoice(Floor floor);
	public void showDirection(Direction direction);
	public void expressDirectionByVoice(Direction direction);
}
