package cozybrew.ui.panels;

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

    public StartStopPanel(TimerEngine timer) {
        super(40, new Color(101, 67, 33, 200)); 
        this.timer = timer;

        setLayout(new GridLayout(0, 1, 10, 10));
        setOpaque(false);

        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JButton startBtn = new RoundedButton("Start");
        JButton stopBtn = new RoundedButton("Stop");
        
        startBtn.addActionListener(e -> {
            timer.start();
        });

        stopBtn.addActionListener(e -> {
            timer.stop();
        });

        add(startBtn);
        add(stopBtn);
    }
}
