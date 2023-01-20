package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Level4 extends GameLevel {

    private SoundClip gameMusic;
    private final Image background;

    public Level4(Game game) {

        super(game);

        background = new ImageIcon("assets/OIP.jpg").getImage();

        //add player, portal
        getPlayer().setPosition(new Vec2(-13, -8.5f));
        getPortal().setPosition(new Vec2(5,12));
        getPlayer().addCollisionListener(new PlayerCollisions(getPlayer(), game));

        //add music
        try {
            gameMusic = new SoundClip("assets/level4.wav");   // Open an audio input stream
            gameMusic.loop();
            gameMusic.setVolume(0.5);


        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        //make the ground
        Shape shape = new BoxShape(15.77f, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -14.5f));

        //make the platforms
        Shape platformShape= new BoxShape(2,2 );
        StaticBody platform1= new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-14,-12));
        platform1.addImage(new BodyImage("assets/ilmenskie-cave-big-platform-1.png", 4));

        Shape floatingPlat = new PolygonShape(-2.27f,0.95f, -0.87f,1.44f, 0.89f,1.42f, 2.45f,0.84f, 2.5f,0.18f, 0.55f,-1.45f, -0.75f,-1.45f, -2.54f,0.29f);
        StaticBody floatingPlatform1 = new StaticBody(this, floatingPlat);
        floatingPlatform1.setPosition(new Vec2(-9, -7));
        floatingPlatform1.addImage(new BodyImage("assets/21.png", 3f));

        StaticBody floatingPlatform2 = new StaticBody(this, floatingPlat);
        floatingPlatform2.setPosition(new Vec2(-14.5f, -2.5f));
        floatingPlatform2.addImage(new BodyImage("assets/21.png", 3f));

        StaticBody floatingPlatform3 = new StaticBody(this, floatingPlat);
        floatingPlatform3.setPosition(new Vec2(-7.5f, 2.5f));
        floatingPlatform3.addImage(new BodyImage("assets/21.png", 3f));

        StaticBody floatingPlatform4 = new StaticBody(this, floatingPlat);
        floatingPlatform4.setPosition(new Vec2(8, -7));
        floatingPlatform4.addImage(new BodyImage("assets/21.png", 3f));

        Shape floatingPlat2 = new BoxShape(4, 1);
        StaticBody floatingPlatform5 = new StaticBody(this, floatingPlat2);
        floatingPlatform5.setPosition(new Vec2(-0.5f, 1));
        floatingPlatform5.addImage(new BodyImage("assets/ilmenskie-cave-3platform-hi.png", 2f));

        StaticBody floatingPlatform6 = new StaticBody(this, floatingPlat2);
        floatingPlatform6.setPosition(new Vec2(7, 8));
        floatingPlatform6.setAngleDegrees(-20);
        floatingPlatform6.addImage(new BodyImage("assets/ilmenskie-cave-3platform-hi.png", 2f));

        Shape bridgeShape = new BoxShape(3, 0.3f);
        StaticBody bridge1 = new StaticBody(this, bridgeShape);
        bridge1.setPosition(new Vec2(-5.5f, -6.2f));
        bridge1.addImage(new BodyImage("assets/bridge.png", 0.9f));

        StaticBody bridge2 = new StaticBody(this, bridgeShape);
        bridge2.setPosition(new Vec2(4.5f, -6.2f));
        bridge2.addImage(new BodyImage("assets/bridge.png", 0.9f));

        Shape platformShape2 = new BoxShape(1, 2);
        StaticBody smallplatform = new StaticBody(this, platformShape2);
        smallplatform.setPosition(new Vec2(-2, -12));
        smallplatform.addImage(new BodyImage("assets/ilmenskie-cave-platform-hi.png", 4));

        //make obstacles
        new Obstacle_lvl4(this).setPosition(new Vec2(-7, -12f));
        new Obstacle_lvl4(this).setPosition(new Vec2(3, -12f));

        //make lift
        new Lift_lvl4(this).setPosition(new Vec2(14, 0));

        //make coins
        for(int i=0; i<4; i++)
            new Coin(this).setPosition(new Vec2(-6f+i, -5.5f));

        for(int i=0; i<4; i++)
            new Coin(this).setPosition(new Vec2(2.5f+i, -5.5f));

        new Coin(this).setPosition(new Vec2(-1, -9));
        new Coin(this).setPosition(new Vec2(-15, 0));
        new Coin(this).setPosition(new Vec2(0, 3));

        //make energy drink
        new EnergyDrink(this).setPosition(new Vec2(-3, -9));
        new EnergyDrink(this).setPosition(new Vec2(-7.5f, 5));

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