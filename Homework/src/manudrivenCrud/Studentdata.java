package manudrivenCrud;

import java.util.*;

/**
 * Menu-driven CRUD using Collection (HashMap).
 * Entity: Student (id, name, age, department)
 */
public class Studentdata{

    // ---- Entity ----
    static class Student {
        private final int id;
        private String name;
        private int age;
        private String department;

        public Student(int id, String name, int age, String department) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.department = department;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getDepartment() { return department; }

        public void setName(String name) { this.name = name; }
        public void setAge(int age) { this.age = age; }
        public void setDepartment(String department) { this.department = department; }

        @Override
        public String toString() {
            return String.format("ID=%d, Name=%s, Age=%d, Dept=%s", id, name, age, department);
            
        }
    }
    private static final Map<Integer, Student> db = new HashMap<>();
    private static final Scanner sc = new Scanner(System.in);
    private static int autoId = 1001;

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt("Choose an option: ");
            switch (choice) {
                case 1 -> createStudent();
                case 2 -> readStudentById();
                case 3 -> readAllStudents();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 0 -> {
                    System.out.println("Exiting. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }
    }