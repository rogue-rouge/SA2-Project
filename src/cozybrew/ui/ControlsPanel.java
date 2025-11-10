package cozybrew.ui;
import cozybrew.logic.TimerEngine;
import testcontrolsmain.audio.AudioPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ControlsPanel extends JPanel {
    private final TimerEngine timer;
    private final AudioPlayer audio;

    public ControlsPanel(final TimerEngine timer, final AudioPlayer audio) {
        this.timer = timer;
        this.audio = audio;

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Timer Controls", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new GridLayout(0, 2, 10, 10));

        Map<String, Integer> presets = new LinkedHashMap<String, Integer>();
        presets.put("1 min", 60);
        presets.put("5 min", 5 * 60);
        presets.put("10 min", 10 * 60);
        presets.put("15 min", 15 * 60);
        presets.put("30 min", 30 * 60);
        presets.put("45 min", 45 * 60);
        presets.put("1 hour", 60 * 60);

        for (final Map.Entry<String, Integer> entry : presets.entrySet()) {
            JButton btn = new JButton(entry.getKey());
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    timer.setDurationSeconds(entry.getValue());
                }
            });
            buttonsPanel.add(btn);
        }

        add(buttonsPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        JButton startBtn = new JButton("Start");
        JButton stopBtn = new JButton("Stop");
        JButton playMusicBtn = new JButton("Play Music");
        JButton pauseMusicBtn = new JButton("Pause Music");

        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        stopBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });

        playMusicBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                audio.playLoop();
            }
        });

        pauseMusicBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                audio.pause();
            }
        });

        bottomPanel.add(startBtn);
        bottomPanel.add(stopBtn);
        bottomPanel.add(playMusicBtn);
        bottomPanel.add(pauseMusicBtn);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
