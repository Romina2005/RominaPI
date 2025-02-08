package studenti;

import java.sql.*;

public class DerbyDatabaseManager {

    private static final String DB_URL = "jdbc:derby:studentiDB;create=true"; // URL-ul bazei de date

    public static void createTables() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            Statement stmt = conn.createStatement();

            String createStudentsTable = "CREATE TABLE students (" +
                                         "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY," +
                                         "nume VARCHAR(255)," +
                                         "specializare VARCHAR(255));";
            String createGradesTable = "CREATE TABLE grades (" +
                                        "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY," +
                                        "student_id INT," +
                                        "materie VARCHAR(255)," +
                                        "nota INT," +
                                        "FOREIGN KEY (student_id) REFERENCES students(id));";
            
            stmt.executeUpdate(createStudentsTable);
            stmt.executeUpdate(createGradesTable);
            System.out.println("Tabelele au fost create cu succes.");
        } catch (SQLException e) {
            System.out.println("Eroare la crearea tabelelor: " + e.getMessage());
        }
    }
}

