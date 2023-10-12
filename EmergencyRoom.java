
import java.time.LocalTime;
import java.util.Comparator;

public class EmergencyRoom {
	
	private final ComparatorHeap<Patient> line;
	
	public EmergencyRoom(Comparator<Patient> comp) {
		
		line = new ComparatorHeap<>(comp);
	}
	
	public void checkIn(Patient newPatient, Severity severity) {
		
		newPatient.setArrivalTime(LocalTime.now());
		newPatient.setSeverity(severity);
		line.add(newPatient);
		
	}
	
	public Patient admit() {
		return line.remove();
	}
	
}
