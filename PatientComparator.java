
import java.util.Comparator;

public class PatientComparator implements Comparator<Patient> {
	
	@Override
	public int compare(Patient patient1, Patient patient2) {
		int ret = patient2.getSeverity().compareTo(patient1.getSeverity());
		
		if(ret == 0) {
			
			ret = patient2.getAge().compareTo(patient1.getAge());
				if(ret == 0) {
					ret = patient2.getArrivalTime().compareTo(patient1.getArrivalTime());
				}
		}
		return ret;
	}
}
