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

        this.bgmPlayer = new AudioPlayer("/resources/audio/lofi.wav");
        this.sfxPlayer = new SoundEffectPlayer();

        this.brewPanel = new BrewPanel(sfxPlayer);
        
        this.setContentPane(brewPanel);

        JButton sugarCube = brewPanel.getSugarCubeButton();
        sugarCube.addActionListener(e -> {
            sfxPlayer.playSound("click");
            bgmPlayer.toggleLoop();
        });
        
        bgmPlayer.toggleLoop(); 

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
