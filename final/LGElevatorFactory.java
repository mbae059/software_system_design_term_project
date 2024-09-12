public class LGElevatorFactory extends ElevatorFactory {
    @Override
    public ElevatorMotor getElevatorMotor() {
        return new LGElevatorMotor();
    }

    @Override
    public ElevatorDoor getElevatorDoor() {
        return new LGElevatorDoor();
    }

    @Override
    public FloorDoor getFloorDoor(Floor floor) {
        return new LGFloorDoor(floor);
    }
}
