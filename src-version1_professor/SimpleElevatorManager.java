import java.util.Calendar;
import java.util.List;
class SimpleElevatorManager {
	private List<ElevatorController> elevatorControllers ;

	public SimpleElevatorManager(List<ElevatorController> elevatorControllers) {
		this.elevatorControllers = elevatorControllers;
	}	
	public void requestElevator(Floor destination, Direction direction) {
		int index;
		// 0..23
		int hr = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) ;
		if ( hr < 12 ) { // ����; Response Time Scheduler
			index = elevatorControllers.size() -1;
			System.out.println("ResponseTimeScheduler selects " + index);
		}
		else { // ����; Throughput Scheduler
			index = 0;
			System.out.println("ThroughputScheduler selects " + index);
		}
		elevatorControllers.get(index).goTo(destination) ;
	}
	public void emergencyStop(boolean goTo1stFloor) {
		for ( ElevatorController ctrl: elevatorControllers )
			if ( goTo1stFloor ) {
				ctrl.getFloorstobeVisited().clear();
				ctrl.goTo(new Floor(1));
			}
			else
				ctrl.stop();
	}
	public boolean isToBeVisitedFloor(int floor) {
		for ( ElevatorController elevatorController: elevatorControllers ) {
			if ( elevatorController.getFloorstobeVisited().contains(floor) ) return true;
		}
		return false;
	}
	public void print() {
		for ( ElevatorController elevatorController: elevatorControllers ) {
			print(elevatorController);
		}
	}
	private void print(ElevatorController ctrl) {
		System.out.println(ctrl.getCurrentFloor());
		System.out.println(ctrl.getElevatorDirection());
		System.out.println(ctrl.getFloorstobeVisited());
	}
}