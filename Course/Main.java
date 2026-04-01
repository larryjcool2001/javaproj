package Course;
import java.util.*;

public class Main {

   public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);
       Map<String, Student> students = new HashMap<>();

       while (true) {

           System.out.println("\n===== Course Enrollment System =====");
           System.out.println("1. Add Course");
           System.out.println("2. Enroll Student");
           System.out.println("3. Assign Grade");
           System.out.println("4. Calculate Overall Grade");
           System.out.println("5. Update Student");
           System.out.println("6. Update Course");
           System.out.println("7. View Total Enrollments");
           System.out.println("8. Exit");

           int choice = scanner.nextInt();
           scanner.nextLine();

           try {
               double grade;
               switch (choice) {

                   case 1:
                       System.out.print("Course Code: ");
                       String code = scanner.nextLine();
                       System.out.print("Course Name: ");
                       String name = scanner.nextLine();
                       System.out.print("Max Capacity: ");
                       int capacity = scanner.nextInt();
                       CourseManagement.addCourse(code, name, capacity);
                       break;

                   case 2:
                       System.out.print("Student Name: ");
                       String sName = scanner.nextLine();
                       System.out.print("Student ID: ");
                       String sId = scanner.nextLine();

                       Student student = students.getOrDefault(sId, new Student(sName, sId));
                       students.put(sId, student);

                       System.out.print("Course Code: ");
                       String enrollCode = scanner.nextLine();
                       Course course = CourseManagement.findCourse(enrollCode);

                       CourseManagement.enrollStudent(student, course);
                       break;

                   case 3:
                       System.out.print("Student ID: ");
                       sId = scanner.nextLine();
                       student = students.get(sId);

                       System.out.print("Course Code: ");
                       enrollCode = scanner.nextLine();
                       course = CourseManagement.findCourse(enrollCode);

                       System.out.print("Grade: ");
                       grade = scanner.nextDouble();

                       CourseManagement.assignGrade(student, course, grade);
                       break;

                   case 4:
                       System.out.print("Student ID: ");
                       sId = scanner.nextLine();
                       student = students.get(sId);
                       CourseManagement.calculateOverallGrade(student);
                       break;

                   case 5:
                       System.out.print("Student ID: ");
                       sId = scanner.nextLine();
                       student = students.get(sId);

                       System.out.print("New Name: ");
                       student.setName(scanner.nextLine());
                       System.out.println("Student updated.");
                       break;

                   case 6:
                       System.out.print("Course Code: ");
                       code = scanner.nextLine();
                       course = CourseManagement.findCourse(code);

                       System.out.print("New Name: ");
                       name = scanner.nextLine();
                       System.out.print("New Capacity: ");
                       capacity = scanner.nextInt();

                       course.updateCourse(name, capacity);
                       System.out.println("Course updated.");
                       break;

                   case 7:
                       System.out.println("Total Enrolled Students Across All Courses: "
                               + Course.getTotalEnrolledStudents());
                       break;

                   case 8:
                       System.out.println("Exiting...");
                       scanner.close();
                       return;

                   default:
                       System.out.println("Invalid option.");
               }

           } catch (Exception e) {
               System.out.println("Error: Invalid input.");
               scanner.nextLine();
           }
       }
   }
}
