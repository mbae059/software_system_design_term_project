public class HyundaiElevatorDoor extends ElevatorDoor {
    private int elevatorDoorStatus;
    public HyundaiElevatorDoor() {
        elevatorDoorStatus = 0;
    }
    @Override
    public DoorStatus getDoorStatus() {
        return elevatorDoorStatus == 0 ? DoorStatus.CLOSED : DoorStatus.OPEN;
    }

    @Override
    public void open() {
        if ( elevatorDoorStatus == 1 ) return ;
        System.out.println("open Hyundai Elevator Door") ;
        elevatorDoorStatus = 1;
    }

    @Override
    public void close() {
        if ( elevatorDoorStatus == 0  ) return ;
        System.out.println("close Hyundai Elevator Door") ;
        elevatorDoorStatus = 0;
    }
}
