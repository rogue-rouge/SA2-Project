/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cozybrew.main;

import cozybrew.ui.BrewPanel;
import javax.swing.*;

/**
 *
 * @author Rosalie Joy Indelible Vicente
 */

public class MainFrame extends JFrame {

    private BrewPanel brewPanel;

    public MainFrame() {
        super("CozyBrew Timer");

        this.brewPanel = new BrewPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(960, 540); 
        this.setLocationRelativeTo(null);
        this.setContentPane(brewPanel);
        this.setResizable(false);
        this.setVisible(true);
    }
}
