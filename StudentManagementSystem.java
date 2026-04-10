import java.util.*;

// Student Class
class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

// Main Class
public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Add\n2. View\n3. Update\n4. Delete\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    // ADD
    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added!");
    }

    // VIEW
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    // UPDATE
    static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                sc.nextLine();

                System.out.print("Enter new name: ");
                s.name = sc.nextLine();

                System.out.print("Enter new marks: ");
                s.marks = sc.nextDouble();

                System.out.println("Updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // DELETE
    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            Student s = it.next();
            if (s.id == id) {
                it.remove();
                System.out.println("Deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }
}