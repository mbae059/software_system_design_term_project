public class SamsungElevatorFactory extends ElevatorFactory {
    @Override
    public ElevatorMotor getElevatorMotor() {
        return new SamsungElevatorMotor();
    }

    @Override
    public ElevatorDoor getElevatorDoor() {
        return new SamsungElevatorDoor();
    }

    @Override
    public FloorDoor getFloorDoor(Floor floor) {
        return new SamsungFloorDoor(floor);
    }
}
