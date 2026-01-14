import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// ==================== PATIENT CLASS ====================
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
    }

    // Getters and Setters
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
                medicalHistory.replace("|", "&#124;"), // Escape pipe character
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
            System.err.println("Sorry please there is an error😔 " + e.getMessage());
            return null;
        }
    }
}

// ==================== STAFF CLASS ====================
class Staff {
    private String staffId;
    private String username;
    private String passwordHash;
    private String role; // "doctor", "nurse", "admin"
    private String department;

    public Staff(String staffId, String username, String password, String role, String department) {
        this.staffId = staffId;
        this.username = username;
        this.passwordHash = hashPassword(password);
        this.role = role;
        this.department = department;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error hashing password: " + e.getMessage());
            return password; // Fallback (not secure for production)
        }
    }

    public boolean authenticate(String password) {
        return this.passwordHash.equals(hashPassword(password));
    }

    public String getStaffId() { return staffId; }
    public String getUsername() { return username; }
    public String getRole() { return role; }
    public String getDepartment() { return department; }

    public String toFileFormat() {
        return String.format("%s|%s|%s|%s|%s", staffId, username, passwordHash, role, department);
    }

    public static Staff fromFileFormat(String line) {
        String[] parts = line.split("\\|");
        if (parts.length < 5) return null;
        Staff staff = new Staff(parts[0], parts[1], "dummy", parts[3], parts[4]);
        staff.passwordHash = parts[2]; // Set the stored hash directly
        return staff;
    }
}

// ==================== HOSPITAL MANAGEMENT SYSTEM ====================
class HospitalManagementSystem {
    private Patient[] patients;
    private Staff[] staffMembers;
    private int patientCount;
    private int staffCount;
    private final int MAX_CAPACITY = 1000;
    private final String PATIENT_FILE = "patients.dat";
    private final String STAFF_FILE = "staff.dat";
    private final String LOG_FILE = "hospital_log.txt";
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Staff currentStaff;

    public HospitalManagementSystem() {
        patients = new Patient[MAX_CAPACITY];
        staffMembers = new Staff[MAX_CAPACITY];
        patientCount = 0;
        staffCount = 0;
        loadData();
    }

