package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Level5 extends GameLevel {

    private SoundClip gameMusic;
    private final Image background;

    public Level5(Game game) {

        super(game);

        background = new ImageIcon("assets/cavern-background-free-vector.jpg").getImage();

        //add player, portal
        getPlayer().setPosition(new Vec2(-14, -8.5f));
        getPortal().setPosition(new Vec2(13,12.5f));
        getPlayer().addCollisionListener(new PlayerCollisions(getPlayer(), game));

        //add music
        try {
            gameMusic = new SoundClip("assets/level5.wav");   // Open an audio input stream
            gameMusic.loop();
            gameMusic.setVolume(0.5);


        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        //make the ground
        Shape shape = new BoxShape(15.77f, 0.5f);

        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -14.5f));


        // make platforms
        Shape boxShape1 = new BoxShape(2,2);
        StaticBody box1 = new StaticBody(this, boxShape1);
        box1.setPosition(new Vec2(-13.8f, -12));
        box1.addImage(new BodyImage("assets/redp2.png", 4));

        Shape floatingPlatformShape = new PolygonShape(-2.333f,0.617f, -0.999f,0.972f, 1.419f,0.953f, 2.305f,0.655f, 1.848f,-0.568f, 0.0f,-0.969f, -1.979f,-0.372f);
        StaticBody floatingPlatform1 = new StaticBody(this, floatingPlatformShape);
        floatingPlatform1.setPosition(new Vec2(-5, -11));
        floatingPlatform1.addImage( new BodyImage("assets/A_World_03.png",2));

        StaticBody floatingPlatform2 = new StaticBody(this, floatingPlatformShape);
        floatingPlatform2.setPosition(new Vec2(-10, -6.5f));
        floatingPlatform2.addImage( new BodyImage("assets/A_World_03.png",2));


        StaticBody floatingPlatform3 = new StaticBody(this, floatingPlatformShape);
        floatingPlatform3.setPosition( new Vec2(-14.3f, -1.5f));
        floatingPlatform3.addImage( new BodyImage("assets/A_World_03.png",2));


        StaticBody floatingPlatform4 = new StaticBody(this,floatingPlatformShape);
        floatingPlatform4.setPosition(new Vec2(-5, -1.5f));
        floatingPlatform4.addImage( new BodyImage("assets/A_World_03.png",2));


        StaticBody floatingPlatform5 = new StaticBody(this, floatingPlatformShape);
        floatingPlatform5.setPosition(new Vec2(0, -6.5f));
        floatingPlatform5.addImage( new BodyImage("assets/A_World_03.png",2));


        StaticBody floatingPlatform6 = new StaticBody(this, floatingPlatformShape);
        floatingPlatform6.setPosition(new Vec2(0, 3));
        floatingPlatform6.addImage( new BodyImage("assets/A_World_03.png",2));


        StaticBody floatingPlatform7 = new StaticBody(this, floatingPlatformShape);
        floatingPlatform7.setPosition(new Vec2(-6,7));
        floatingPlatform7.addImage( new BodyImage("assets/A_World_03.png",2));


        StaticBody floatingPlatform8 = new StaticBody(this, floatingPlatformShape);
        floatingPlatform8.setPosition(new Vec2(-13, 9.5f));
        floatingPlatform8.addImage( new BodyImage("assets/A_World_03.png",2));


        StaticBody floatingPlatform9 = new StaticBody(this, floatingPlatformShape);
        floatingPlatform9.setPosition(new Vec2(6, 7));
        floatingPlatform9.addImage( new BodyImage("assets/A_World_03.png",2));


        StaticBody floatingPlatform10 = new StaticBody(this, floatingPlatformShape);
        floatingPlatform10.setPosition(new Vec2(13, 9.5f));
        floatingPlatform10.addImage( new BodyImage("assets/A_World_03.png",2));


        Shape  bigPlatformShape = new BoxShape(2.5f,2.5f);
        StaticBody bigPlatform = new StaticBody(this, bigPlatformShape);
        bigPlatform.setPosition(new Vec2(5, -12));
        bigPlatform.addImage( new BodyImage("assets/redp3.png",5));


        //make the walls
        Shape wallShape = new BoxShape(0.2f, 20);

        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-16, -4));

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(16, -4));


        //make obstacles
        new Enemy(this).setPosition(new Vec2(13.5f, -13));
        new Enemy(this).setPosition(new Vec2(6, 9));

        new Lava(this).setPosition(new Vec2(-4.6f, -14));

        new BigObstacle(this).setPosition(new Vec2(5f, -6.7f));
        new MediumObstacle(this).setPosition(new Vec2(5f, -7.7f));
        new SmallObstacle(this).setPosition(new Vec2(5f, -8.7f));


        //make coins
        new Coin(this).setPosition(new Vec2(-6f, -9.5f));
        new Coin(this).setPosition(new Vec2(-5f, -9.5f));
        new Coin(this).setPosition(new Vec2(-4, -9.5f));
        new Coin(this).setPosition(new Vec2(-5.5f, -8.5f));
        new Coin(this).setPosition(new Vec2(-4.5f, -8.5f));
        new Coin(this).setPosition(new Vec2(-5, -7.5f));
        new Coin(this).setPosition(new Vec2(-5.5f, 0));
        new Coin(this).setPosition(new Vec2(-7, 0));
        new Coin(this).setPosition(new Vec2(-4, 0));
        new Coin(this).setPosition(new Vec2(-10, -5));
        new Coin(this).setPosition(new Vec2(-8, -1));
        new Coin(this).setPosition(new Vec2(-9.5f, -2.5f));
        new Coin(this).setPosition(new Vec2(-2, -1));
        new Coin(this).setPosition(new Vec2(0, -5));
        new Coin(this).setPosition(new Vec2(-1, -2.5f));
        new Coin(this).setPosition(new Vec2(0, 6));
        new Coin(this).setPosition(new Vec2(-6, 9));
        new Coin(this).setPosition(new Vec2(-1, 7.5f));
        new Coin(this).setPosition(new Vec2(-2.5f, 8.5f));
        new Coin(this).setPosition(new Vec2(-4, 9));


        //make energy drink
        new EnergyDrink_lvl5(this).setPosition(new Vec2(-14, 0));
        new EnergyDrink_lvl5(this).setPosition(new Vec2(-13, 11));

        //lift
        new Lift_lvl5(this).setPosition(new Vec2(11, 0));

    }

    //condition to pass the level
    @Override
    public boolean isComplete() {
        if (getPlayer().getCoins() == 11)
            return true;
        else
            return false;
    }

    @Override
    public Image getBackground() {
        return background;
    }

    public SoundClip getGameMusic() {
        return gameMusic;
    }

}

