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

public class AnimationDisplayPanel extends RoundedPanel {

    private JLabel animationIconLabel;
    private JLabel timerTextLabel;

    /**
     * Creates the center display panel.
     * @param animationIconLabel The label that holds the animation icon.
     * @param timerTextLabel The label that holds the timer countdown text.
     */
    public AnimationDisplayPanel(JLabel animationIconLabel, JLabel timerTextLabel) {
        super(30, new Color(139, 94, 56, 120));

        this.animationIconLabel = animationIconLabel;
        this.timerTextLabel = timerTextLabel;

        setLayout(new BorderLayout());
        
        animationIconLabel.setVerticalAlignment(SwingConstants.CENTER);
        animationIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(animationIconLabel, BorderLayout.CENTER);

        timerTextLabel.setVerticalAlignment(SwingConstants.TOP);
        timerTextLabel.setHorizontalAlignment(SwingConstants.CENTER);

        timerTextLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(timerTextLabel, BorderLayout.SOUTH);
    }
}
