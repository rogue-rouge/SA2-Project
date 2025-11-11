/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cozybrew.ui.panels;


import cozybrew.audio.SoundEffectPlayer;
import cozybrew.logic.TimerEngine;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 *
 * @author GROUP 3: JOHANES KINNARD COTE, MACAYLE THERESE DANCEL, MARY KIRSTEN DANIELLE IGUET, NESTOR JOSH BACANI, & ROSALIE JOY VICENTE
 */

public class PresetsPanel extends RoundedPanel {

    private final TimerEngine timer;
    private final SoundEffectPlayer sfxPlayer;
    private final Map<String, Integer> presets;

    public PresetsPanel(TimerEngine timer, SoundEffectPlayer sfxPlayer) {
        super(30, new Color(139, 94, 56, 120));

        this.timer = timer;
        this.sfxPlayer = sfxPlayer;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        
        setAlignmentX(Component.CENTER_ALIGNMENT);

        presets = new LinkedHashMap<>();
        presets.put("1 Min", 60);
        presets.put("5 Min", 5 * 60);
        presets.put("10 Min", 10 * 60);
        presets.put("15 Min", 15 * 60);
        presets.put("30 Min", 30 * 60);
        presets.put("45 Min", 45 * 60);
        presets.put("1 Hour", 60 * 60);

        add(Box.createVerticalGlue());

        for (final Map.Entry<String, Integer> entry : presets.entrySet()) {
            JButton btn = new RoundedButton(entry.getKey());
            
            // --- Center the button ---
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);

            btn.addActionListener(e -> {
                sfxPlayer.playSound("click");
                timer.setDurationSeconds(entry.getValue());
            });
            add(btn);

            if (!entry.getKey().equals("1 Hour")) { 
                 add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }
        
        add(Box.createVerticalGlue());
    }
}
