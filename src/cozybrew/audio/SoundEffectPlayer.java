/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cozybrew.audio;

/**
 *
 * @author GROUP 3: JOHANES KINNARD COTE, MACAYLE THERESE DANCEL, MARY KIRSTEN DANIELLE IGUET, NESTOR JOSH BACANI, & ROSALIE JOY VICENTE
 */
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Loads and plays short sound effects.
 * Sounds are pre-loaded into a Map for instant playback.
 */
public class SoundEffectPlayer {
    private Map<String, Clip> soundClips;

    public SoundEffectPlayer() {
        soundClips = new HashMap<>();
        loadSound("ding", "/resources/audio/ding.wav");
        loadSound("click", "/resources/audio/click.wav");
    }

    /**
     * Loads a single sound file into the map.
     * @param name The simple name to refer to the sound (e.g., "click")
     * @param resourcePath The full path to the .wav file
     */
    private void loadSound(String name, String resourcePath) {
        try {
            URL audioUrl = getClass().getResource(resourcePath);
            if (audioUrl == null) {
                throw new IOException("Audio file not found: " + resourcePath);
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioUrl);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            soundClips.put(name, clip);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error loading sound effect: " + resourcePath);
            e.printStackTrace();
        }
    }
    
    /**
     * Plays the pre-loaded sound effect once.
     * @param name The name of the sound to play (e.g., "click" or "ding")
     */
    public void playSound(String name) {
        Clip clip = soundClips.get(name);
        if (clip != null) {
            if (clip.isRunning()) {
                clip.stop(); 
            }
            clip.setFramePosition(0);
            clip.start(); 
        } else {
            System.err.println("Could not play sound: " + name + ". Was it loaded?");
        }
    }
}
