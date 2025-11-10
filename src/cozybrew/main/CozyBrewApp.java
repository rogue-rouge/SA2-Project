/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cozybrew.main;

import javax.swing.*;


/**
 *
 * @author Rosalie Joy Indelible Vicente
 */

public class CozyBrewApp {

    public static void main(String[] args) {
        // Ensure that Swing components are created and updated on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create and show the MainFrame
                new MainFrame();
            }
        });
    }
}