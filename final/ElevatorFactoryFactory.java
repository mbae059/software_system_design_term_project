public class ElevatorFactoryFactory {
    private ElevatorFactoryFactory() {}

    public static ElevatorFactory getElevatorFactory(DeviceVendor deviceVendor) {
        ElevatorFactory elevatorFactory = null;
        switch (deviceVendor) {
            case LG -> elevatorFactory = new LGElevatorFactory();
            case Samsung -> elevatorFactory = new SamsungElevatorFactory();
            case Hyundai -> elevatorFactory = new HyundaiElevatorFactory();
        }
        return elevatorFactory;
    }
}
