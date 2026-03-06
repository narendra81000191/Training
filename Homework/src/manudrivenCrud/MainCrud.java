package manudrivenCrud;
import java.util.*;

/**
 * Menu-driven CRUD using Collection (HashMap).
 * Entity: Student (id, name, age, department)
 */
public class MainCrud {

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

    // ---- "Database" using a Collection ----
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

    // ---- Menu ----
    private static void printMenu() {
        System.out.println("======== Student CRUD (Collection: HashMap) ========");
        System.out.println("1. Create Student");
        System.out.println("2. Read Student by ID");
        System.out.println("3. Read All Students");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("0. Exit");
        System.out.println("====================================================");
    }

    // ---- CRUD: Create ----
    private static void createStudent() {
        System.out.println("-- Create Student --");
        String name = readNonEmptyLine("Enter name: ");
        int age = readInt("Enter age: ");
        String dept = readNonEmptyLine("Enter department: ");

        int id = autoId++;
        Student s = new Student(id, name, age, dept);
        db.put(id, s);

        System.out.println("Created: " + s);
    }

    // ---- CRUD: Read ----
    private static void readStudentById() {
        System.out.println("-- Read Student by ID --");
        int id = readInt("Enter student ID: ");
        Student s = db.get(id);
        if (s == null) {
            System.out.println("No student found with ID " + id);
        } else {
            System.out.println("Found: " + s);
        }
    }

    private static void readAllStudents() {
        System.out.println("-- Read All Students --");
        if (db.isEmpty()) {
            System.out.println("No records.");
            return;
        }

        // Sort by ID for consistent output
        List<Student> list = new ArrayList<>(db.values());
        list.sort(Comparator.comparingInt(Student::getId));

        System.out.println(String.format("%-6s | %-20s | %-4s | %-12s", "ID", "Name", "Age", "Department"));
        System.out.println("-----------------------------------------------------");
        for (Student s : list) {
            System.out.println(String.format("%-6d | %-20s | %-4d | %-12s",
                    s.getId(), s.getName(), s.getAge(), s.getDepartment()));
        }
    }

    // ---- CRUD: Update ----
    private static void updateStudent() {
        System.out.println("-- Update Student --");
        int id = readInt("Enter student ID: ");
        Student s = db.get(id);
        if (s == null) {
            System.out.println("No student found with ID " + id);
            return;
        }

        System.out.println("Current: " + s);
        System.out.println("Press Enter to keep existing value.");

        String newName = readLineOptional("New name [" + s.getName() + "]: ");
        String newAgeStr = readLineOptional("New age [" + s.getAge() + "]: ");
        String newDept = readLineOptional("New department [" + s.getDepartment() + "]: ");

        if (!newName.isBlank()) s.setName(newName);
        if (!newAgeStr.isBlank()) {
            try {
                int newAge = Integer.parseInt(newAgeStr.trim());
                s.setAge(newAge);
            } catch (NumberFormatException e) {
                System.out.println("Invalid age. Keeping old value.");
            }
        }
        if (!newDept.isBlank()) s.setDepartment(newDept);

        System.out.println("Updated: " + s);
    }

    // ---- CRUD: Delete ----
    private static void deleteStudent() {
        System.out.println("-- Delete Student --");
        int id = readInt("Enter student ID: ");
        Student removed = db.remove(id);
        if (removed == null) {
            System.out.println("No student found with ID " + id);
        } else {
            System.out.println("Deleted: " + removed);
        }
    }

    // ---- Input Helpers ----
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static String readNonEmptyLine(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            if (!line.trim().isEmpty()) return line.trim();
            System.out.println("This field cannot be empty.");
        }
    }

    private static String readLineOptional(String prompt) {
        System.out.print(prompt);
        return sc.nextLine(); // may be empty
    }
}

