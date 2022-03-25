import java.util.*;
import java.util.Vector; 
import java.util.Enumeration; 

public class Course {
	
	private String title;
	private Vector courseRecords;
	
	Course() {
		courseRecords=new Vector();
	}

	public String getTitle() {
		return title;
	} 

	public void setTitle( String t) {
		title=t;
	}

	public void addCourseRecord(CourseRecord cr) { 
		courseRecords.addElement(cr);
	}
	
	public Enumeration getCourseRecords() { 
		return courseRecords.elements();
	}
	
	public void printCourseStudents() {
		
		for(int i=0; i < courseRecords.size(); i++) {
			CourseRecord enrolled =  (CourseRecord) courseRecords.get(i);
			Student std = enrolled.getStudent();
			System.out.println(std.getName());
		}
		
	}
	
	public void printBestStudent() {
		
		// default average for a student
		CourseRecord bestStudent = (CourseRecord) courseRecords.get(0);
		
		for(int i=1; i < courseRecords.size(); i++) {
			
			CourseRecord temp = (CourseRecord) courseRecords.get(i);
			
			try {
            
				if (temp.average() > bestStudent.average()) 
	                bestStudent = temp;	           
	            
			}catch (NotYetSetException e){
                e.printStackTrace();
            }
		}
		
		  System.out.println(bestStudent.getStudent());
		
	}
	
	public void printFinalExamStudents() {
		
		for(int i=1; i < courseRecords.size(); i++) {
			
			CourseRecord enrolled = (CourseRecord) courseRecords.get(i);
			
			if(enrolled.canTakeFinalExam()) {
				Student std = enrolled.getStudent();
				System.out.println(std.getName());
			}
		
		}
	}
}
