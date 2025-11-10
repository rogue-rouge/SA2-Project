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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import cozybrew.logic.TimerLogic;

public class BrewPanel extends JPanel {
    private JLabel brewingAnimationLabel;
    private JButton sugarCubeButton;

    private TimerLogic timerLogic;
    private AnimationController animationController;
    private AssetLoader assetLoader;

    public BrewPanel() {
        this.setLayout(new BorderLayout(20, 20));
        this.assetLoader = new AssetLoader();

        brewingAnimationLabel = new JLabel();
        brewingAnimationLabel.setText("<html><div style='text-align: center;'>CozyBrew Timer<br>--:--</div></html>");
        brewingAnimationLabel.setFont(new Font("Serif", Font.ITALIC, 28));
        brewingAnimationLabel.setForeground(Color.WHITE);
        brewingAnimationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        brewingAnimationLabel.setOpaque(false);

        brewingAnimationLabel.setIcon(assetLoader.getAnimationFrames()[0]);
        brewingAnimationLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        brewingAnimationLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(brewingAnimationLabel);
        this.add(centerPanel, BorderLayout.CENTER);

        sugarCubeButton = new JButton();
        sugarCubeButton.setIcon(assetLoader.getSugarCubeIcon());

        sugarCubeButton.setFocusPainted(false);
        sugarCubeButton.setContentAreaFilled(false);
        sugarCubeButton.setBorderPainted(false);
        sugarCubeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 15));
        buttonPanel.setOpaque(false);
        buttonPanel.add(sugarCubeButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.animationController = new AnimationController(
            this.brewingAnimationLabel,
            assetLoader.getAnimationFrames()
        );

        this.timerLogic = new TimerLogic(
            this.brewingAnimationLabel,
            this.animationController
        );
}
//Getter for menus
    public TimerLogic getTimerLogic() {
        return this.timerLogic;
    }

//Getter for audio
    public JButton getSugarCubeButton() {
        return this.sugarCubeButton;
    }

//Draws bg image loaded by assetloader
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Image bgImage = assetLoader.getBackgroundImage();

        if (bgImage != null) {
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
