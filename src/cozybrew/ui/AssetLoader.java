/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cozybrew.ui;

/**
 *
 * @author GROUP 3: JOHANES KINNARD COTE, MACAYLE THERESE DANCEL, MARY KIRSTEN DANIELLE IGUET, NESTOR JOSH BACANI, & ROSALIE JOY VICENTE
 */

import javax.swing.ImageIcon;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class AssetLoader {
    private Image backgroundImage;
    private ImageIcon[] animationFrames;
    private ImageIcon sugarCubeIcon;

    public AssetLoader() {
        loadBackgroundImage();
        loadAnimationFrames();
        loadButtonIcons();
    }

    private void loadBackgroundImage() {
        try {
            this.backgroundImage = ImageIO.read(getClass().getResource("/resources/img/brewbg.png"));
        } catch (Exception e) {
            System.err.println("Failed to load /resources/img/brewbg.png. Using fallback gradient.");
            e.printStackTrace();
            this.backgroundImage = null;
        }
    }

    private void loadAnimationFrames() {
        String[] frameNames = {
            "brew1.png",
            "brew2.png",
            "brew3.png",
            "brew4.png"
        };
        
        this.animationFrames = new ImageIcon[frameNames.length];
        
        for (int i = 0; i < frameNames.length; i++) {
            String path = "/resources/img/" + frameNames[i];
            try {
                ImageIcon originalIcon = new ImageIcon(getClass().getResource(path));
                this.animationFrames[i] = scaleIcon(originalIcon, 200, 200);
            } catch (Exception e) {
                System.err.println("Failed to load animation frame: " + path);
                this.animationFrames[i] = createPlaceholderIcon("Failed: " + frameNames[i], 100, 100);
            }
        }
    }

    private void loadButtonIcons() {
        try {
            ImageIcon originalIcon = new ImageIcon(getClass().getResource("/resources/img/sugar_cube.png"));
            
            this.sugarCubeIcon = scaleIcon(originalIcon, 64, 64);

        } catch (Exception e) {
            System.err.println("Failed to load /resources/img/sugar_cube.png. Using placeholder.");
            this.sugarCubeIcon = createPlaceholderIcon("Icon", 64, 64);
        }
    }
    

    public Image getBackgroundImage() {
        return this.backgroundImage;
    }

    public ImageIcon[] getAnimationFrames() {
        return this.animationFrames;
    }
    
    public ImageIcon getSugarCubeIcon() {
        return this.sugarCubeIcon;
    }

    private ImageIcon createPlaceholderIcon(String text, int width, int height) {
        java.awt.image.BufferedImage img = new java.awt.image.BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(new Color(255, 255, 255, 50));
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.WHITE);
        g2d.drawRect(0, 0, width - 1, height - 1);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 10));
        g2d.drawString(text, 5, height / 2);
        g2d.dispose();
        return new ImageIcon(img);
    }
    
        private ImageIcon scaleIcon(ImageIcon icon, int width, int height) {
        if (icon == null || icon.getImage() == null) {
            return null;
        }
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }
}
