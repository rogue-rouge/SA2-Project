package cozybrew.ui.panels;

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
