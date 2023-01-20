package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class Lift_lvl5 extends Walker implements StepListener {

    private float up, down;

    private static final BodyImage lift_lvl5Image = new BodyImage("assets/A_World_06.png", 1);
    private static final Shape lift_lvl5Shape = new BoxShape(1f,0.5f);
    Fixture fixture = new SolidFixture(this, lift_lvl5Shape, 1000);

    private final int SPEED = 20;


    //make the platform go up and down (like a lift)
    public Lift_lvl5(World world){
        super(world, lift_lvl5Shape);
        addImage(lift_lvl5Image);
        world.addStepListener(this);
        jump(SPEED);
    }

    @Override
    public void setPosition(Vec2 position){
        super.setPosition(position);
        down = position.y;
        up = position.y;

    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if(getPosition().y > up)
            jump(-SPEED);
        if (getPosition().y < down)
            jump(SPEED);
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
