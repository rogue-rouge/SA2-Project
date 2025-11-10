/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cozybrew.logic;

import javax.swing.*;
import java.awt.event.*;
import cozybrew.ui.AnimationController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GROUP 3: JOHANES KINNARD COTE, MACAYLE THERESE DANCEL, MARY KIRSTEN DANIELLE IGUET, NESTOR JOSH BACANI, & ROSALIE JOY VICENTE
 */

public class TimerLogic implements ActionListener, TimerEngine {
    private int remainingSeconds;
    private int initialDuration;
    private JLabel displayLabel;
    private Timer swingTimer;
    private AnimationController animationController;
    private boolean isRunning = false;

    private List<TimerListener> listeners = new ArrayList<>();

    public TimerLogic(JLabel displayLabel, AnimationController animationController) {
        this.displayLabel = displayLabel;
        this.animationController = animationController;
        this.swingTimer = new Timer(1000, this);
        this.swingTimer.setRepeats(true);
        setToIdle();
    }

    @Override
    public void setDurationSeconds(int totalSeconds) {
        if (!isRunning) {
            this.initialDuration = totalSeconds;
            this.remainingSeconds = totalSeconds;
            updateDisplay();
        }
    }

    @Override
    public void start() {
        if (remainingSeconds > 0 && !isRunning) {
            isRunning = true; // Set running state
            animationController.startAnimation(remainingSeconds);
            swingTimer.start();
        }
    }
    @Override
    public void stop() {
        if (isRunning) {
            swingTimer.stop();
            isRunning = false;
            setToIdle(); 
            for (TimerListener listener : listeners) {
                listener.onFinish();
            }
        }
    }

    @Override
    public void addTimerListener(TimerListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeTimerListener(TimerListener listener) {
        listeners.remove(listener);
    }

    @Override
    public boolean isRunning() {
        return this.isRunning;
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
                for (TimerListener listener : listeners) {
                listener.onTick(remainingSeconds);
                }
        } else {
            stop();
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
        if (isRunning) {
            displayLabel.setText("<html><div style='text-align: center;'>Brewing...<br>" + timeString + "</div></html>");
        } else if (initialDuration > 0) {
            String presetTime = String.format("%02d:%02d", initialDuration / 60, initialDuration % 60);
            displayLabel.setText("<html><div style='text-align: center;'>Ready to Brew<br>" + presetTime + "</div></html>");
        }
    }

    public void setToIdle() {
        isRunning = false;
        remainingSeconds = 0;
        initialDuration = 0;
        displayLabel.setText("<html><div style='text-align: center;'>Cozy Brew<br>Select a preset</div></html>");
        animationController.setToIdle();
    }
}
