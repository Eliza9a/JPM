package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *Create a lift
 * <p>
 *     It can move up and down and uses a step listener to make it able to "patrol" a specific area
 * </p>
 */
public class Lift_lvl4 extends Walker implements StepListener {

    private float up;

    private static final BodyImage lift_lvl4Image = new BodyImage("assets/21.png", 3);
    private static final Shape lift_lvl4Shape = new PolygonShape(-2.59f,0.43f, -1.48f,1.42f, 0.59f,1.5f, 2.25f,0.92f, 2.5f,0.33f, 0.47f,-1.48f, -0.63f,-1.47f);
    Fixture fixture = new SolidFixture(this, lift_lvl4Shape, 1000);
    private final int SPEED = 20;


    public Lift_lvl4(World world){
        super(world, lift_lvl4Shape);
        addImage(lift_lvl4Image);
        world.addStepListener(this);
        jump(SPEED);
    }

    /**
     * Set the position of the platform
     * @param position
     */
    @Override
    public void setPosition(Vec2 position){
        super.setPosition(position);
        up = position.y;
    }

    /**
     * Make the platform move depending on it's position
     * <p>
     *     If the platform is up, at the limit, it goes down, otherwise it goes up
     * </p>
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        if(getPosition().y > up)
            jump(-SPEED);
        if (getPosition().y < up)
            jump(SPEED);
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
