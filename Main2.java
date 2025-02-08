package studenti;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Setează aspectul aplicației
        UIManagerUtil.setAppAppearance();

        // Lansează interfața grafică pe thread-ul de evenimente Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Creează și afișează fereastra principală a aplicației
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
        });
    }
}
