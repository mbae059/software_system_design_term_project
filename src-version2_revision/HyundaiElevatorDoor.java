package theClasses;

public class HyundaiElevatorDoor implements ElevatorDoor {
    private int opened = 0;

    @Override
    public DoorStatus getDoorStatus() {
        return opened == 0 ? DoorStatus.CLOSED : DoorStatus.OPEN;
    }

    @Override
    public void open() {
        if (opened != 1) {
            System.out.println("open Hyundai Elevator Door");
            opened = 1;
        }
    }

    @Override
    public void close() {
        if (opened != 0) {
            System.out.println("close Hyundai Elevator Door");
            opened = 0;
        }
    }
}