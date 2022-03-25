import java.util.*;
import java.util.Vector; 
import java.util.Enumeration;

public class CourseRecord {
	
	private Student student; 
	private Vector assignments;
	
	CourseRecord() {
		assignments=new Vector();
	} 
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student s) { 
		student = s;
	}
	
	public void addAssignment(Assignment a) { 
		assignments.addElement(a);
	}
	
	public Enumeration getAssignments() { 
		return assignments.elements();
	}

	public double average() throws NotYetSetException{
		
		
		double sum = 0.0;
		
		// traverse the vector
		
		for(int i=0; i < assignments.size(); i++) {
			
			Assignment studentMark = (Assignment) assignments.get(i);
			
			if (studentMark.getMark() == -1){
				throw new
				NotYetSetException("Mark is not yet set");
			}
			
			// calculate sum of student marks
			sum+=studentMark.getMark();
			
		}
		
		// calculate their average
		return sum/assignments.size();
	
	}
	
	public boolean canTakeFinalExam() {
		
		int marksNumber = 0;
		
		for(int i = 0; i < assignments.size(); i++) {
			
			Assignment studentMark = (Assignment) assignments.get(i);
			
			try {
				if (studentMark.getMark() > 0)
					marksNumber++;
			}catch (NotYetSetException e){
                e.printStackTrace();
            }
			
		}
		
		return marksNumber >= 3 ? true : false;
		
	}

}
