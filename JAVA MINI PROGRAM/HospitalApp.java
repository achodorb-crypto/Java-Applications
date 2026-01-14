import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Doctor class
class Doctor {
    String name;
    String specialty;
    List<Patient> patients;

    Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.patients = new ArrayList<>();
    }
}

// Room class
class Room {
    int number;
    int capacity;
    List<Patient> patients;

    Room(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
        this.patients = new ArrayList<>();
    }
}

// Patient class
class Patient {
    String name;
    String illness;
    Doctor doctor;
    Room room;

    Patient(String name, String illness) {
        this.name = name;
        this.illness = illness;
    }
}

// Hospital class
class Hospital {
    List<Doctor> doctors;
    List<Room> rooms;
    List<Patient> patients;

    Hospital() {
        this.doctors = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    void addDoctor(String name, String specialty) {
        doctors.add(new Doctor(name, specialty));
    }

    void addRoom(int number, int capacity) {
        rooms.add(new Room(number, capacity));
    }

    void addPatient(String name, String illness) {
        patients.add(new Patient(name, illness));
    }

    void assignDoctor(String patientName, String doctorName) {
        Patient patient = findPatient(patientName);
        Doctor doctor = findDoctor(doctorName);
        if (patient != null && doctor != null) {
            patient.doctor = doctor;
            doctor.patients.add(patient);
            System.out.println("We assigned Dr. " + doctorName + " to " + patientName);
        } else {
            System.out.println("Patient or Doctor not found!");
        }
    }

    void assignRoom(String patientName, int roomNumber) {
        Patient patient = findPatient(patientName);
        Room room = findRoom(roomNumber);
        if (patient != null && room != null && room.patients.size() < room.capacity) {
            patient.room = room;
            room.patients.add(patient);
            System.out.println("We assigned " + patientName + " to Room " + roomNumber);
        } else {
            System.out.println("Patient, Room not found, or Room is full!");
        }
    }

    void displayStatus() {
        System.out.println("\nHospital Status:");
        for (Doctor doctor : doctors) {
            System.out.print("Dr. " + doctor.name + " (" + doctor.specialty + "): ");
            for (Patient patient : doctor.patients) {
                System.out.print(patient.name + ", ");
            }
            System.out.println();
        }
        for (Room room : rooms) {
            System.out.print("Room " + room.number + ": ");
            for (Patient patient : room.patients) {
                System.out.print(patient.name + ", ");
            }
            System.out.println();
        }
        System.out.println("Total Patients: " + patients.size());
    }

    Patient findPatient(String name) {
        for (Patient patient : patients) {
            if (patient.name.equals(name)) return patient;
        }
        return null;
    }

    Doctor findDoctor(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.name.equals(name)) return doctor;
        }
        return null;
    }

    Room findRoom(int number) {
        for (Room room : rooms) {
            if (room.number == number) return room;
        }
        return null;
    }
}

public class HospitalApp{
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Add Room");
            System.out.println("4. Assign Doctor");
            System.out.println("5. Assign Room");
            System.out.println("6. Display Status");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter doctor specialty: ");
                    String specialty = scanner.nextLine();
                    hospital.addDoctor(doctorName, specialty);
                    break;
					
				case 2:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter patient illness: ");
                    String illness = scanner.nextLine();
                    hospital.addPatient(patientName, illness);
                    break;
					
                case 3:
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter room capacity: ");
                    int capacity = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    hospital.addRoom(roomNumber, capacity);
                    break;
               
                case 4:
                    System.out.print("Enter patient name: ");  
                    String patientName4 = scanner.nextLine();
                    System.out.print("Enter doctor name: ");
                    String doctorName4 = scanner.nextLine();
                    hospital.assignDoctor(patientName4, doctorName4);
                    break;
                case 5:
                    System.out.print("Enter patient name: ");
                    String patientName5 = scanner.nextLine();
                    System.out.print("Enter room number: ");
                    int roomNumber5 = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    hospital.assignRoom(patientName5, roomNumber5);
                    break;
                case 6:
                    hospital.displayStatus();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}