package jdbc.JDBCPROJECT;

	import java.sql.*;
	import java.util.Scanner;

	public class Manudrivencrud {

	    // ====== EDIT THESE FOR YOUR DB ======
	    // MySQL example:
	    private static final String DB_URL  = "jdbc:mysql://localhost:3306/cfgdb?useSSL=false&serverTimezone=UTC";
	    private static final String DB_USER = "user1";
	    private static final String DB_PASS = "user@123";

	    // If you use PostgreSQL, use:
	    // private static final String DB_URL = "jdbc:postgresql://localhost:5432/demo_db";
	    // private static final String DB_USER = "postgres";
	    // private static final String DB_PASS = "your_password";
	    // ====================================

	    private static final Scanner sc = new Scanner(System.in);

	    public static void main(String[] args) {
	        ensureTable();

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

	    // ---------- Menu ----------
	    private static void printMenu() {
	        System.out.println("====== STUDENT CRUD MENU ======");
	        System.out.println("1. Create Student");
	        System.out.println("2. Read Student by ID");
	        System.out.println("3. Read All Students");
	        System.out.println("4. Update Student");
	        System.out.println("5. Delete Student");
	        System.out.println("0. Exit");
	    }

	    // ---------- DB Setup ----------
	    private static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	    }

	    private static void ensureTable() {
	        String sql = """
	            CREATE TABLE IF NOT EXISTS students (
	                id INT PRIMARY KEY AUTO_INCREMENT,
	                name VARCHAR(100) NOT NULL,
	                email VARCHAR(100) UNIQUE NOT NULL,
	                age INT NOT NULL
	            )
	            """;

	        // For PostgreSQL, replace AUTO_INCREMENT with:
	        // id SERIAL PRIMARY KEY

	        try (Connection con = getConnection();
	             Statement st = con.createStatement()) {
	            st.execute(sql);
	        } catch (SQLException e) {
	            System.err.println("Failed to ensure table: " + e.getMessage());
	        }
	    }

	    // ---------- CRUD Operations ----------
	    private static void createStudent() {
	        System.out.println("-- Create Student --");
	        String name = readStr("Name: ");
	        String email = readStr("Email: ");
	        int age = readInt("Age: ");

	        String sql = "INSERT INTO students(name, email, age) VALUES(?,?,?)";

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	            ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setInt(3, age);
	            int affected = ps.executeUpdate();

	            if (affected > 0) {
	                try (ResultSet rs = ps.getGeneratedKeys()) {
	                    if (rs.next()) {
	                        int id = rs.getInt(1);
	                        System.out.println("Created student with ID: " + id);
	                    } else {
	                        System.out.println("Created, but no ID returned.");
	                    }
	                }
	            } else {
	                System.out.println("Create failed.");
	            }
	        } catch (SQLException e) {
	            System.err.println("Create failed: " + e.getMessage());
	        }
	    }

	    private static void readStudentById() {
	        System.out.println("-- Read Student by ID --");
	        int id = readInt("ID: ");

	        String sql = "SELECT id, name, email, age FROM students WHERE id = ?";

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {
	            ps.setInt(1, id);

	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    printRow(rs);
	                } else {
	                    System.out.println("Not found.");
	                }
	            }
	        } catch (SQLException e) {
	            System.err.println("Read failed: " + e.getMessage());
	        }
	    }

	    private static void readAllStudents() {
	        System.out.println("-- Read All Students --");
	        String sql = "SELECT id, name, email, age FROM students ORDER BY id";

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            boolean any = false;
	            while (rs.next()) {
	                any = true;
	                printRow(rs);
	            }
	            if (!any) {
	                System.out.println("No records.");
	            }
	        } catch (SQLException e) {
	            System.err.println("Read all failed: " + e.getMessage());
	        }
	    }

	    private static void updateStudent() {
	        System.out.println("-- Update Student --");
	        int id = readInt("ID to update: ");

	        // Fetch current
	        String getSql = "SELECT id, name, email, age FROM students WHERE id = ?";
	        try (Connection con = getConnection();
	             PreparedStatement getPs = con.prepareStatement(getSql)) {
	            getPs.setInt(1, id);

	            try (ResultSet rs = getPs.executeQuery()) {
	                if (!rs.next()) {
	                    System.out.println("Not found.");
	                    return;
	                }
	                String curName = rs.getString("name");
	                String curEmail = rs.getString("email");
	                int curAge = rs.getInt("age");

	                System.out.println("Current: ");
	                printRow(rs);

	                // Prompt new values
	                String name = readStr("New Name (blank = keep '" + curName + "'): ");
	                String email = readStr("New Email (blank = keep '" + curEmail + "'): ");
	                String ageStr = readStr("New Age (blank = keep '" + curAge + "'): ");

	                String newName = name.isBlank() ? curName : name;
	                String newEmail = email.isBlank() ? curEmail : email;
	                int newAge = ageStr.isBlank() ? curAge : Integer.parseInt(ageStr.trim());

	                String updSql = "UPDATE students SET name = ?, email = ?, age = ? WHERE id = ?";
	                try (PreparedStatement updPs = con.prepareStatement(updSql)) {
	                    updPs.setString(1, newName);
	                    updPs.setString(2, newEmail);
	                    updPs.setInt(3, newAge);
	                    updPs.setInt(4, id);

	                    int affected = updPs.executeUpdate();
	                    System.out.println(affected > 0 ? "Updated." : "Update failed.");
	                }
	            }
	        } catch (SQLException e) {
	            System.err.println("Update failed: " + e.getMessage());
	        } catch (NumberFormatException e) {
	            System.err.println("Age must be a number.");
	        }
	    }

	    private static void deleteStudent() {
	        System.out.println("-- Delete Student --");
	        int id = readInt("ID to delete: ");

	        String sql = "DELETE FROM students WHERE id = ?";

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {
	            ps.setInt(1, id);
	            int affected = ps.executeUpdate();
	            System.out.println(affected > 0 ? "Deleted." : "Delete failed or not found.");
	        } catch (SQLException e) {
	            System.err.println("Delete failed: " + e.getMessage());
	        }
	    }

	    // ---------- Helpers ----------
	    private static void printRow(ResultSet rs) throws SQLException {
	        int id = rs.getInt("id");
	        String name = rs.getString("name");
	        String email = rs.getString("email");
	        int age = rs.getInt("age");
	        System.out.printf("Student{id=%d, name='%s', email='%s', age=%d}%n", id, name, email, age);
	    }

	    private static int readInt(String prompt) {
	        while (true) {
	            try {
	                System.out.print(prompt);
	                String line = sc.nextLine().trim();
	                return Integer.parseInt(line);
	            } catch (NumberFormatException e) {
	                System.out.println("Please enter a valid number.");
	            }
	        }
	    }

	    private static String readStr(String prompt) {
	        System.out.print(prompt);
	        return sc.nextLine();
	    }
	}


