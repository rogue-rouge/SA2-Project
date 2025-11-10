package testcontrolsmain;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestControlsMain {
    private static int remainingSeconds = 0;
    private static Timer swingTimer;
    private static boolean musicOn = false;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Countdown Timer Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JPanel panel = new JPanel(new BorderLayout());
            JLabel statusLabel = new JLabel("Select a preset to start brewing (Start of Timer)");
            statusLabel.setFont(new Font("Serif", Font.PLAIN, 18));
            panel.add(statusLabel, BorderLayout.CENTER);

            JMenuBar menuBar = new JMenuBar();
            JMenu presetsMenu = new JMenu("Presets");

            String[] presetNames = {"1 min", "5 min", "10 min", "15 min", "30 min", "45 min", "1 hour"};
            int[] presetSeconds = {60, 300, 600, 900, 1800, 2700, 3600};

            for (int i = 0; i < presetNames.length; i++) {
                String name = presetNames[i];
                int seconds = presetSeconds[i];

                JMenuItem item = new JMenuItem(name);
                item.addActionListener(e -> startTimer(seconds, name, statusLabel));
                presetsMenu.add(item);
            }

            menuBar.add(presetsMenu);
            frame.setJMenuBar(menuBar);

            JButton musicButton = new JButton("Sugarcube (BGM OFF)");
            musicButton.addActionListener(e -> toggleMusic(musicButton));
            JPanel bottomPanel = new JPanel();
            bottomPanel.add(musicButton);
            panel.add(bottomPanel, BorderLayout.SOUTH);

            frame.add(panel);
            frame.setVisible(true);
        });
    }

    private static void startTimer(int seconds, String label, JLabel statusLabel) {
        if (swingTimer != null && swingTimer.isRunning()) {
            swingTimer.stop();
        }

        remainingSeconds = seconds;
        statusLabel.setText("Brewing for " + label + "...");

        swingTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (remainingSeconds > 0) {
                    statusLabel.setText("Brewing... " + remainingSeconds + "s left");
                    remainingSeconds--;
                } else {
                    ((Timer) e.getSource()).stop();
                    statusLabel.setText("Brewing complete!");
                    System.out.println("Brewin done!");
                }
            }
        });
        swingTimer.start();
    }

    private static void toggleMusic(JButton button) {
        musicOn = !musicOn;
        if (musicOn) {
            button.setText("Sugarcube Insert here (BGM ON)");
            System.out.println("BGM started.");
        } else {
            button.setText("Sugarcube Insert here (BGM OFF)");
            System.out.println("BGM stopped.");
        }
    }
}
