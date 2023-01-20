package game;


import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class BigObstacle extends StaticBody{

    private static final Shape bigObstacleShape = new BoxShape(3,3);
    private static SoundClip destroySound;


    //add image to the big obstacle
    private static final BodyImage image =
            new BodyImage("assets/A_World_05.png", 6);


    public BigObstacle(World w) {
        super(w,bigObstacleShape);
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
    //play sound when the obstacle is hit
    @Override
    public void destroy()
    {
        destroySound.play();
        super.destroy();
    }

}

