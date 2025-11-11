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

/**
 * new panel for start stop
 * It's based on ControlsPanel logic.
 */
public class StartStopPanel extends RoundedPanel {

    private final TimerEngine timer;
    private final SoundEffectPlayer sfxPlayer;

    public StartStopPanel(TimerEngine timer, SoundEffectPlayer sfxPlayer) {
        super();
        this.timer = timer;
        this.sfxPlayer = sfxPlayer;

        setLayout(new GridLayout(2, 1, 0, 15));

        JButton startBtn = new RoundedButton("Start");
        JButton stopBtn = new RoundedButton("Stop");

        startBtn.addActionListener(e -> {
            sfxPlayer.playSound("click");
            timer.start();
        });

        stopBtn.addActionListener(e -> {
            sfxPlayer.playSound("click");
            timer.stop();
        });

        add(startBtn);
        add(stopBtn);
    }
}
