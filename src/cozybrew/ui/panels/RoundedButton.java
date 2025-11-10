package cozybrew.ui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * to make the buttons look nicer 
 */
public class RoundedButton extends JButton {

    private Color backgroundColor = new Color(101, 67, 33, 200);
    private Color hoverColor = new Color(131, 97, 63, 200);
    private int cornerRadius = 25;

    public RoundedButton(String text) {
        super(text);
        
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        
        setForeground(Color.WHITE);
        setFont(new Font("Serif", Font.BOLD, 16));
        
        setPreferredSize(new Dimension(150, 45));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isPressed()) {
            g2.setColor(backgroundColor.darker());
        } else if (getModel().isRollover()) {
            g2.setColor(hoverColor);
        } else {
            g2.setColor(backgroundColor);
        }
        
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

        super.paintComponent(g);
        
        g2.dispose();
    }
}
