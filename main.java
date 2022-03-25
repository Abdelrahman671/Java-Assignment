
public class main {

	public static void main(String[] args) {
		
		// Array of obj to decide num of students
		Student [] std = new Student[3];
		
		// initialize Student objects
		for(int i=0; i < std.length; i++)
			std[i] = new Student("Std_" + (i+1));
		
		// Initialize Assignments
		Assignment assign1 = new Assignment();
		Assignment assign2 = new Assignment();
		Assignment assign3 = new Assignment();
		
		// Set Marks for each Assignment
		assign1.setMark(45);
		assign2.setMark(15);
		assign3.setMark(30);
		
		// CourseRecord obj
		CourseRecord cr1 = new CourseRecord();
		CourseRecord cr2 = new CourseRecord();
		CourseRecord cr3 = new CourseRecord();
		
		// Add Assignments to CourseRecord
		cr1.addAssignment(assign1);
		cr1.addAssignment(assign2);
		cr1.addAssignment(assign3);
		
		// set a student in a CourseRecord
		cr1.setStudent(std[0]);
		cr1.setStudent(std[1]);
		
		cr2.setStudent(std[1]);
		cr3.setStudent(std[2]);
		
		// Test Marks Average of Assignments
		try {
		System.out.println("Test Average = " + cr1.average());
		}catch (NotYetSetException e){
            e.printStackTrace();
        }
		
		// Check if Student can take final exam
		System.out.println("Test if can an Exam: " + cr1.canTakeFinalExam());
		
		// Initialize a Course
		Course crs1 = new Course();
		Course crs2 = new Course();
		Course crs3 = new Course();
		
		// Add it to CourseRecord
		crs1.addCourseRecord(cr1);
		crs1.addCourseRecord(cr2);
		
		crs2.addCourseRecord(cr2);
		crs3.addCourseRecord(cr3);
		
		// Print student who has recorded in a course
		crs1.printCourseStudents(); // Test 
		
		// Check who is the best student by the assigned mark
		crs1.printBestStudent();
		
		crs1.printFinalExamStudents();
	}

}
