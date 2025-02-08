package studenti;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

/**
 * Clasa care implementează un buton cu gradient.
 */
public class GradientButton extends JButton {
    private Color startColor;
    private Color endColor;
    private Color hoverColor;

    /**
     * Constructorul pentru GradientButton.
     * @param text Textul afișat pe buton.
     * @param startColor Culoarea de început a gradientului.
     * @param endColor Culoarea de sfârșit a gradientului.
     * @param hoverColor Culoarea de hover a butonului.
     */
    public GradientButton(String text, Color startColor, Color endColor, Color hoverColor) {
        super(text);
        this.startColor = startColor;
        this.endColor = endColor;
        this.hoverColor = hoverColor;

        setUI(new BasicButtonUI());
        setContentAreaFilled(false);
        setFocusPainted(false);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentAreaFilled(false);
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setHoverBackground();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setDefaultBackground();
            }
        });
    }

    private void setHoverBackground() {
        setContentAreaFilled(true);
        repaint();
    }

    private void setDefaultBackground() {
        setContentAreaFilled(false);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();

        if (getModel().isPressed()) {
            g2.setColor(endColor.darker()); // Culorile mai întunecate atunci când butonul este apăsat
        } else if (getModel().isRollover()) {
            g2.setColor(hoverColor); // Culori diferite pentru starea de hover
        } else {
            g2.setColor(startColor); // Culorile implicite
        }

        g2.fillRoundRect(0, 0, width, height, 10, 10);

        // Dacă butonul este apăsat, menține culorile întunecate
        if (getModel().isPressed()) {
            setHoverBackground();
        } else {
            setDefaultBackground();
        }

        g2.drawRoundRect(0, 0, width - 1, height - 1, 10, 10);
        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0, 0, width - 1, height - 1, 10, 10);
        g2.dispose();
    }
}
