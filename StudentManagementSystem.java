
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    double marks;

    // Constructor
    Student(int rollNumber, String name, double marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
    }

    // Display student details
    void display() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("----------------------");
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add student
    static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        if (findStudent(roll) != null || roll <= 0) {
            System.out.println("Invalid or duplicate roll number!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        System.out.print("Enter Marks (0-100): ");
        double marks = sc.nextDouble();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks!");
            return;
        }

        students.add(new Student(roll, name, marks));

        System.out.println("Student added successfully!");
    }

    // View students
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found!");
            return;
        }

        System.out.println("\n===== Student Records =====");

        for (Student s : students) {
            s.display();
        }
    }

    // Find student by roll number
    static Student findStudent(int roll) {
        for (Student s : students) {
            if (s.rollNumber == roll) {
                return s;
            }
        }
        return null;
    }

    // Update student
    static void updateStudent() {
        System.out.print("Enter Roll Number to Update: ");
        int roll = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(roll);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        System.out.print("Enter New Marks (0-100): ");
        double marks = sc.nextDouble();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks!");
            return;
        }

        s.name = name;
        s.marks = marks;

        System.out.println("Student updated successfully!");
    }

    // Delete student
    static void deleteStudent() {
        System.out.print("Enter Roll Number to Delete: ");
        int roll = sc.nextInt();

        Student s = findStudent(roll);

        if (s == null) {
            System.out.println("Student not found!");
        } else {
            students.remove(s);
            System.out.println("Student deleted successfully!");
        }
    }

    // Main method
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
