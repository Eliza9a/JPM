package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy extends Walker implements StepListener{

    private float left, right;

    private static final BodyImage iceCubeImage = new BodyImage("assets/A_World_04.png", 2);
    private static final Shape iceCubeShape = new BoxShape(1f, 1f);
    private final int SPEED = 2;


    public Enemy(World world){
        super(world, iceCubeShape);
        addImage(iceCubeImage);
        world.addStepListener(this);
        startWalking(SPEED);
    }

    //make the enemy patrol to the left and right
    @Override
    public void setPosition(Vec2 position){
        super.setPosition(position);
        left = position.x-1f;
        right = position.x+1f;
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
}
