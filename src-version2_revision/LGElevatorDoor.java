package theClasses;

public class LGElevatorDoor implements ElevatorDoor {
    private String status = "Closed";

    @Override
    public DoorStatus getDoorStatus() {
        return status.equals("Closed") ? DoorStatus.CLOSED : DoorStatus.OPEN;
    }

    @Override
    public void open() {
        if (!status.equals("Opened")) {
            System.out.println("open LG Elevator Door");
            status = "Opened";
        }
    }

    @Override
    public void close() {
        if (!status.equals("Closed")) {
            System.out.println("close LG Elevator Door");
            status = "Closed";
        }
    }
}
