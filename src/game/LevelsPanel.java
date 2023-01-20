package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelsPanel {
    public JPanel mainPanel;
    private JButton LEVEL4Button;
    private JButton LEVEL5Button;
    private JButton LEVEL3Button;
    private JButton LEVEL2Button;
    private JButton LEVEL1Button;
    private JButton BACKButton;

    private Game game;

    public LevelsPanel(Game game) {
        LEVEL1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.replayGame();
            }
        });
        LEVEL2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.goToLevel2();
            }
        });
        LEVEL3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.goToLevel3();
            }
        });
        LEVEL4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.goToLevel4();
            }
        });
        LEVEL5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.goToLevel5();
            }
        });
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToMain1();
            }
        });
    }
}
