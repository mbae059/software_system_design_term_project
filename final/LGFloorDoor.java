public class LGFloorDoor extends FloorDoor {
    private int doorOpened;
    public LGFloorDoor(Floor floor) {
        super(floor);
        doorOpened = 0;
    }

    @Override
    public void open() {
        System.out.println(floor + "th Floor Door Open") ;
        doorOpened = 1;
    }

    @Override
    public void close() {
        System.out.println(floor + "th Floor Door Close") ;
        doorOpened = 0;
    }

    @Override
    public DoorStatus getDoorStatus() {
        return doorOpened == 1 ? DoorStatus.OPEN : DoorStatus.CLOSED;
    }
}
