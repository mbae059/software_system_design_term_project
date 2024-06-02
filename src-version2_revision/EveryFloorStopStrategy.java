package theClasses;

public class EveryFloorStopStrategy implements ElevatorStopStrategy  {
	@Override
    public boolean shouldStop(ElevatorController controller, int floor) {
        return true;
    }
}
