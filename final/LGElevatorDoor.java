
public class LGElevatorDoor extends ElevatorDoor {
    private String elevatorDoorStatus;

    public LGElevatorDoor() {
        elevatorDoorStatus = "Closed";
    }
    @Override

    public DoorStatus getDoorStatus() {
        return elevatorDoorStatus.equals("Closed") ? DoorStatus.CLOSED : DoorStatus.OPEN;
    }

    @Override
    public void open() {
        if ( elevatorDoorStatus.equals("Opened") ) return ;
        System.out.println("open LG Elevator Door") ;
        elevatorDoorStatus = "Opened";
    }

    @Override
    public void close() {
        if ( elevatorDoorStatus.equals("Closed") ) return ;
        System.out.println("close LG Elevator Door") ;
        elevatorDoorStatus = "Closed";
    }
}
