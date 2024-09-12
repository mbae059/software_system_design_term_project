public interface FloorDisplayFacade {
    void activateDisplay();
    void deactivateDisplay();
    void showCurrentPosition(Floor floor);
    void expressCurrentPositionByVoice(Floor floor);
    void showDirection(Direction direction);
    void expressDirectionByVoice(Direction direction);
}