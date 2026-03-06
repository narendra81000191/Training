package jdbc.JDBCPROJECT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    // === Moved from inside main (must be class-level) ===
    public static final String uname = "user1";
    public static final String password = "user@123";
    public static final String url = "jdbc:mysql://localhost:3306/cfgdb";

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
            System.out.println("Hello World!");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded");

            // Just to verify connectivity once:
            Connection con = DriverManager.getConnection(url, uname, password))
                System.out.println("connection establish");
            
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
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("DB error: " + e.getMessage());
        }
    }

    // ---------- Menu ----------
    public static void printMenu() {
        System.out.println("====== STUDENT CRUD MENU ======");
        System.out.println("1. Create Student");
        System.out.println("2. Read Student by ID");
        System.out.println("3. Read All Students");
        System.out.println("4. Update Student Marks");
        System.out.println("5. Delete Student");
        System.out.println("0. Exit");
    }

    
    public static void createStudent() {
        System.out.println("-- Create Student --");
        String name = readStr("Name: ");
        long phone = readLong("Phone: ");
        String address = readStr("Address: ");
        String dob = readStr("DOB (e.g., 2003-11-06 or text if column is VARCHAR): ");
        int marks = readInt("Marks: ");

        // Your original query had 5 placeholders; specifying columns makes it safe.
        String query = "INSERT INTO student(name, phone, address, dob, marks) VALUES(?,?,?,?,?)";

        Connection con = DriverManager.getConnection(url, uname, password);
             PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, name);
            ps.setLong(2, phone);
            ps.setString(3, address);
            ps.setString(4, dob);   // if column is DATE, adjust to java.sql.Date
            ps.setInt(5, marks);
            int affected = ps.executeUpdate();
            System.out.println(affected > 0 ? "Row inserted" : "Insert failed");}
        
           
       
   

    public static void updateStudent() {
        System.out.println("-- Update Student Marks --");
        int id = readInt("Student ID to update: ");
        int marks = readInt("New Marks: ");

        String query = "UPDATE student SET marks = ? WHERE student_id = ?";

         (Connection con = DriverManager.getConnection(url, uname, password);
             PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, marks);
            ps.setInt(2, id);
            int affected = ps.executeUpdate();
            System.out.println(affected > 0 ? "Row updated" : "Update failed or ID not found");
            }
        
            
        
    

    public static void deleteStudent() {
        System.out.println("-- Delete Student --");
        int id = readInt("Student ID to delete: ");

        // Fixed typos: 'form' -> 'from', 'stdudent_id' -> 'student_id'
        String query = "DELETE FROM student WHERE student_id = ?";

        Connection con = DriverManager.getConnection(url, uname, password);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            System.out.println(affected > 0 ? "Row deleted" : "Delete failed or ID not found");
        } 
    }

    private static void readAllStudents() {
        System.out.println("-- All Students --");
        String query = "SELECT * FROM student";

        try (Connection con = DriverManager.getConnection(url, uname, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();
            // Print header
            for (int i = 1; i <= count; i++) {
                System.out.print(rsmd.getColumnName(i));
                if (i < count) System.out.print(" | ");
            }
            System.out.println();
            // Print rows
            boolean any = false;
            while (rs.next()) {
                any = true;
                for (int i = 1; i <= count; i++) {
                    System.out.print(rs.getString(i));
                    if (i < count) System.out.print(" | ");
                }
                System.out.println();
            }
            if (!any) System.out.println("No records found.");
        } catch (SQLException e) {
            System.err.println("Read-all failed: " + e.getMessage());
        }
    }

    private static void readStudentById() {
        System.out.println("-- Read Student by ID --");
        int id = readInt("Student ID: ");
        String query = "SELECT * FROM student WHERE student_id = ?";

        Connection con = DriverManager.getConnection(url, uname, password);
             PreparedStatement ps = con.prepareStatement(query))
{
              ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    System.out.println("No record found.");
                    return;
                }
                ResultSetMetaData rsmd = rs.getMetaData();
                int count = rsmd.getColumnCount();
                for (int i = 1; i <= count; i++) {
                    System.out.print(rsmd.getColumnName(i) + "=" + rs.getString(i));
                    if (i < count) System.out.print(", ");
                }
                System.out.println();
            }
        }
    }

   
    private static int readInt(String prompt) {
        
            
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            
        }
    

    private static long readLong(String prompt) {
        
            
                System.out.print(prompt);
                return Long.parseLong(sc.nextLine().trim());
    }
    

    private static String readStr(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
}