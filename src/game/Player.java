package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *Creates the player
 * <p>
 *     It extends Walker which means that it can move left, right, up and down
 * </p>
 */
public class Player extends Walker {

    private String direction;
    private int coins;
    private int energy;


    private static final Shape playerShape = new PolygonShape(-1.014f, 0.52f, -0.614f, 1.295f, 0.468f, 1.295f, 0.962f, 0.629f, 1.019f, -0.707f, 0.447f, -1.295f, -0.837f, -1.295f, -1.009f, -0.822f);

    private static final BodyImage rightImage = new BodyImage("character/Right/pl_s_right1.gif", 2.6f);
    private static final BodyImage leftImage = new BodyImage("character/Left/pl_s_left.gif", 2.6f);


    public Player(World world) {
        super(world, playerShape);
        addImage(leftImage);
        coins = 0;
        direction = "left";
        energy = 100;
    }

    /**
     * This method is used for the walking status of the player
     * * @param speed is used to check if the player is moving to the left or to the right so it changes the image depending
     *              on the direction of the player.
     */
    @Override
    public void startWalking(float speed) {
        super.startWalking(speed);
        if (speed < 0) {
            this.removeAllImages();
            this.addImage(leftImage);
            direction = "left";
        } else {
            this.removeAllImages();
            this.addImage(rightImage);
            direction = "right";
        }
    }

    //shooting to the left or right

    /**
     * Shooting to the left or right
     * <p>
     *     This method is used for shooting to the left or right depending on the player position. If it is to the left, it will
     *     shoot from the position of the player-1, is it is to the right, it will shoot from the player's position+1
     * </p>
     *
     */
    public void shoot() {
        DynamicBody flame = new DynamicBody(this.getWorld(), new CircleShape(0.3f));
        flame.addCollisionListener(new FlameCollision());


        if (direction.equals("left")) {
            flame.setLinearVelocity(new Vec2(-10, 0));
            flame.setPosition(new Vec2(this.getPosition().x - 1, this.getPosition().y));
        } else {
            flame.setLinearVelocity(new Vec2(10, 0));
            flame.setPosition(new Vec2(this.getPosition().x + 1, this.getPosition().y));
        }
        flame.addImage(new BodyImage("assets/flame.png"));
    }


    /**
     * Shooting in the direction of the mouse
     * <p>
     *     This method is used for shooting where the mouse is.
     * </p>
     *
     */
    //shooting in the direction of the mouse
    public void shoot(Vec2 t) {
        DynamicBody flame = new DynamicBody(this.getWorld(), new CircleShape(0.3f));
        flame.addCollisionListener(new FlameCollision());

        Vec2 dir = t.sub(this.getPosition());
        dir.normalize();

        flame.setPosition(this.getPosition().add(dir.mul(0.5f)));
        flame.setLinearVelocity(dir.mul(20));
        flame.addImage(new BodyImage("assets/flame.png"));

    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getCoins() {
        return coins;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

}