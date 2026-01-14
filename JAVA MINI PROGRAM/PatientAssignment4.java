import java.util.Scanner;


enum Illness {
    CANCER,
    DIABETES,
    HEART_CONDITION,
    INFECTION
}

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

public class PatientAssignment4 {
    public static void main(String[] args) {
        Doctor[] doctors = {
            new Doctor("Dr. Smith", Specialty.ONCOLOGIST),
            new Doctor("Dr. Johnson", Specialty.ENDOCRINOLOGIST),
            new Doctor("Dr. Williams", Specialty.CARDIOLOGIST),
            new Doctor("Dr. Davis", Specialty.INFECTIOUS_DISEASE)
        };

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = input.nextLine();

        while (true) {
            System.out.println("Enter illness (cancer, diabetes, heart_condition, infection) or 'exit' to quit");
            String illness = input.nextLine().toLowerCase();

            if (illness.equals("exit")) {
                break;
            }

            Doctor assignedDoctor = null;
            switch (illness) {
                case "cancer":
                    assignedDoctor = getDoctor(Specialty.ONCOLOGIST, doctors);
                    break;
                case "diabetes":
                    assignedDoctor = getDoctor(Specialty.ENDOCRINOLOGIST, doctors);
                    break;
                case "heart_condition":
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
                System.out.println("Thank you, and don't forget that Jesus heals");
            } else {
                System.out.println(name + " could not be assigned to a doctor.");
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
