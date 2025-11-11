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

public class StartStopPanel extends RoundedPanel {

    private final TimerEngine timer;
    private final SoundEffectPlayer sfxPlayer;

    public StartStopPanel(TimerEngine timer, SoundEffectPlayer sfxPlayer) {
        super(40, new Color(139, 94, 56, 170));

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
