/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cozybrew.main;

import cozybrew.ui.BrewPanel;
import cozybrew.audio.AudioPlayer;
import cozybrew.audio.SoundEffectPlayer;
import javax.swing.*;
import java.awt.Dimension; 

/**
 *
 * @author GROUP 3: JOHANES KINNARD COTE, MACAYLE THERESE DANCEL, MARY KIRSTEN DANIELLE IGUET, NESTOR JOSH BACANI, & ROSALIE JOY VICENTE
 */

public class MainFrame extends JFrame {

    private BrewPanel brewPanel;
    private AudioPlayer bgmPlayer;
    private SoundEffectPlayer sfxPlayer;

    public MainFrame() {
        super("CozyBrew Timer");

        // Audio Player
        this.bgmPlayer = new AudioPlayer("/resources/audio/lofi.wav");
        
        // SFX Player
        this.sfxPlayer = new SoundEffectPlayer();
        this.brewPanel = new BrewPanel(sfxPlayer);
        
        // Panel Setup
        brewPanel.setPreferredSize(new Dimension(960, 540));
        this.setContentPane(brewPanel);
        
        // Connect to Sugar Cube
        JButton sugarCube = brewPanel.getSugarCubeButton();
        sugarCube.addActionListener(e -> {
            sfxPlayer.playSound("click"); 
            bgmPlayer.toggleLoop();
        });
        // Auto Start Music
        bgmPlayer.toggleLoop(); // Start playing on launch

        // Frame Setup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(brewPanel);
        this.setResizable(false);
        this.setVisible(true);
    }
}
