package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Obstacle_lvl4 extends Walker implements StepListener{

    private float left, right;
    private static SoundClip destroySound;

    private static final BodyImage dangerImage = new BodyImage("assets/79.png", 4);
    private static final Shape dangerShape = new PolygonShape(-2.35f,-1.32f, -0.66f,1.99f, 2.25f,-0.54f, 2.36f,-1.86f, -0.87f,-1.95f);
    private final int SPEED = 2;


    public Obstacle_lvl4(World world){
        super(world, dangerShape);
        addImage(dangerImage);
        world.addStepListener(this);
        startWalking(SPEED);
    }

    //make the obstacle move to the left and to the right (patrol)
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

    //add sound when obstacle is hit
    @Override
    public void destroy()
    {
        destroySound.play();
        super.destroy();
    }

}
