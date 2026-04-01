package Course;

import java.util.*;

public class CourseManagement {

   private static List<Course> courseList = new ArrayList<>();
   private static Map<Student, Double> overallGrades = new HashMap<>();

   // Add Course
   public static void addCourse(String code, String name, int capacity) {
       Course course = new Course(code, name, capacity);
       courseList.add(course);
       System.out.println("Course added successfully.");
   }

   // Remove Course
   public static void removeCourse(String code) {
       courseList.removeIf(course -> course.getCourseCode().equals(code));
       System.out.println("Course removed.");
   }

   // Find Course
   public static Course findCourse(String code) {
       for (Course course : courseList) {
           if (course.getCourseCode().equals(code)) {
               return course;
           }
       }
       return null;
   }

   // Enroll Student
   public static void enrollStudent(Student student, Course course) {
       if (course != null) {
           student.enrollCourse(course);
       } else {
           System.out.println("Course not found.");
       }
   }

   // Assign Grade
   public static void assignGrade(Student student, Course course, double grade) {
       student.assignGrade(course, grade);
   }

   // Calculate Overall Grade
   public static void calculateOverallGrade(Student student) {
       double total = 0;
       int count = 0;

       for (Double grade : student.getEnrolledCourses().values()) {
           if (grade != null) {
               total += grade;
               count++;
           }
       }

       if (count > 0) {
           double average = total / count;
           overallGrades.put(student, average);
           System.out.println("Overall Grade: " + average);
       } else {
           System.out.println("No grades available.");
       }
   }

   public static void displayCourses() {
       for (Course c : courseList) {
           System.out.println(c.getCourseCode() + " - " + c.getCourseName());
       }
   }
}
