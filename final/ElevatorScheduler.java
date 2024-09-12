import java.util.List;

public interface ElevatorScheduler {
    public int selectElevator(List<ElevatorController> elevatorControllers, Direction direction);
}
