package theClasses;

public class ElevatorDoorFactory {
    public static ElevatorDoor createElevatorDoor(DeviceVendor deviceVendor) {
        switch (deviceVendor) {
            case LG:
                return new LGElevatorDoor();
            case Hyundai:
                return new HyundaiElevatorDoor();
            case Samsung:
                return new SamsungElevatorDoor();
            default:
                throw new IllegalArgumentException("Unknown DeviceVendor: " + deviceVendor);
        }
    }
}
