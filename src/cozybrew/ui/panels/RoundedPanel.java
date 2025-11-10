package cozybrew.ui.panels;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Dimension;

public class RoundedPanel extends JPanel {
    
    private Color backgroundColor;
    private int cornerRadius;
    
    public RoundedPanel(int cornerRadius, Color backgroundColor) {
        super();
        this.cornerRadius = cornerRadius;
        this.backgroundColor = backgroundColor;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draws the rounded panel with the specified color.
        g2d.setColor(backgroundColor);
        g2d.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
    }
}
