/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cozybrew.ui.panels;

/**
 *
 * @author GROUP 3: JOHANES KINNARD COTE, MACAYLE THERESE DANCEL, MARY KIRSTEN DANIELLE IGUET, NESTOR JOSH BACANI, & ROSALIE JOY VICENTE
 */

import cozybrew.audio.SoundEffectPlayer; 
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
    private final SoundEffectPlayer sfxPlayer;
    private Map<String, Integer> presets;

    public PresetsPanel(TimerEngine timer, SoundEffectPlayer sfxPlayer) {
        super();
        this.timer = timer;
        this.sfxPlayer = sfxPlayer;
        
        setLayout(new GridLayout(7, 1, 0, 10));

        Map<String, Integer> presets = new LinkedHashMap<>();
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
                sfxPlayer.playSound("click");
                timer.setDurationSeconds(entry.getValue());
            });
            add(btn);
        }
    }
}
