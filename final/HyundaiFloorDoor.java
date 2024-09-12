
public class HyundaiFloorDoor extends FloorDoor {
    private boolean doorOpened;
    public HyundaiFloorDoor(Floor floor) {
        super(floor);
        doorOpened = false;
    }

    @Override
    public void open() {
        System.out.println(floor + "th Floor Door Open") ;
        doorOpened = true;
    }

    @Override
    public void close() {
        System.out.println(floor + "th Floor Door Close") ;
        doorOpened = false;
    }

    @Override
    public DoorStatus getDoorStatus() {
        return doorOpened ? DoorStatus.OPEN : DoorStatus.CLOSED;
    }
}
