package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class helpPanel {
    private JButton BACKButton;
    public JPanel mainPanel;

    private Game game;

    public helpPanel(Game game) {
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToMain2();
            }
        });
    }
}
