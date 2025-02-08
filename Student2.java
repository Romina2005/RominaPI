package studenti;

package studenti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clasa care reprezintă un student și gestionează informațiile despre acesta.
 */
public class Student {
    private String nume;
    private String specializare;
    private Map<String, ArrayList<Integer>> noteMaterii;
    
    // Constructorul rămâne același
    public Student(String nume, String specializare) {
        this.nume = nume;
        this.specializare = specializare;
        this.noteMaterii = new HashMap<>();
    }

    public String getNume() {
        return nume;
    }

    public String getSpecializare() {
        return specializare;
    }

    public Map<String, ArrayList<Integer>> getNoteMaterii() {
        return noteMaterii;
    }

    public void adaugaNota(String materie, int nota) {
        noteMaterii.computeIfAbsent(materie, k -> new ArrayList<>()).add(nota);
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.adaugaNotaLaStudent(this, materie, nota); // Salvează în DB
    }

    public double calculeazaMedieGenerala() {
        if (noteMaterii.isEmpty()) {
            return 0;
        }
        int numarTotalNote = 0;
        int sumaTotala = 0;
        for (ArrayList<Integer> note : noteMaterii.values()) {
            for (int nota : note) {
                sumaTotala += nota;
                numarTotalNote++;
            }
        }
        return (double) sumaTotala / numarTotalNote;
    }
}

