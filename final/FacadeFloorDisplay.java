import java.util.ArrayList;
import java.util.List;

public class FacadeFloorDisplay implements FloorDisplayFacade {
    private List<IFloorDisplayImplementor> displayImplementors;

    public FacadeFloorDisplay() {
        this.displayImplementors = new ArrayList<>();
    }

    public void addDisplayImplementor(IFloorDisplayImplementor displayImplementor) {
        this.displayImplementors.add(displayImplementor);
    }

    public void activateDisplay() {
        for (IFloorDisplayImplementor implementor : displayImplementors) {
            implementor.activateDisplay();
        }
    }

    public void deactivateDisplay() {
        for (IFloorDisplayImplementor implementor : displayImplementors) {
            implementor.deactivateDisplay();
        }
    }

    public void showCurrentPosition(Floor floor) {
        for (IFloorDisplayImplementor implementor : displayImplementors) {
            implementor.showCurrentPosition(floor);
        }
    }

    public void expressCurrentPositionByVoice(Floor floor) {
        for (IFloorDisplayImplementor implementor : displayImplementors) {
            implementor.expressCurrentPositionByVoice(floor);
        }
    }

    public void showDirection(Direction direction) {
        for (IFloorDisplayImplementor implementor : displayImplementors) {
            implementor.showDirection(direction);
        }
    }

    public void expressDirectionByVoice(Direction direction) {
        for (IFloorDisplayImplementor implementor : displayImplementors) {
            implementor.expressDirectionByVoice(direction);
        }
    }
}
