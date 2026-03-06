package manudrivenCrud;

public class Deletedata {
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


}
