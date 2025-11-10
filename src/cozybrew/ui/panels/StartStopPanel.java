package cozybrew.ui.panels;

import cozybrew.logic.TimerEngine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartStopPanel extends RoundedPanel implements ActionListener {

    private final TimerEngine timer;
    private JButton startBtn;
    private JButton stopBtn;

    public StartStopPanel(TimerEngine timer) {
        super(40, new Color(101, 67, 33, 200)); 
        this.timer = timer;

        setLayout(new GridLayout(0, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        startBtn = new JButton("Start");
        styleButton(startBtn);
        startBtn.addActionListener(this);
        add(startBtn);
        
        stopBtn = new JButton("Stop");
        styleButton(stopBtn);
        stopBtn.addActionListener(this);
        add(stopBtn);
    }

  @Override
  public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Start")) {
            timer.start();
        } else if (command.equals("Stop")) {
            timer.stop();
        }
    }
    
  private void styleButton(JButton btn) {
        btn.setFont(new Font("Serif", Font.BOLD, 18));
        btn.setForeground(new Color(240, 230, 220));
        btn.setBackground(new Color(139, 90, 43));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
