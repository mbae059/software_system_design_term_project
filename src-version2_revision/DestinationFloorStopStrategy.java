package theClasses;

public class DestinationFloorStopStrategy implements ElevatorStopStrategy {
    @Override
    public boolean shouldStop(ElevatorController controller, int floor) {
        return controller.getFloorsToBeVisited().contains(floor);
    }
}