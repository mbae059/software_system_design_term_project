package theClasses;

public class SamsungElevatorDoor implements ElevatorDoor {
    private char status = 'C';

    @Override
    public DoorStatus getDoorStatus() {
        return status == 'C' ? DoorStatus.CLOSED : DoorStatus.OPEN;
    }

    @Override
    public void open() {
        if (status != 'O') {
            System.out.println("open Samsung Elevator Door");
            status = 'O';
        }
    }

    @Override
    public void close() {
        if (status != 'C') {
            System.out.println("close Samsung Elevator Door");
            status = 'C';
        }
    }
}