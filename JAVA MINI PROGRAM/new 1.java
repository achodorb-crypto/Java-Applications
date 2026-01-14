import java.util.Scanner;

enum Specialty {
    ONCOLOGIST, ENDOCRINOLOGIST, CARDIOLOGIST, INFECTIOUS_DISEASE
}

class Doctor {
    String name;
    Specialty specialty;

    Doctor(String name, Specialty specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    String getName() {
        return name;
    }

    Specialty getSpecialty() {
        return specialty;
    }
}

public class PatientAssignment {
    public static void main(String[] args) {
        Doctor[] doctors = {
            new Doctor("Dr. Smith", Specialty.ONCOLOGIST),
            new Doctor("Dr. Johnson", Specialty.ENDOCRINOLOGIST),
            new Doctor("Dr. Williams", Specialty.CARDIOLOGIST),
            new Doctor("Dr. Davis", Specialty.INFECTIOUS_DISEASE)
        };

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter patient name (or 'exit' to quit):");
            String name = input.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter illness (cancer, diabetes, heart, infection):");
            String illness = input.nextLine().toLowerCase();

            Doctor assignedDoctor = null;
            switch (illness) {
                case "cancer":
                    assignedDoctor = getDoctor(Specialty.ONCOLOGIST, doctors);
                    break;
                case "diabetes":
                    assignedDoctor = getDoctor(Specialty.ENDOCRINOLOGIST, doctors);
                    break;
                case "heart":
                    assignedDoctor = getDoctor(Specialty.CARDIOLOGIST, doctors);
                    break;
                case "infection":
                    assignedDoctor = getDoctor(Specialty.INFECTIOUS_DISEASE, doctors);
                    break;
                default:
                    System.out.println("Invalid illness.");
                    continue;
            }

            if (assignedDoctor != null) {
                System.out.println(name + " assigned to " + assignedDoctor.getName());
            } else {
                System.out.println("No doctor available.");
            }
        }
        input.close();
    }

    static Doctor getDoctor(Specialty specialty, Doctor[] doctors) {
        for (Doctor doctor : doctors) {
            if (doctor.getSpecialty() == specialty) {
                return doctor;
            }
        }
        return null;
    }
}