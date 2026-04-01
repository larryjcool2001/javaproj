import java.util.Scanner;

public class StudentManagementSystem {

static String[] names = new String[100];
static int[] ids = new int[100];
static int[] ages = new int[100];
static String[] grades = new String[100];
static int totalStudents = 0;

static Scanner scanner = new Scanner(System.in);

public static void addStudent() {

try {

System.out.print("Enter Student ID: ");
int id = scanner.nextInt();
scanner.nextLine();

System.out.print("Enter Student Name: ");
String name = scanner.nextLine();

System.out.print("Enter Student Age: ");
int age = scanner.nextInt();
scanner.nextLine();

System.out.print("Enter Student Grade: ");
String grade = scanner.nextLine();

ids[totalStudents] = id;
names[totalStudents] = name;
ages[totalStudents] = age;
grades[totalStudents] = grade;

totalStudents++;

System.out.println("Student added successfully!");

} catch(Exception e) {

System.out.println("Invalid input");
scanner.nextLine();

}

}

public static void viewStudent() {

System.out.print("Enter Student ID: ");
int id = scanner.nextInt();

boolean found = false;

for(int i=0;i<totalStudents;i++){

if(ids[i]==id){

System.out.println("Name:"+names[i]);
System.out.println("Age:"+ages[i]);
System.out.println("Grade:"+grades[i]);

found=true;
break;

}

}

if(!found){

System.out.println("Student not found");

}

}

public static void updateStudent(){

System.out.print("Enter Student ID:");
int id = scanner.nextInt();
scanner.nextLine();

boolean found=false;

for(int i=0;i<totalStudents;i++){

if(ids[i]==id){

System.out.print("New Name:");
names[i]=scanner.nextLine();

System.out.print("New Age:");
ages[i]=scanner.nextInt();
scanner.nextLine();

System.out.print("New Grade:");
grades[i]=scanner.nextLine();

System.out.println("Updated Successfully");

found=true;
break;

}

}

if(!found){

System.out.println("Student not found");

}

}

public static void main(String[] args){

while(true){

System.out.println("1.Add Student");
System.out.println("2.View Student");
System.out.println("3.Update Student");
System.out.println("4.Exit");

int choice=scanner.nextInt();

switch(choice){

case 1:addStudent();break;
case 2:viewStudent();break;
case 3:updateStudent();break;
case 4:System.exit(0);

}

}

}

}
