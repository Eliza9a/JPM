package game;

import city.cs.engine.SoundClip;
import city.cs.engine.World;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SettingsPanel {
    public JPanel mainPanel;
    private JSlider MusicV;
    private JButton BACKButton;
    private SoundClip gameMusic;
    private Game game;
    private GameLevel level;

    public SettingsPanel(GameLevel l, Game game) {
        this.game = game;
        level = l;
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToMain();

            }
        });


        MusicV.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MusicV.getValue();
                System.out.println(MusicV.getValue());
                if (MusicV.getValue() == 0)
                    game.noVolume();
                else if (MusicV.getValue() == 2)
                    game.maxVolume();
                else
                    game.medVolume();
            }
        });

    }

}
