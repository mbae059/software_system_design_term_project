import java.util.Calendar;
import java.util.List;
class SimpleElevatorManager {
	private List<ElevatorController> elevatorControllers ;

	public SimpleElevatorManager(List<ElevatorController> elevatorControllers) {
		this.elevatorControllers = elevatorControllers;
	}	
	public void requestElevator(Floor destination, Direction direction) {
		int elevator = ElevatorSchedulerFactory.getElevatorScheduler().selectElevator(elevatorControllers, direction);
		elevatorControllers.get(elevator).goTo(destination);
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