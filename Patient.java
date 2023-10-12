import java.time.LocalTime;
import java.time.LocalDate;

public class Patient {
	
	private final String name;
	private final LocalDate dob;
	private Severity severity;
	private LocalTime arrivalTime;
	
	
	public Patient(String name, LocalDate dob) {
		
		this.name = name;
		this.dob = dob;
	}
	
	
	public void setSeverity(Severity sev) {
		this.severity = sev;
	}
	
	public void setArrivalTime(LocalTime arrivalT) {
		this.arrivalTime = arrivalT;
	}
	
	
	public String getName(){
		return name;
	}
	
	public LocalDate getAge() {
		return dob;
	}
	
	public Severity getSeverity() {
		return severity;
	}
	
	public LocalTime getArrivalTime() {
		
		return arrivalTime;
	}
	
	@Override
	public String toString() {
		
		return name + "\n DOB = " + dob + "\n Severity = " + severity + "\n Arrival Time is " + arrivalTime;
	}
	
}
