
public class ElevatorMotor {
	private ElevatorController elevatorController ;
	private MotorStatus motorStatus ;
	private DeviceVendor motorVendor;
	
	public ElevatorMotor(DeviceVendor motorVendor) {
		this.motorVendor = motorVendor;
		motorStatus = MotorStatus.STOPPED ;
	}
	public void setElevatorController(ElevatorController elevatorController) {
		this.elevatorController = elevatorController ;
	}
	public MotorStatus getMotorStatus() {
		return motorStatus;
	}
	private void setMotorStatus(MotorStatus motorStatus) {
		this.motorStatus = motorStatus;
	}
	public void move(int currentFloor, ElevatorDirection elevatorDirection) {
		if (  getMotorStatus() == MotorStatus.MOVING ) return ;
		
		assert elevatorController != null;
		DoorStatus doorStatus = elevatorController.getDoorStatus(currentFloor) ;
		if ( doorStatus == DoorStatus.OPEN )
			return;
		
		switch ( motorVendor ) {
		case Hyundai:
			System.out.println("move Hyundai Motor, Direction: " + elevatorDirection) ;
			break;
		case LG:
			System.out.println("move LG Motor, Direction: " + elevatorDirection) ;
			break;
		case Samsung:
			System.out.println("move Samsung Motor, Direction: " + elevatorDirection) ;
			break;
		default:
			break;
		}
		setMotorStatus(MotorStatus.MOVING) ;
	}
	public void stop() {
		switch ( motorVendor ) {
		case Hyundai:
			System.out.println("Hyundai Elevator Motor Stop") ;
			break;
		case LG:
			System.out.println("LG Elevator Motor Stop") ;
			break;
		case Samsung:
			System.out.println("Samsung Elevator Motor Stop") ;
			break;
		default:
			break;
		}
		setMotorStatus(MotorStatus.STOPPED);
	}
}
