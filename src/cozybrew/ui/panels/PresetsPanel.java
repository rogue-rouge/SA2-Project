package cozybrew.ui.panels;

import cozybrew.logic.TimerEngine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * new panel for the presets
 * It's based on the original ControlsPanel logic.
 */

public class PresetsPanel extends RoundedPanel {
    
    private final TimerEngine timer;
    private Map<String, Integer> presets;

    public PresetsPanel(TimerEngine timer) {
            super(40, new Color(101, 67, 33, 200)); 
            
            this.timer = timer;

            setLayout(new GridLayout(0, 1, 10, 10));
            setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            presets = new LinkedHashMap<>();
            presets.put("1 Min", 60);
            presets.put("5 Min", 5 * 60);
            presets.put("10 Min", 10 * 60);
            presets.put("15 Min", 15 * 60);
            presets.put("30 Min", 30 * 60);
            presets.put("45 Min", 45 * 60);
            presets.put("1 Hour", 60 * 60);
      
            for (final Map.Entry<String, Integer> entry : presets.entrySet()) {
            JButton btn = new RoundedButton(entry.getKey());
            btn.addActionListener(e -> {
                timer.setDurationSeconds(entry.getValue());
            });
            add(btn);
        }
    }
}