    // ==================== SECURITY & AUTHENTICATION ====================
    public boolean staffLogin(String username, String password) {
        lock.readLock().lock();
        try {
            for (int i = 0; i < staffCount; i++) {
                if (staffMembers[i].getUsername().equals(username)) {
                    if (staffMembers[i].authenticate(password)) {
                        currentStaff = staffMembers[i];
                        logActivity("LOGIN", "Staff " + username + " logged in");
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void staffLogout() {
        if (currentStaff != null) {
            logActivity("LOGOUT", "Staff " + currentStaff.getUsername() + " logged out");
            currentStaff = null;
        }
    }

    public boolean isAuthenticated() {
        return currentStaff != null;
    }

    public String getCurrentStaffRole() {
        return currentStaff != null ? currentStaff.getRole() : null;
    }

    // ==================== PATIENT MANAGEMENT ====================
    public void addPatient(Patient patient) {
        if (!isAuthenticated()) {
            System.out.println("Access denied. Please login first.");
            return;
        }

        lock.writeLock().lock();
        try {
            if (patientCount < MAX_CAPACITY) {
                patients[patientCount++] = patient;
                savePatientsToFile();
                logActivity("ADD_PATIENT", 
                    currentStaff.getUsername() + " added patient " + patient.getPatientId());
                System.out.println("Patient added successfully!");
            } else {
                System.out.println("Hospital at full capacity!");
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Patient searchPatientById(String patientId) {
        lock.readLock().lock();
        try {
            for (int i = 0; i < patientCount; i++) {
                if (patients[i].getPatientId().equals(patientId)) {
                    return patients[i];
                }
            }
            return null;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void displayAllPatients() {
        if (!isAuthenticated()) {
            System.out.println("Access denied. Please login first.");
            return;
        }

        lock.readLock().lock();
        try {
            System.out.println("\n=== PATIENT LIST ===");
            System.out.println("Total Patients: " + patientCount);
            System.out.println("=".repeat(80));
            
            for (int i = 0; i < patientCount; i++) {
                System.out.println((i + 1) + ". " + patients[i]);
            }
            
            if (patientCount == 0) {
                System.out.println("No patients in the system.");
            }
            System.out.println("=".repeat(80));
        } finally {
            lock.readLock().unlock();
        }
    }

    public void updatePatientMedicalHistory(String patientId, String newHistory) {
        if (!isAuthenticated()) {
            System.out.println("Access denied. Please login first.");
            return;
        }

        lock.writeLock().lock();
        try {
            Patient patient = searchPatientById(patientId);
            if (patient != null && !patient.isDischarged()) {
                patient.setMedicalHistory(newHistory);
                savePatientsToFile();
                logActivity("UPDATE_MEDICAL_HISTORY",
                    currentStaff.getUsername() + " updated history for patient " + patientId);
                System.out.println("Medical history updated!");
            } else {
                System.out.println("Patient not found or has been discharged!");
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void dischargePatient(String patientId) {
        if (!isAuthenticated()) {
            System.out.println("Access denied. Please login first.");
            return;
        }

        lock.writeLock().lock();
        try {
            Patient patient = searchPatientById(patientId);
            if (patient != null && !patient.isDischarged()) {
                patient.dischargePatient();
                savePatientsToFile();
                logActivity("DISCHARGE_PATIENT",
                    currentStaff.getUsername() + " discharged patient " + patientId);
                System.out.println("Patient discharged successfully!");
            } else {
                System.out.println("Patient not found or already discharged!");
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void searchPatientByName(String name) {
        if (!isAuthenticated()) {
            System.out.println("Access denied. Please login first.");
            return;
        }

        lock.readLock().lock();
        try {
            System.out.println("\n=== SEARCH RESULTS FOR: " + name + " ===");
            boolean found = false;
            
            for (int i = 0; i < patientCount; i++) {
                if (patients[i].getName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(patients[i]);
                    found = true;
                }
            }
            
            if (!found) {
                System.out.println("No patients found with that name.");
            }
        } finally {
            lock.readLock().unlock();
        }
    }

    // ==================== FILE HANDLING ====================
    private void loadData() {
        loadPatientsFromFile();
        loadStaffFromFile();
        
        // Create default admin if no staff exists
        if (staffCount == 0) {
            createDefaultStaff();
        }
    }

    private void loadPatientsFromFile() {
        File file = new File(PATIENT_FILE);
        if (!file.exists()) return;

        lock.writeLock().lock();
        try (BufferedReader br = new BufferedReader(new FileReader(PATIENT_FILE))) {
            String line;
            patientCount = 0;
            while ((line = br.readLine()) != null && patientCount < MAX_CAPACITY) {
                Patient patient = Patient.fromFileFormat(line);
                if (patient != null) {
                    patients[patientCount++] = patient;
                }
            }
            System.out.println("Loaded " + patientCount + " patients from file.");
        } catch (IOException e) {
            System.err.println("Error loading patients: " + e.getMessage());
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void savePatientsToFile() {
        lock.readLock().lock();
        try (PrintWriter pw = new PrintWriter(new FileWriter(PATIENT_FILE))) {
            for (int i = 0; i < patientCount; i++) {
                pw.println(patients[i].toFileFormat());
            }
        } catch (IOException e) {
            System.err.println("Error saving patients: " + e.getMessage());
        } finally {
            lock.readLock().unlock();
        }
    }

    private void loadStaffFromFile() {
        File file = new File(STAFF_FILE);
        if (!file.exists()) return;

        lock.writeLock().lock();
        try (BufferedReader br = new BufferedReader(new FileReader(STAFF_FILE))) {
            String line;
            staffCount = 0;
            while ((line = br.readLine()) != null && staffCount < MAX_CAPACITY) {
                Staff staff = Staff.fromFileFormat(line);
                if (staff != null) {
                    staffMembers[staffCount++] = staff;
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading staff: " + e.getMessage());
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void saveStaffToFile() {
        lock.readLock().lock();
        try (PrintWriter pw = new PrintWriter(new FileWriter(STAFF_FILE))) {
            for (int i = 0; i < staffCount; i++) {
                pw.println(staffMembers[i].toFileFormat());
            }
        } catch (IOException e) {
            System.err.println("Error saving staff: " + e.getMessage());
        } finally {
            lock.readLock().unlock();
        }
    }

    private void createDefaultStaff() {
        Staff admin = new Staff("ADM001", "admin", "admin123", "admin", "Administration");
        Staff doctor = new Staff("DOC001", "dr_smith", "doctor123", "doctor", "Cardiology");
        Staff nurse = new Staff("NUR001", "nurse_jones", "nurse123", "nurse", "Emergency");
        
        staffMembers[staffCount++] = admin;
        staffMembers[staffCount++] = doctor;
        staffMembers[staffCount++] = nurse;
        
        saveStaffToFile();
        System.out.println("Default staff accounts created.");
    }

    // ==================== LOGGING ====================
    private void logActivity(String action, String details) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            String timestamp = LocalDate.now().format(DateTimeFormatter.ISO_DATE) + " " +
                              new Date().toString().split(" ")[3]; // Time part
            pw.println(timestamp + " | " + action + " | " + details);
        } catch (IOException e) {
            System.err.println("Error writing to log: " + e.getMessage());
        }
    }

    // ==================== STATISTICS ====================
    public void showStatistics() {
        if (!isAuthenticated()) {
            System.out.println("Access denied. Please login first.");
            return;
        }

        lock.readLock().lock();
        try {
            int admitted = 0;
            int discharged = 0;
            
            for (int i = 0; i < patientCount; i++) {
                if (patients[i].isDischarged()) {
                    discharged++;
                } else {
                    admitted++;
                }
            }
            
            System.out.println("\n=== HOSPITAL STATISTICS ===");
            System.out.println("Total Patients: " + patientCount);
            System.out.println("Currently Admitted: " + admitted);
            System.out.println("Discharged: " + discharged);
            System.out.println("Available Capacity: " + (MAX_CAPACITY - patientCount));
            System.out.println("=".repeat(30));
        } finally {
            lock.readLock().unlock();
        }
    }
}

// ==================== MAIN APPLICATION ====================
public class HospitalPatientSystem {
    private static HospitalManagementSystem hospital;
    private static Scanner scanner;

    public static void main(String[] args) {
        hospital = new HospitalManagementSystem();
        scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   HOSPITAL PATIENT MANAGEMENT SYSTEM   ");
        System.out.println("========================================\n");

        // Login loop
        while (!hospital.isAuthenticated()) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            
            if (hospital.staffLogin(username, password)) {
                System.out.println("\nLogin successful! Welcome, " + username + "!");
            } else {
                System.out.println("Invalid credentials. Try again.\n");
            }
        }

        // Main menu loop
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("\nEnter your choice: ");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    addNewPatient();
                    break;
                case "2":
                    hospital.displayAllPatients();
                    break;
                case "3":
                    searchPatient();
                    break;
                case "4":
                    updateMedicalHistory();
                    break;
                case "5":
                    dischargePatient();
                    break;
                case "6":
                    hospital.showStatistics();
                    break;
                case "7":
                    System.out.println("Logging out...");
                    hospital.staffLogout();
                    running = false;
                    break;
                case "0":
                    System.out.println("Exiting system. Goodbye!");
                    hospital.staffLogout();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
        
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Add New Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Search Patient");
        System.out.println("4. Update Medical History");
        System.out.println("5. Discharge Patient");
        System.out.println("6. View Statistics");
        System.out.println("7. Logout");
        System.out.println("0. Exit System");
    }

    private static void addNewPatient() {
        System.out.println("\n=== ADD NEW PATIENT ===");
        
        System.out.print("Patient ID: ");
        String id = scanner.nextLine();
        
        if (hospital.searchPatientById(id) != null) {
            System.out.println("Patient ID already exists!");
            return;
        }
        
        System.out.print("Full Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Gender (M/F): ");
        String gender = scanner.nextLine();
        
        System.out.print("Contact Number: ");
        String contact = scanner.nextLine();
        
        System.out.print("Address: ");
        String address = scanner.nextLine();
        
        System.out.print("Medical History: ");
        String history = scanner.nextLine();
        
        System.out.print("Assigned Doctor: ");
        String doctor = scanner.nextLine();
        
        System.out.print("Room Number: ");
        String room = scanner.nextLine();
        
        Patient patient = new Patient(id, name, age, gender, contact, address, 
                                     history, LocalDate.now(), doctor, room);
        hospital.addPatient(patient);
    }

    private static void searchPatient() {
        System.out.println("\n=== SEARCH PATIENT ===");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.print("Choose option: ");
        String option = scanner.nextLine();
        
        if (option.equals("1")) {
            System.out.print("Enter Patient ID: ");
            String id = scanner.nextLine();
            Patient patient = hospital.searchPatientById(id);
            if (patient != null) {
                displayPatientDetails(patient);
            } else {
                System.out.println("Patient not found!");
            }
        } else if (option.equals("2")) {
            System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine();
            hospital.searchPatientByName(name);
        }
    }
 private static void displayPatientDetails(Patient patient) {
        System.out.println("\n=== PATIENT DETAILS ===");
        System.out.println("Patient ID: " + patient.getPatientId());
        System.out.println("Name: " + patient.getName());
        System.out.println("Age: " + patient.getAge());
        System.out.println("Gender: " + patient.getGender());
        System.out.println("Contact: " + patient.getContactNumber());
        System.out.println("Address: " + patient.getAddress());
        System.out.println("Medical History: " + patient.getMedicalHistory());
        System.out.println("Admission Date: " + patient.getAdmissionDate());
        System.out.println("Assigned Doctor: " + patient.getAssignedDoctor());
        System.out.println("Room Number: " + patient.getRoomNumber());
        System.out.println("Status: " + (patient.isDischarged() ? "Discharged" : "Admitted"));
    }

    private static void updateMedicalHistory() {
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();
        
        Patient patient = hospital.searchPatientById(id);
        if (patient == null || patient.isDischarged()) {
            System.out.println("Patient not found or has been discharged!");
            return;
        }
        
        displayPatientDetails(patient);
        System.out.print("\nEnter new medical history: ");
        String newHistory = scanner.nextLine();
        
        hospital.updatePatientMedicalHistory(id, newHistory);
    }

    private static void dischargePatient() {
        System.out.print("Enter Patient ID to discharge: ");
        String id = scanner.nextLine();
        
        Patient patient = hospital.searchPatientById(id);
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }
        
        if (patient.isDischarged()) {
            System.out.println("Patient already discharged!");
            return;
        }
        
        displayPatientDetails(patient);
        System.out.print("\nConfirm discharge? (yes/no): ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("yes")) {
            hospital.dischargePatient(id);
        } else {
            System.out.println("Discharge cancelled.");
        }
    }
}