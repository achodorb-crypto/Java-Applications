import javax.swing.*;
import java.awt.event.*;

// Patient class to hold patient details
class Patient {
    String name, illness;

    Patient(String name, String illness) {
        this.name = name;
        this.illness = illness;
    }

    @Override
    public String toString() {
        return name + " (" + illness + ")";
    }
}

public class HospitalAppGUI{
    // Counter for total patients
    private static int patientCount = 0;

    // GUI components we need to update later
    private static JTextArea outputArea;
    private static JLabel counterLabel;

    public static void main(String[] args) {
        // Create the main window (frame)
        JFrame frame = new JFrame("Hospital Management System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // manual positioning

        // Label + Text field for patient name
        JLabel nameLabel = new JLabel("Patient Name:");
        nameLabel.setBounds(20, 20, 100, 25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(130, 20, 200, 25);
        frame.add(nameField);

        // Label + Dropdown for illness
        JLabel illnessLabel = new JLabel("Illness:");
        illnessLabel.setBounds(20, 60, 100, 25);
        frame.add(illnessLabel);

        String[] illnesses = {"Cardiology", "Neurology", "Dermatology"};
        JComboBox<String> illnessDropdown = new JComboBox<>(illnesses);
        illnessDropdown.setBounds(130, 60, 200, 25);
        frame.add(illnessDropdown);

        // Button to register patient
        JButton registerButton = new JButton("Register Patient");
        registerButton.setBounds(130, 100, 150, 30);
        frame.add(registerButton);

        // Text area to show registered patients
        outputArea = new JTextArea();
        outputArea.setBounds(20, 150, 440, 150);
        outputArea.setEditable(false); // user cannot type here
        frame.add(outputArea);

        // Label to show total patients
        counterLabel = new JLabel("Total patients entered: 0");
        counterLabel.setBounds(20, 320, 250, 25);
        frame.add(counterLabel);

        // Action when button is clicked
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String illness = (String) illnessDropdown.getSelectedItem();

                if (!name.isEmpty()) {
                    Patient p = new Patient(name, illness);
                    patientCount++;
                    outputArea.append(p + " registered.\n");
                    counterLabel.setText("Total patients entered: " + patientCount);

                    // Clear the name field for next patient
                    nameField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter the patient's name.");
                }
            }
        });

        // Make the window visible
        frame.setVisible(true);
    }
}
