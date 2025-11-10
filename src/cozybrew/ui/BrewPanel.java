/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cozybrew.ui;

/**
 *
 * @author Rosalie Joy Indelible Vicente
 */
import javax.swing.*;
import java.awt.*;
import cozybrew.logic.TimerEngine;
import cozybrew.logic.TimerLogic;
import cozybrew.ui.panels.PresetsPanel;
import cozybrew.ui.panels.StartStopPanel;
import cozybrew.ui.panels.AnimationDisplayPanel;

public class BrewPanel extends JPanel {
    private JLabel brewingAnimationLabel;
    private JButton sugarCubeButton;

    private TimerEngine timerEngine;
    private AnimationController animationController;
    private AssetLoader assetLoader;

    private PresetsPanel presetsPanel;
    private StartStopPanel startStopPanel;
    private AnimationDisplayPanel animationDisplayPanel;

    public BrewPanel() {
        this.setLayout(null);
        this.assetLoader = new AssetLoader();

        // Label controlled by Logic
        this.brewingAnimationLabel = new JLabel();
        this.brewingAnimationLabel.setForeground(Color.WHITE);
        this.brewingAnimationLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        this.brewingAnimationLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Controllers
        this.animationController = new AnimationController(
            this.brewingAnimationLabel,
            assetLoader.getAnimationFrames()
        );
        
        // Store TimerLogic as the TimerEngine interface
        this.timerEngine = new TimerLogic( 
            this.brewingAnimationLabel,
            this.animationController
        );

        // Center animation panel
        this.animationDisplayPanel = new AnimationDisplayPanel(brewingAnimationLabel);
        this.animationDisplayPanel.setBounds(330, 100, 300, 350);
        this.add(animationDisplayPanel);
        
        // Left presets panel
        this.presetsPanel = new PresetsPanel(timerEngine);
        this.presetsPanel.setBounds(70, 70, 180, 400);
        this.add(presetsPanel);

        // Right start/stop panel
        this.startStopPanel = new StartStopPanel(timerEngine);
        this.startStopPanel.setBounds(710, 180, 180, 150);
        this.add(startStopPanel);

        // Bottom-right sugar cube button
        sugarCubeButton = new JButton();
        sugarCubeButton.setIcon(assetLoader.getSugarCubeIcon());
        sugarCubeButton.setFocusPainted(false);
        sugarCubeButton.setContentAreaFilled(false);
        sugarCubeButton.setBorderPainted(false);
        sugarCubeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sugarCubeButton.setBounds(826, 406, 64, 84);
        this.add(sugarCubeButton);
    }

    // Getters
    public TimerEngine getTimerEngine() {
        return this.timerEngine;
    }

    // Getter for audio
    public JButton getSugarCubeButton() {
        return this.sugarCubeButton;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Image bgImage = assetLoader.getBackgroundImage();

        if (bgImage != null) {
            // Draws the background image to fill the panel
            g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
        }  else {
            // Fallback: Draws a cozy gradient if the image failed to load
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Color fallOrange = new Color(200, 100, 0);
            Color fallBrown = new Color(89, 48, 16);
            GradientPaint gp = new GradientPaint(0, 0, fallOrange, 0, getHeight(), fallBrown);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
