package studenti;

package studenti;

import java.sql.*;
import java.util.ArrayList;

/**
 * Clasa care gestionează operațiile SQL pentru notele studenților.
 */
public class GradeDAO {

    // Adaugă o notă pentru un student
    public void adaugaNota(String materie, int nota, int studentId) {
        String query = "INSERT INTO grades (student_id, materie, nota) VALUES (?, ?, ?)";

        try (Connection conn = DerbyDatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, studentId);
            stmt.setString(2, materie);
            stmt.setInt(3, nota);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obține notele unui student pentru o materie
    public ArrayList<Integer> getNoteLaMaterie(int studentId, String materie) {
        ArrayList<Integer> note = new ArrayList<>();
        String query = "SELECT nota FROM grades WHERE student_id = ? AND materie = ?";

        try (Connection conn = DerbyDatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, studentId);
            stmt.setString(2, materie);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                note.add(rs.getInt("nota"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return note;
    }
}

