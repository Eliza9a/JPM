package game;


import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class SmallObstacle extends StaticBody{

    private static final Shape SmallObstacleShape = new BoxShape(1,1);
    private static SoundClip destroySound;

    //add image to the obstacle
    private static final BodyImage image =
            new BodyImage("assets/7.png", 2);

    public SmallObstacle(World w) {
        super(w,SmallObstacleShape);
        addImage(image);
    }

    //add sound
    static {
        try {
            destroySound = new SoundClip("assets/hitmonster.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    //play sound when obstacle is hit
    @Override
    public void destroy()
    {
        destroySound.play();
        super.destroy();
    }

}

