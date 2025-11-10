/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cozybrew.logic;

import javax.swing.*;
import java.awt.event.*;
import cozybrew.ui.AnimationController;

/**
 *
 * @author Rosalie Joy Indelible Vicente
 */

public class TimerLogic implements ActionListener {
    private int remainingSeconds;
    private JLabel displayLabel;
    private Timer swingTimer;
    private AnimationController animationController;

    public TimerLogic(JLabel displayLabel, AnimationController animationController) {
        this.displayLabel = displayLabel;
        this.animationController = animationController;
        this.swingTimer = new Timer(1000, this);
        this.swingTimer.setRepeats(true);
        setToIdle();
    }

    public void startTimer(int totalSeconds) {
        stopTimer();
        this.remainingSeconds = totalSeconds;
        updateDisplay();
        animationController.startAnimation(totalSeconds);
        swingTimer.start();
    }

    public void stopTimer() {
        if (swingTimer != null && swingTimer.isRunning()) {
            swingTimer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateTimerAction();
    }

    private void updateTimerAction() {
        if (remainingSeconds > 0) {
            remainingSeconds--;
            updateDisplay();
            animationController.updateFrame(remainingSeconds);
        } else {
            stopTimer();
            timerFinished();
        }
    }

    private void timerFinished() {
        animationController.setComplete();
        displayLabel.setText("Brewing Complete! ☕️");

        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(
                displayLabel.getParent(),
                "Ding! Your brew is ready!",
                "Timer Finished",
                JOptionPane.INFORMATION_MESSAGE
            );
        });
    }

    private void updateDisplay() {
        int minutes = remainingSeconds / 60;
        int seconds = remainingSeconds % 60;
        String timeString = String.format("%02d:%02d", minutes, seconds);
        displayLabel.setText(timeString);
    }

    public void setToIdle() {
        stopTimer();
        remainingSeconds = 0;
        displayLabel.setText("<html><div style='text-align: center;'>Cozy Brew<br>Select a preset</div></html>");
        animationController.setToIdle();
    }
}
