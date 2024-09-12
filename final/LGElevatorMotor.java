public class LGElevatorMotor extends ElevatorMotor {
    @Override
    public void moveMotor(Floor currentFloor, Direction direction) {
        System.out.println("move LG Motor, Direction: " + direction) ;
    }

    @Override
    public void stopMotor() {
        System.out.println("LG Elevator Motor Stop") ;
    }
}
