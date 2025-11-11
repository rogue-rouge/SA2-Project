/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cozybrew.ui;

/**
 *
 * @author GROUP 3: JOHANES KINNARD COTE, MACAYLE THERESE DANCEL, MARY KIRSTEN DANIELLE IGUET, NESTOR JOSH BACANI, & ROSALIE JOY VICENTE
 */

import cozybrew.audio.SoundEffectPlayer;
import cozybrew.logic.TimerEngine;
import cozybrew.logic.TimerLogic;
import cozybrew.ui.panels.PresetsPanel;
import cozybrew.ui.panels.StartStopPanel;
import cozybrew.ui.panels.AnimationDisplayPanel;
import javax.swing.*;
import java.awt.*;

public class BrewPanel extends JPanel {

    private JLabel animationIconLabel;
    private JLabel timerTextLabel;
    private JButton sugarCubeButton;
    private TimerEngine timerEngine;
    private AnimationController animationController;
    private AssetLoader assetLoader;
    private PresetsPanel presetsPanel;
    private StartStopPanel startStopPanel;
    private AnimationDisplayPanel animationDisplayPanel;


    public BrewPanel(SoundEffectPlayer sfxPlayer) {
        this.setLayout(null);
        this.assetLoader = new AssetLoader();

        this.animationIconLabel = new JLabel(); 
        this.timerTextLabel = new JLabel(); 
        this.timerTextLabel.setForeground(Color.WHITE);
        this.timerTextLabel.setFont(new Font("Serif", Font.PLAIN, 22));
        this.timerTextLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // --- Controllers ---
        this.animationController = new AnimationController(
            this.animationIconLabel, 
            assetLoader.getAnimationFrames()
        );
        
        this.timerEngine = new TimerLogic(
            this.timerTextLabel, 
            this.animationController,
            sfxPlayer
        );

        // --- Center animation panel ---
        this.animationDisplayPanel = new AnimationDisplayPanel(animationIconLabel, timerTextLabel); 
        this.animationDisplayPanel.setBounds(330, 130, 300, 280);
        this.add(animationDisplayPanel);
        
        // --- Side panels ---
        this.presetsPanel = new PresetsPanel(timerEngine, sfxPlayer);
        this.presetsPanel.setBounds(70, 60, 180, 420);
        this.add(presetsPanel);

        this.startStopPanel = new StartStopPanel(timerEngine, sfxPlayer);
        this.startStopPanel.setBounds(710, 160, 180, 180);
        this.add(startStopPanel);

        // --- Sugar cube button ---
        sugarCubeButton = new JButton();
        sugarCubeButton.setIcon(assetLoader.getSugarCubeIcon());
        sugarCubeButton.setFocusPainted(false);
        sugarCubeButton.setContentAreaFilled(false);
        sugarCubeButton.setBorderPainted(false);
        sugarCubeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sugarCubeButton.setBounds(820, 430, 64, 64);
        this.add(sugarCubeButton);
    }

    public TimerEngine getTimerEngine() {
        return this.timerEngine;
    }
    public JButton getSugarCubeButton() {
        return this.sugarCubeButton;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image bgImage = assetLoader.getBackgroundImage();
        if (bgImage != null) {
            g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Color fallOrange = new Color(200, 100, 0);
            Color fallBrown = new Color(89, 48, 16);
            GradientPaint gp = new GradientPaint(0, 0, fallOrange, 0, getHeight(), fallBrown);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(960, 540);
    }
}
