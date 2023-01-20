package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;


public abstract class GameLevel extends World {

    private final Player player;
    private final Portal portal;

    public GameLevel(Game game){

        //create the top limit
        Shape shape = new BoxShape(15.77f, 0.5f);
        StaticBody top = new StaticBody(this, shape);
        top.setPosition(new Vec2(0, 15.5f));

        //create the left and right limits
        Shape wallShape = new BoxShape(0.2f, 20);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-16, -4));

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(16, -4));

        //create player and portal
        player = new Player(this);
        portal = new Portal(this);

        PortalEncounter encounter = new PortalEncounter(this, game);
        player.addCollisionListener(encounter);
    }

    public Player getPlayer() { return player; }
    public Portal getPortal(){
        return portal;
    }

    public abstract boolean isComplete();

    public abstract Image getBackground();

    public abstract SoundClip getGameMusic();

}
