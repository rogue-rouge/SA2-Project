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
    
    public AnimationDisplayPanel(JLabel animationLabel) {
        super(40, new Color(101, 67, 33, 200));

        setLayout(new BorderLayout());
        setOpaque(false); 
        
        animationLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        animationLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        
        add(animationLabel, BorderLayout.CENTER);
      }
}
