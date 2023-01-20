package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class PlayerController  implements KeyListener {

    private Player player;
    private final Game game;
    private SoundClip steps;

    public PlayerController(Player player, Game g) {
        this.player = player;
        this.game = g;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        try {
            steps = new SoundClip("assets/steps.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
            System.out.println(e);
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.startWalking(-3);
            steps.play();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.startWalking(3);
            steps.play();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.jump(10);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.jump(8);
        }

         if (e.getKeyCode() == KeyEvent.VK_SHIFT) {

                if (player.getCoins() >= 3) {
                    player.shoot();
                    player.setCoins(player.getCoins() - 3);
                } else
                    System.out.println("Not enough coins");

        }
        if (e.getKeyCode() == KeyEvent.VK_M) {
            game.toggleMenu();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.stopWalking();

        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT  ){
            steps.stop();
        }
    }

    public void updatePlayer(Player player) {
        this.player = player;
    }

}