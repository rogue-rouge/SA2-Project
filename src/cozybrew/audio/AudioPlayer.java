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

/**
 * A simple audio player for handling background music.
 * Loads a .wav file and can toggle it on (looping) and off (stop).
 */
public class AudioPlayer {

    private Clip clip;
    private boolean isPlaying = false;

    /**
     * Loads the audio clip from the given resource path.
     * @param resourcePath The path to the audio file (e.g., "/resources/audio/lofi.wav")
     */
    public AudioPlayer(String resourcePath) {
        try {
            URL audioUrl = getClass().getResource(resourcePath);
            if (audioUrl == null) {
                throw new IOException("Audio file not found: " + resourcePath);
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioUrl);

            clip = AudioSystem.getClip();
            clip.open(audioStream);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error loading audio file: " + resourcePath);
            e.printStackTrace();
            clip = null; 
        }
    }

    /**
     * Toggles the audio clip on (looping) or off (stopped).
     */
    public void toggleLoop() {
        if (clip == null) {
            System.err.println("Cannot toggle audio: Clip was not loaded.");
            return;
        }

        if (isPlaying) {
            clip.stop();
            isPlaying = false;
        } else {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            isPlaying = true;
        }
    }

    /**
     * Stops the music permanently (e.g., when closing the app).
     */
    public void stop() {
        if (clip != null) {
            clip.stop();
        }
    }
}
