
public class HyundaiElevatorMotor extends ElevatorMotor {
    @Override
    public void moveMotor(Floor currentFloor, Direction direction) {
        System.out.println("move Hyundai Motor, Direction: " + direction) ;
    }

    @Override
    public void stopMotor() {
        System.out.println("Hyundai Elevator Motor Stop") ;
    }
}
