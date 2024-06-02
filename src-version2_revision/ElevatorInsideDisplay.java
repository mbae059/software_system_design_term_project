package theClasses;
public class ElevatorInsideDisplay {
	private ElevatorController elevatorController ;
	public ElevatorInsideDisplay(ElevatorController elevatorController) {
		this.elevatorController = elevatorController ;
	}
	public void update() {
		int currentFloor = elevatorController.getCurrentFloor() ;
		System.out.println("Elevator Inside Display: " + currentFloor) ;
	}
}
