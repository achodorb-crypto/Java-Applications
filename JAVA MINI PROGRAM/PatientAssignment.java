import java.util.ArrayList;
import java.util.List;

// Enum for illness types
enum Illness {
    CANCER,
    DIABETES,
    HEART_CONDITION,
    INFECTION
}

// Enum for doctor specialties
enum Specialty {
    ONCOLOGIST,
    ENDOCRINOLOGIST,
    CARDIOLOGIST,
    INFECTIOUS_DISEASE
}

// Doctor class
class Doctor {
    private String name;
    private Specialty specialty;

    public Doctor(String name, Specialty specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public Specialty getSpecialty() {
        return specialty;
    }
}

// Patient class
class Patient {
    private String name;
    private Illness illness;

    public Patient(String name, Illness illness) {
        this.name = name;
        this.illness = illness;
    }

    public String getName() {
        return name;
    }

    public Illness getIllness() {
        return illness;
    }
}

public class PatientAssignment {
    private List<Doctor> doctors;
    private List<Patient> patients;

    public PatientAssignment() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();

        // Initialize doctors
        doctors.add(new Doctor("Dr. Davis", Specialty.ONCOLOGIST));
        doctors.add(new Doctor("Dr. Rex", Specialty.ENDOCRINOLOGIST));
        doctors.add(new Doctor("Dr. Debbie", Specialty.CARDIOLOGIST));
        doctors.add(new Doctor("Dr. Jemimah", Specialty.INFECTIOUS_DISEASE));
    }

    public void assignPatients() {
        // Assign patients to doctors based on illness
        for (Patient patient : patients) {
            Doctor assignedDoctor = null;

            switch (patient.getIllness()) {
                case CANCER:
                    assignedDoctor = getDoctor(Specialty.ONCOLOGIST);
                    break;
                case DIABETES:
                    assignedDoctor = getDoctor(Specialty.ENDOCRINOLOGIST);
                    break;
                case HEART_CONDITION:
                    assignedDoctor = getDoctor(Specialty.CARDIOLOGIST);
                    break;
                case INFECTION:
                    assignedDoctor = getDoctor(Specialty.INFECTIOUS_DISEASE);
                    break;
            }

            if (assignedDoctor != null) {
                System.out.println(patient.getName() + " assigned to " + assignedDoctor.getName());
            } else {
                System.out.println(patient.getName() + " could not be assigned to a doctor.");
            }
        }
    }

    private Doctor getDoctor(Specialty specialty) {
        for (Doctor doctor : doctors) {
            if (doctor.getSpecialty() == specialty) {
                return doctor;
            }
        }
        return null;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public static void main(String[] args) {
        PatientAssignment assignment = new PatientAssignment();

        // Add patients
        assignment.addPatient(new Patient("John", Illness.CANCER));
        assignment.addPatient(new Patient("Jane", Illness.DIABETES));
        assignment.addPatient(new Patient("Bob", Illness.HEART_CONDITION));
        assignment.addPatient(new Patient("Alice", Illness.INFECTION));

        // Assign patients to doctors
        assignment.assignPatients();
    }
}