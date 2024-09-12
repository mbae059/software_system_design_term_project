
public class SamsungElevatorDoor extends ElevatorDoor {
    private char elevatorDoorStatus;
    public SamsungElevatorDoor() {
        elevatorDoorStatus = 'C';
    }

    @Override
    public DoorStatus getDoorStatus() {
        return elevatorDoorStatus == 'C' ? DoorStatus.CLOSED : DoorStatus.OPEN;
    }

    @Override
    public void open() {
        System.out.println("open Samsung Elevator Door") ;
        elevatorDoorStatus = 'O';
    }

    @Override
    public void close() {
        if(elevatorDoorStatus=='C') return;
        System.out.println("close Samsung Elevator Door") ;
        elevatorDoorStatus = 'C';
    }
}
