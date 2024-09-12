public abstract class ElevatorFactory {
    public abstract ElevatorMotor getElevatorMotor();
    public abstract ElevatorDoor getElevatorDoor();
    public abstract FloorDoor getFloorDoor(Floor floor);

}
