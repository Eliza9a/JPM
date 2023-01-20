package game;


import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class Coin extends StaticBody{

    private static final Shape coinsShape = new CircleShape(0.5f);
    private static SoundClip coinSound;


    //add image to coin
    private static final BodyImage image =
            new BodyImage("assets/coin.png", 1f);

    public Coin(World w) {
        super(w,coinsShape);
        addImage(image);
    }

    //add sound
    static {
        try {
            coinSound = new SoundClip("assets/coin.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    //play sound when the coin is collected
    @Override
    public void destroy()
    {
        coinSound.play();
        super.destroy();
    }

}
