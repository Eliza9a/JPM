package game;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel {
    public JPanel mainPanel;
    private JButton PAUSEButton;
    private JButton RESUMEButton;
    private JButton REPLAYButton;
    private JButton SETTINGSButton;
    private JButton HELPButton;
    private JButton LEVELSButton;




    private Game game;
    public ControlPanel(Game game) {
        SETTINGSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToSettings();

            }
        });
        PAUSEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.pauseGame();
            }
        });
        RESUMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.resumeGame();
            }
        });
        REPLAYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.replayGame();
            }
        });
        LEVELSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToLevels();
            }
        });
        HELPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              game.transitionToHelp();
            }
        });
    }
}
