import java.util.ArrayList;
import java.util.List;

//observer pattern
public abstract class ElevatorControllerSubject {
    private List<DisplayObserver> displayObservers = new ArrayList<>();

    public void attach(DisplayObserver displayObserver) {
        displayObservers.add(displayObserver);
    }

    public void detach(DisplayObserver displayObserver) {
        displayObservers.remove(displayObserver);
    }

    protected void notifyObservers() {
        for (DisplayObserver displayObserver : displayObservers) {
            displayObserver.update();
        }
    }
}
