/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cozybrew.logic;

/**
 *
 * @author GROUP 3: JOHANES KINNARD COTE, MACAYLE THERESE DANCEL, MARY KIRSTEN DANIELLE IGUET, NESTOR JOSH BACANI, & ROSALIE JOY VICENTE
 */

public interface TimerEngine {
    void setDurationSeconds(int seconds);
    void start();
    void stop();
    boolean isRunning();
    void addTimerListener(TimerListener listener);
    void removeTimerListener(TimerListener listener);
}
