package studenti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private JTextField numeTextField;
    private JTextField specializareTextField;
    private JTextField materieTextField;
    private JTextField notaTextField;
    private JTextArea resultArea;

    public MainFrame() {
        setTitle("Gestionare Studenți");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crearea panoului de input
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        panel.add(new JLabel("Nume:"));
        numeTextField = new JTextField();
        panel.add(numeTextField);

        panel.add(new JLabel("Specializare:"));
        specializareTextField = new JTextField();
        panel.add(specializareTextField);

        panel.add(new JLabel("Materie:"));
        materieTextField = new JTextField();
        panel.add(materieTextField);

        panel.add(new JLabel("Nota:"));
        notaTextField = new JTextField();
        panel.add(notaTextField);

        // Butoane
        JButton addStudentButton = new JButton("Adaugă Student");
        panel.add(addStudentButton);

        JButton addGradeButton = new JButton("Adaugă Notă");
        panel.add(addGradeButton);

        JButton showStudentButton = new JButton("Afișează Studenți");
        panel.add(showStudentButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);

        add(panel);

        // Logica butoanelor
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume = numeTextField.getText();
                String specializare = specializareTextField.getText();
                
                if (!nume.isEmpty() && !specializare.isEmpty()) {
                    // Creăm și salvăm studentul în DB
                    Student student = new Student(nume, specializare);
                    StudentDAO studentDAO = new StudentDAO();
                    studentDAO.adaugaStudent(student);
                    resultArea.append("Studentul " + nume + " a fost adăugat!\n");
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this, "Completează toate câmpurile!", "Eroare", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String materie = materieTextField.getText();
                String notaText = notaTextField.getText();
                if (!materie.isEmpty() && !notaText.isEmpty()) {
                    try {
                        int nota = Integer.parseInt(notaText);
                        // Verificăm dacă studentul există
                        String numeStudent = numeTextField.getText();
                        if (!numeStudent.isEmpty()) {
                            StudentDAO studentDAO = new StudentDAO();
                            int studentId = studentDAO.getStudentIdByName(numeStudent);
                            if (studentId != -1) {
                                // Adăugăm nota în baza de date
                                studentDAO.adaugaNotaLaStudent(new Student(numeStudent, ""), materie, nota);
                                resultArea.append("Nota " + nota + " la materia " + materie + " a fost adăugată!\n");
                            } else {
                                JOptionPane.showMessageDialog(MainFrame.this, "Studentul nu există!", "Eroare", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Introduceți o notă validă!", "Eroare", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this, "Completează toate câmpurile!", "Eroare", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        showStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Afișăm toți studenții
                StringBuilder result = new StringBuilder();
                StudentDAO studentDAO = new StudentDAO();
                for (Student student : studentDAO.getAllStudents()) {
                    result.append("Student: " + student.getNume() + ", Specializare: " + student.getSpecializare() + "\n");
                    for (String materie : student.getNoteMaterii().keySet()) {
                        result.append("  Materie: " + materie + ", Note: " + student.getNoteLaMaterie(materie) + "\n");
                    }
                    result.append("\n");
                }
                resultArea.setText(result.toString());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
