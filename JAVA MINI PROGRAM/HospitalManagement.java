import java.util.*;

class Doctor {
    String name;
    String specialty;

    Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return name + " (" + specialty + ")";
    }
}

class Room {
    int number;
    String specialty;

    Room(int number, String specialty) {
        this.number = number;
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Room " + number + " [" + specialty + "]";
    }
}

class Patient {
    String name;
    String illness;

    Patient(String name, String illness) {
        this.name = name;
        this.illness = illness;
    }

    @Override
    public String toString() {
        return name + " (Illness: " + illness + ")";
    }
}

class Hospital {
    Map<String, Doctor> doctors = new HashMap<>();
    Map<String, Room> rooms = new HashMap<>();

    void addDoctor(String name, String specialty) {
        doctors.putIfAbsent(specialty, new Doctor(name, specialty));
    }

    void addRoom(int number, String specialty) {
        rooms.putIfAbsent(specialty, new Room(number, specialty));
    }

    void assignPatient(Patient patient) {
        Doctor doctor = doctors.get(patient.illness);
        Room room = rooms.get(patient.illness);

        if (doctor != null && room != null) {
            System.out.println(patient + " assigned to " + doctor + " in " + room);
        } else {
            System.out.println("No doctor/room available for " + patient.illness);
        }
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        // Add doctors
        hospital.addDoctor("Dr. Alice", "Cardiology");
        hospital.addDoctor("Dr. Bob", "Neurology");

        // Add rooms
        hospital.addRoom(101, "Cardiology");
        hospital.addRoom(202, "Neurology");

        // Patients
        Patient p1 = new Patient("John Doe", "Cardiology");
        Patient p2 = new Patient("Jane Smith", "Neurology");
        Patient p3 = new Patient("Mike Brown", "Dermatology");

        // Assign patients
        hospital.assignPatient(p1);
        hospital.assignPatient(p2);
        hospital.assignPatient(p3);
    }
}