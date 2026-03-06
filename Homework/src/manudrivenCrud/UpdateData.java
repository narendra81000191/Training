package manudrivenCrud;

public class UpdateData {
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


}
