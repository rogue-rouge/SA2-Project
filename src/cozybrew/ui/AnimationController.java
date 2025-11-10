/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cozybrew.ui;

/**
 *
 * @author Kirs Iguet
 */
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AnimationController {
    private JLabel animationLabel;
    private ImageIcon[] frames;
    private int totalDuration;

        /**
     * animationLabel The JLabel that will display the animation.
     * frames The array of images (loaded by AssetLoader).
     */
    public AnimationController(JLabel animationLabel, ImageIcon[] frames) {
        this.animationLabel = animationLabel;
        this.frames = frames;
        
        setToIdle();
    }

        /**
     * Called by TimerLogic when the timer starts.
     * totalSeconds The total duration of the timer.
     */
    public void startAnimation(int totalSeconds) {
        this.totalDuration = totalSeconds;
        if (frames.length > 1) {
            animationLabel.setIcon(frames[1]);
        }
    }

        /**
     * Called by TimerLogic on every tick of the timer.
     * remainingSeconds The number of seconds left.
     */
     public void updateFrame(int remainingSeconds) {
        if (frames.length != 4) {
            System.err.println("AnimationController expects 4 frames, but found " + frames.length);
            return;
        }
          
        int secondsElapsed = totalDuration - remainingSeconds;

        if (secondsElapsed % 2 == 0) {
            // On even seconds (elapsed), show frame 1 (brew2.png)
            animationLabel.setIcon(frames[1]);
        } else {
            // On odd seconds (elapsed), show frame 2 (brew3.png)
            animationLabel.setIcon(frames[2]);
        }
    }

    /**
     * Called by TimerLogic when the timer hits 0.
     */
    public void setComplete() {
        // Set to final frame (brew4.png)
        if (frames.length > 3) {
            animationLabel.setIcon(frames[3]);
        }
    }
    
    /**
     * Called by TimerLogic to reset to the idle state.
     */
    public void setToIdle() {
        // Set to idle frame (brew1.png)
        if (frames.length > 0) {
            animationLabel.setIcon(frames[0]);
        }
    }
}
