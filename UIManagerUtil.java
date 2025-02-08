package studenti;

import javax.swing.*;
import java.awt.*;

/**
 * Utilitar pentru gestionarea aspectului interfeței grafice (UI) a aplicației.
 */
public class UIManagerUtil {

    /**
     * Setează aspectul sistemului pentru interfața grafică.
     */
    public static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Setează aspectul personalizat al aplicației.
     */
    public static void setAppAppearance() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            // Setarea culorilor și fonturilor pentru diferite componente UI
            UIManager.put("Button.background", new Color(46, 204, 113)); // Culoare verde pentru butoane
            UIManager.put("Button.foreground", Color.black);
            UIManager.put("Button.font", new Font("Arial", Font.BOLD, 16));
            UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 14));
            UIManager.put("Panel.background", new Color(173, 216, 230)); // Culoare albastru deschis pentru panou
            UIManager.put("OptionPane.background", new Color(46, 204, 113)); // Culoare verde pentru ferestrele de mesaje
            UIManager.put("OptionPane.messageForeground", Color.black);
            UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 16));
            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 16));
            UIManager.put("OptionPane.okButtonText", "OK");
            UIManager.put("OptionPane.errorIcon", UIManager.getIcon("OptionPane.errorIcon"));
            UIManager.put("OptionPane.informationIcon", UIManager.getIcon("OptionPane.informationIcon"));

            // Adăugarea chenarului pentru câmpul de introducere a numelui studentului
            UIManager.put("TextField.background", new Color(255, 255, 255)); // Culoare de fundal albă pentru câmpul de text
            UIManager.put("TextField.border", BorderFactory.createLineBorder(new Color(46, 204, 113), 2)); // Chenar verde
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 