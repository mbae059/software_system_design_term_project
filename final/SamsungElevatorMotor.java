
public class SamsungElevatorMotor extends ElevatorMotor {
    @Override
    public void moveMotor(Floor currentFloor, Direction direction) {
        System.out.println("move Samsung Motor, Direction: " + direction) ;
    }

    @Override
    public void stopMotor() {
        System.out.println("Samsung Elevator Motor Stop") ;
    }
}
