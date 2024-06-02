package theClasses;

public interface ElevatorStopStrategy {
	boolean shouldStop(ElevatorController controller, int floor);
}
