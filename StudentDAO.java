package studenti;

package studenti;

import java.sql.*;

/**
 * Clasa care gestionează operațiile SQL pentru studenți.
 */
public class StudentDAO {

    // Adăugăm un student în baza de date
    public void adaugaStudent(Student student) {
        String query = "INSERT INTO students (nume, specializare) VALUES (?, ?)";

        try (Connection conn = DerbyDatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, student.getNume());
            stmt.setString(2, student.getSpecializare());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Adăugăm o notă pentru un student într-o materie
    public void adaugaNotaLaStudent(Student student, String materie, int nota) {
        String query = "INSERT INTO grades (student_id, materie, nota) VALUES (?, ?, ?)";

        try (Connection conn = DerbyDatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Obținem studentul din DB pentru a găsi ID-ul
            int studentId = getStudentIdByName(student.getNume());

            stmt.setInt(1, studentId);
            stmt.setString(2, materie);
            stmt.setInt(3, nota);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obținem ID-ul studentului din baza de date
    public int getStudentIdByName(String nume) {
        String query = "SELECT id FROM students WHERE nume = ?";
        int studentId = -1;

        try (Connection conn = DerbyDatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nume);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                studentId = rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentId;
    }
}
