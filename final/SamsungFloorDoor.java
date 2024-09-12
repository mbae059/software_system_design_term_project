public class SamsungFloorDoor extends FloorDoor {
    private char doorOpened;
    public SamsungFloorDoor(Floor floor) {
        super(floor);
        doorOpened = 'X';
    }

    @Override
    public void open() {
        System.out.println(floor + "th Floor Door Open") ;
        doorOpened = 'O';
    }

    @Override
    public void close() {
        System.out.println(floor + "th Floor Door Close") ;
        doorOpened = 'X';
    }

    @Override
    public DoorStatus getDoorStatus() {
        return doorOpened == 'O' ? DoorStatus.OPEN : DoorStatus.CLOSED;
    }
}
