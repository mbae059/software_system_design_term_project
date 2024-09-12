public abstract class ElevatorMotor {
    protected ElevatorController elevatorController ;
    protected MotorStatus motorStatus ;

    ElevatorMotor() {
        motorStatus = MotorStatus.STOPPED;
    }
    public final void setElevatorController(ElevatorController elevatorController) {
        this.elevatorController = elevatorController ;
    }
    public final MotorStatus getMotorStatus() {
        return motorStatus;
    }
    private final void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }

    public abstract void moveMotor(Floor currentFloor, Direction direction);

    public abstract void stopMotor();

    public final void move(Floor currentFloor, Direction direction) {
        if (  getMotorStatus() == MotorStatus.MOVING ) return ;

        assert elevatorController != null;
        DoorStatus doorStatus = elevatorController.getDoorStatus(currentFloor);

        if ( doorStatus == DoorStatus.OPEN )
            return;

        moveMotor(currentFloor, direction);

        setMotorStatus(MotorStatus.MOVING);
    }
    public final void stop() {
        stopMotor();
        setMotorStatus(MotorStatus.STOPPED);
    }
}
