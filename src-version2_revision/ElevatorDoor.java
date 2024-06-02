package theClasses;

public interface ElevatorDoor {
    DoorStatus getDoorStatus();
    void open();
    void close();
}



//public class ElevatorDoor {
//	private DeviceVendor deviceVendor;
//
//	private String elevatorDoorStatusForLG ;
//	private char elevatorDoorStatusForSamsung ;
//	private int elevatorDoorOpenedForHyundai ;
//
//	public ElevatorDoor(DeviceVendor deviceVendor) {
//		this.deviceVendor = deviceVendor;
//		
//		switch ( deviceVendor ) {
//		case LG:
//			elevatorDoorStatusForLG = "Closed";
//			break;
//		case Hyundai:
//			elevatorDoorOpenedForHyundai = 0;
//			break;
//		case Samsung:
//			elevatorDoorStatusForSamsung = 'C';
//			break;
//		}
//	}
//	public DoorStatus getDoorStatus() {
//		DoorStatus status = null;
//		switch ( deviceVendor ) {
//		case LG:
//			status = elevatorDoorStatusForLG.equals("Closed") ? DoorStatus.CLOSED : DoorStatus.OPEN;
//			break;
//		case Hyundai:
//			status = elevatorDoorOpenedForHyundai == 0 ? DoorStatus.CLOSED : DoorStatus.OPEN;
//			break;
//		case Samsung:
//			status = elevatorDoorStatusForSamsung == 'C' ? DoorStatus.CLOSED : DoorStatus.OPEN;
//			break;
//		}
//		return status;
//	}
//	public void open() {
//		switch ( deviceVendor ) {
//		case LG:
//			if ( elevatorDoorStatusForLG.equals("Opened") ) return ;
//			System.out.println("open LG Elevator Door") ;
//			elevatorDoorStatusForLG = "Opened";
//			break;
//		case Hyundai:
//			if ( elevatorDoorOpenedForHyundai == 1 ) return ;
//			System.out.println("open Hyundai Elevator Door") ;
//			elevatorDoorOpenedForHyundai = 1;
//			break;
//		case Samsung:
//			if ( elevatorDoorStatusForSamsung == 'O' ) return ;
//			System.out.println("open Samsung Elevator Door") ;
//			elevatorDoorStatusForSamsung = 'O';
//			break;
//		}	
//	}
//	public void close() {
//		switch ( deviceVendor ) {
//		case LG:
//			if ( elevatorDoorStatusForLG.equals("Closed") ) return ;
//			System.out.println("close LG Elevator Door") ;		
//			elevatorDoorStatusForLG = "Closed";
//			break;
//		case Hyundai:
//			if ( elevatorDoorOpenedForHyundai == 0  ) return ;
//			System.out.println("close Hyundai Elevator Door") ;		
//			elevatorDoorOpenedForHyundai = 0;
//			break;
//		case Samsung:
//			if ( elevatorDoorStatusForSamsung == 'C'  ) return ;
//			System.out.println("close Samsung Elevator Door") ;		
//			elevatorDoorStatusForSamsung = 'C';
//			break;
//		}
//	}
//}