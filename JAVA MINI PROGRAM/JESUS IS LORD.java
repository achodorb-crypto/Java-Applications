import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

class Patient {
    private String patientId;
    private String name;
    private int age;
    private String gender;
    private String contactNumber;
    private String address;
    private String medicalHistory;
    private LocalDate admissionDate;
    private String assignedDoctor;
    private String roomNumber;
    private boolean isDischarged;

    public Patient(String patientId, String name, int age, String gender, 
                   String contactNumber, String address, String medicalHistory,
                   LocalDate admissionDate, String assignedDoctor, String roomNumber) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.address = address;
        this.medicalHistory = medicalHistory;
        this.admissionDate = admissionDate;
        this.assignedDoctor = assignedDoctor;
        this.roomNumber = roomNumber;
        this.isDischarged = false;
		
		//GETTERS(ACCESSORS) 
		//It gives you access to the patient's details.
	public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getContactNumber() { return contactNumber; }
    public String getAddress() { return address; }
    public String getMedicalHistory() { return medicalHistory; }
    public LocalDate getAdmissionDate() { return admissionDate; }
    public String getAssignedDoctor() { return assignedDoctor; }
    public String getRoomNumber() { return roomNumber; }
    public boolean isDischarged() { return isDischarged; }
	
    //SETTERS(MUTATORS/CHANGES):I added this because it helps to change patients hospital records 
	//and these are the things i felt can be changed at any time.
	//it helps in encapsulation,data validation and flexibity
    public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }
    public void setAssignedDoctor(String assignedDoctor) { this.assignedDoctor = assignedDoctor; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    public void dischargePatient() { this.isDischarged = true; }
    public void updateContact(String contact) { this.contactNumber = contact; }
    public void updateAddress(String address) { this.address = address; }
	
	@Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Age: %d | Gender: %s | Doctor: %s | Room: %s | Status: %s",
                patientId, name, age, gender, assignedDoctor, roomNumber,
                isDischarged ? "DISCHARGED" : "ADMITTED");
    }
	public String toFileFormat() {
        return String.format("%d|%s|%d|%s|%s|%s|%s|%s|%s|%s|%b",
                patientId, name, age, gender, contactNumber, address,
                medicalHistory.replace("|", "&#124;"), // Escape pipe character which is another meaning for OR.
                admissionDate.toString(), assignedDoctor, roomNumber, isDischarged);
    }
	
	public static Patient fromFileFormat(String line) {
        String[] parts = line.split("\\|", -1); // The -1 means that you shouldn't leave out anything even if it's empty.
		// The double back slash means that we shouldn't treat any character differently. 
        if (parts.length < 11) return null;
        
        try {
            LocalDate admissionDate = LocalDate.parse(parts[7]);
            boolean isDischarged = Boolean.parseBoolean(parts[10]);
            Patient patient = new Patient(
                    parts[0], parts[1], Integer.parseInt(parts[2]), 
                    parts[3], parts[4], parts[5], parts[6].replace("&#124;", "|"),
                    admissionDate, parts[8], parts[9]);
            if (isDischarged) patient.dischargePatient();
            return patient;
        } catch (Exception e) {
            System.err.println("Sorry please there is an error: " + e.getMessage());
            return null;
        }
    }

    }


public class HospitalManagement{
	public static void main(String[] args){
		Scanner scan = new Scanner(system.in);
		int select;
        while (true) {
            System.out.println("Welcome to Haven's Cardiovascular");
            System.out.println("Please write your following required details ");
            System.out.println("1. Option 1");
            System.out.println("2. option 2");
			System.out.println("2. option 2");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("What is your name?:");
                    break;
                case 2:
                    System.out.println("How old are you?");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return; // Exit loop and program
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
	}
	
}