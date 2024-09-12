import java.util.List;

public class ResponseTimeScheduler implements ElevatorScheduler {
    @Override
    public int selectElevator(List<ElevatorController> elevatorControllers, Direction direction) {
        System.out.println("ResponseTimeScheduler selects " + (elevatorControllers.size()-1));
        return elevatorControllers.size()-1;
    }
}
