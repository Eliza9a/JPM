package game;


import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class MediumObstacle extends StaticBody{

    private static final Shape MediumObstacleShape = new BoxShape(2,2);
    private static SoundClip destroySound;


    //add image to the obstacle
    private static final BodyImage image =
            new BodyImage("assets/8.png", 4);

    public MediumObstacle(World w) {
        super(w,MediumObstacleShape);
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

