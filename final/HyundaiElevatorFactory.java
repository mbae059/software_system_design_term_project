public class HyundaiElevatorFactory extends ElevatorFactory {
    @Override
    public ElevatorMotor getElevatorMotor() {
        return new HyundaiElevatorMotor();
    }

    @Override
    public ElevatorDoor getElevatorDoor() {
        return new HyundaiElevatorDoor();
    }

    @Override
    public FloorDoor getFloorDoor(Floor floor) {
        return new HyundaiFloorDoor(floor);
    }
}
