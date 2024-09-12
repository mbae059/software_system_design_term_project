import java.util.List;

public class ThroughputScheduler implements ElevatorScheduler {
    @Override
    public int selectElevator(List<ElevatorController> elevatorControllers, Direction direction) {
        System.out.println("ThroughputScheduler selects " + 0);
        return 0;
    }
}
