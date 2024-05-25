import java.util.Calendar;
import java.util.List;
class SimpleElevatorManager {
	private List<ElevatorController> elevatorControllers ;

	public SimpleElevatorManager(List<ElevatorController> elevatorControllers) {
		this.elevatorControllers = elevatorControllers;
	}	
	public void requestElevator(Floor destination, Direction direction) {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		int index = getIndexOfElevatorControllers(hour);

		elevatorControllers.get(index).goTo(destination) ;
	}

	private int getIndexOfElevatorControllers(int hour) {
		int index;
		if ( hour < 12 ) {
			index = elevatorControllers.size() -1;
			System.out.println("ResponseTimeScheduler selects " + index);
		}
		else {
			index = 0;
			System.out.println("ThroughputScheduler selects " + index);
		}
		return index;
	}
	public void emergencyStop(boolean goTo1stFloor) {
		for ( ElevatorController controller: elevatorControllers )
			if ( goTo1stFloor ) {
				controller.getFloorstobeVisited().clear();
				controller.goTo(new Floor(1));
			}
			else
				controller.stop();
	}
	public boolean isToBeVisitedFloor(Floor floor) {
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
	private void print(ElevatorController controller) {
		System.out.println(controller.getCurrentFloor());
		System.out.println(controller.getElevatorDirection());
		System.out.println(controller.getFloorstobeVisited());
	}
}