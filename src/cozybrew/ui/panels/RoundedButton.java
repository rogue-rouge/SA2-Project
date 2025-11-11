/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cozybrew.ui.panels;

/**
 *
 * @author GROUP 3: JOHANES KINNARD COTE, MACAYLE THERESE DANCEL, MARY KIRSTEN DANIELLE IGUET, NESTOR JOSH BACANI, & ROSALIE JOY VICENTE
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

/**
 * to make the buttons look nicer 
 */
public class RoundedButton extends JButton {

    private Color baseColor = new Color(139, 94, 56, 200);
    private Color hoverColor = new Color(159, 114, 76, 200);
    private Color pressedColor = new Color(119, 74, 36, 200);

    private int cornerRadius = 25;

    public RoundedButton(String text) {
        super(text);

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        
        setForeground(Color.WHITE);
        setFont(new Font("Serif", Font.BOLD, 16));
        
        setPreferredSize(new Dimension(150, 40));
        
        setMaximumSize(new Dimension(150, 40));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isPressed()) {
            g2.setColor(pressedColor);
        } else if (getModel().isRollover()) {
            g2.setColor(hoverColor);
        } else {
            g2.setColor(baseColor);
        }
        
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
        
        super.paintComponent(g);
        g2.dispose();
    }
}
