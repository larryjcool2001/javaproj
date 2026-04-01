package Course;
import java.util.HashMap;
import java.util.Map;

public class Student {

   private String name;
   private String studentId;
   private Map<Course, Double> enrolledCourses; // Course + Grade

   public Student(String name, String studentId) {
       this.name = name;
       this.studentId = studentId;
       this.enrolledCourses = new HashMap<>();
   }

   // Getters
   public String getName() {
       return name;
   }

   public String getStudentId() {
       return studentId;
   }

   public Map<Course, Double> getEnrolledCourses() {
       return enrolledCourses;
   }

   // Setters (Student Update Feature)
   public void setName(String name) {
       this.name = name;
   }

   public void setStudentId(String studentId) {
       this.studentId = studentId;
   }

   // Enroll in Course
   public void enrollCourse(Course course) {
       if (course.addStudent()) {
           enrolledCourses.put(course, null);
           System.out.println("Student enrolled successfully.");
       } else {
           System.out.println("Course is at maximum capacity.");
       }
   }

   // Assign Grade
   public void assignGrade(Course course, double grade) {
       if (enrolledCourses.containsKey(course)) {
           enrolledCourses.put(course, grade);
           System.out.println("Grade assigned successfully.");
       } else {
           System.out.println("Student is not enrolled in this course.");
       }
   }
}
