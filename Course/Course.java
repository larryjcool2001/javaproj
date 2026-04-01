package Course;

public class Course {

   private String courseCode;
   private String courseName;
   private int maxCapacity;
   private int currentEnrollment;

   private static int totalEnrolledStudents = 0;

   public Course(String courseCode, String courseName, int maxCapacity) {
       this.courseCode = courseCode;
       this.courseName = courseName;
       this.maxCapacity = maxCapacity;
       this.currentEnrollment = 0;
   }

   // Getters
   public String getCourseCode() {
       return courseCode;
   }

   public String getCourseName() {
       return courseName;
   }

   public int getMaxCapacity() {
       return maxCapacity;
   }

   // Course Update Feature
   public void updateCourse(String name, int capacity) {
       this.courseName = name;
       this.maxCapacity = capacity;
   }

   // Add student to course
   public boolean addStudent() {
       if (currentEnrollment < maxCapacity) {
           currentEnrollment++;
           totalEnrolledStudents++;
           return true;
       }
       return false;
   }

   // Static method to track total enrolled students
   public static int getTotalEnrolledStudents() {
       return totalEnrolledStudents;
   }
}
