package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Obstacle_lvl5 extends Walker implements StepListener{

    private float left, right;
    private static SoundClip destroySound;

    private static final BodyImage obstacleImage = new BodyImage("assets/A_World_04.png", 2);
    private static final Shape obstacleShape = new BoxShape(1f, 1f);
    private final int SPEED = 2;


    public Obstacle_lvl5(World world){
        super(world, obstacleShape);
        addImage(obstacleImage);
        world.addStepListener(this);
        startWalking(SPEED);
    }

    //make the obstacle patrol tot the left and to the right (patrol)
    @Override
    public void setPosition(Vec2 position){
        super.setPosition(position);
        left = position.x-1.5f;
        right = position.x+1.5f;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if(getPosition().x > right)
            startWalking(-SPEED);
        if (getPosition().x < left)
            startWalking(SPEED);
    }

    @Override
    public void postStep(StepEvent stepEvent) {

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

