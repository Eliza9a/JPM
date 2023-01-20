package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Level3 extends GameLevel {

    private SoundClip gameMusic;
    private final Image background;

    public Level3(Game game) {

        super(game);

        background = new ImageIcon("assets/R.jpg").getImage();

        //add player, portal
        getPlayer().setPosition(new Vec2(0, -13));
        getPortal().setPosition(new Vec2(14.6f,8));
        getPlayer().addCollisionListener(new PlayerCollisions(getPlayer(), game));

        //add music
        try {
            gameMusic = new SoundClip("assets/level3.wav");   // Open an audio input stream
            gameMusic.loop();
            gameMusic.setVolume(0.5);


        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        //make the ground
        Shape shape = new BoxShape(15.77f, 0.5f);

        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(4.2f, -14.5f));
        ground.addImage(new BodyImage("assets/ground.png"));

        StaticBody ground1 = new StaticBody(this, shape);
        ground1.setPosition(new Vec2(-4.2f, -14.5f));
        ground1.addImage(new BodyImage("assets/ground.png"));


        // make platforms
        PolygonShape LeftPlatformShape1 = new PolygonShape(-0.803f, 0.79f, -0.8f, -0.79f, -0.461f, -0.796f, 0.032f, -0.719f, 0.793f, 0.039f, 0.787f, 0.784f);
        StaticBody PlatformLeft1 = new StaticBody(this, LeftPlatformShape1);
        PlatformLeft1.setPosition(new Vec2(10f, -9.5f));
        PlatformLeft1.addImage(new BodyImage("assets/ice5.png", 1.6f));

        StaticBody PlatformLeft2 = new StaticBody(this, LeftPlatformShape1);
        PlatformLeft2.setPosition(new Vec2(0.2f, -6.9f));
        PlatformLeft2.addImage(new BodyImage("assets/ice5.png", 1.6f));

        StaticBody PlatformLeft3 = new StaticBody(this, LeftPlatformShape1);
        PlatformLeft3.setPosition(new Vec2(-2f, 8.4f));
        PlatformLeft3.addImage(new BodyImage("assets/ice5.png", 1.6f));

        PolygonShape RightPlatformShape1 = new PolygonShape(-1.235f, 1.235f, -1.18f, -0.005f, 0.74f, -1.23f, 1.23f, -1.225f, 1.24f, 1.225f);
        StaticBody platformRight1 = new StaticBody(this, RightPlatformShape1);
        platformRight1.setPosition(new Vec2(14.55f, -12.8f));
        platformRight1.addImage(new BodyImage("assets/ice4.png", 2.5f));

        PolygonShape RightPlatformShape2 = new PolygonShape(-0.787f, 0.79f, -0.742f, -0.016f, 0.486f, -0.794f, 0.794f, -0.794f, 0.8f, 0.787f);
        StaticBody platformRight2 = new StaticBody(this, RightPlatformShape2);
        platformRight2.setPosition(new Vec2(4.55f, -9.5f));
        platformRight2.addImage(new BodyImage("assets/ice4.png", 1.6f));

        StaticBody platformRight3 = new StaticBody(this, RightPlatformShape2);
        platformRight3.setPosition(new Vec2(-10.5f, 10f));
        platformRight3.addImage(new BodyImage("assets/ice4.png", 1.6f));

        PolygonShape RightPlatformShape4 = new PolygonShape(-2.48f, 2.45f, -2.33f, 0.0f, 1.54f, -2.46f, 2.47f, -2.47f, 2.47f, 2.44f);
        StaticBody platformRight4 = new StaticBody(this, RightPlatformShape4);
        platformRight4.setPosition(new Vec2(13.3f, 3f));
        platformRight4.addImage(new BodyImage("assets/ice4.png", 5f));

        BoxShape smallPlatformShape = new BoxShape(0.9f, 0.9f);
        StaticBody smallPlatform1 = new StaticBody(this, smallPlatformShape);
        smallPlatform1.setPosition(new Vec2(5, -2.2f));
        smallPlatform1.addImage(new BodyImage("assets/ice3.png", 1.8f));

        StaticBody smallPlatform2 = new StaticBody(this, smallPlatformShape);
        smallPlatform2.setPosition(new Vec2(0.5f, 0));
        smallPlatform2.addImage(new BodyImage("assets/ice3.png", 1.8f));

        StaticBody smallPlatform3 = new StaticBody(this, smallPlatformShape);
        smallPlatform3.setPosition(new Vec2(2f, 8f));
        smallPlatform3.addImage(new BodyImage("assets/ice3.png", 1.8f));

        StaticBody smallPlatform4 = new StaticBody(this, smallPlatformShape);
        smallPlatform4.setPosition(new Vec2(7f, 6f));
        smallPlatform4.addImage(new BodyImage("assets/ice3.png", 1.8f));

        BoxShape bigPlatformShape1 = new BoxShape(2.25f, 2.25f);
        StaticBody bigPlatform1 = new StaticBody(this, bigPlatformShape1);
        bigPlatform1.setPosition(new Vec2(-13.6f, -12f));
        bigPlatform1.addImage(new BodyImage("assets/ice2.png", 4.5f));

        BoxShape bigPlatformShape2 = new BoxShape(2f, 2f);
        StaticBody bigPlatform2 = new StaticBody(this, bigPlatformShape2);
        bigPlatform2.setPosition(new Vec2(7.3f, -8.3f));
        bigPlatform2.addImage(new BodyImage("assets/ice2.png", 4f));

        BoxShape bigPlatformShape3 = new BoxShape(2.4f, 2.4f);
        StaticBody bigPlatform3 = new StaticBody(this, bigPlatformShape3);
        bigPlatform3.setPosition(new Vec2(-13.4f, 3.5f));
        bigPlatform3.addImage(new BodyImage("assets/ice2.png", 4.8f));

        PolygonShape longPlatformShape1 = new PolygonShape(-2.894f, 1.215f, -2.906f, -1.199f, 2.894f, -1.199f, 2.906f, 1.238f);
        StaticBody longPlatform1 = new StaticBody(this, longPlatformShape1);
        longPlatform1.setPosition(new Vec2(-8.6f, -12.8f));
        longPlatform1.addImage(new BodyImage("assets/ice7.png", 2.5f));

        PolygonShape longIcePlatformShape1 = new PolygonShape(4.528f, -1.114f, -4.546f, -1.096f, -4.546f, 1.15f, 4.509f, 1.132f);
        StaticBody longIcePlatform1 = new StaticBody(this, longIcePlatformShape1);
        longIcePlatform1.setPosition(new Vec2(-5.1f, -6.5f));
        SolidFixture fixture1 = new SolidFixture(longIcePlatform1, longIcePlatformShape1);
        fixture1.setFriction(0.1f);
        longIcePlatform1.addImage(new BodyImage("assets/ice6.png", 2.3f));

        StaticBody longIcePlatform2 = new StaticBody(this, longIcePlatformShape1);
        longIcePlatform2.setPosition(new Vec2(-6.6f, 2.2f));
        fixture1.setFriction(0.1f);
        longIcePlatform2.addImage(new BodyImage("assets/ice6.png", 2.3f));

        PolygonShape longIcePlatformShape2 = new PolygonShape(-3.755f, 0.935f, -3.755f, -0.905f, 3.785f, -0.905f, 3.8f, 0.92f);
        StaticBody longIcePlatform3 = new StaticBody(this, longIcePlatformShape2);
        longIcePlatform3.setPosition(new Vec2(-6.2f, 9.5f));
        SolidFixture fixture2 = new SolidFixture(longIcePlatform1, longIcePlatformShape1);
        fixture2.setFriction(0.1f);
        longIcePlatform3.addImage(new BodyImage("assets/ice6.png", 1.9f));
        longIcePlatform3.setAngleDegrees(-10);

        //make the walls
        Shape wallShape = new BoxShape(0.2f, 20);

        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-16, -4));

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(16, -4));


        //make obstacles
        new Obstacle(this).setPosition(new Vec2(-3.5f, -3.3f));
        new Obstacle(this).setPosition(new Vec2(-6, 5.4f));
        new Obstacle(this).setPosition(new Vec2(7, 8.9f));

        //make coins
        new Coin(this).setPosition(new Vec2(-14.5f, -8.5f));
        new Coin(this).setPosition(new Vec2(14.5f, -10.5f));
        new Coin(this).setPosition(new Vec2(7.5f, -5.5f));
        new Coin(this).setPosition(new Vec2(-8, -4));
        new Coin(this).setPosition(new Vec2(-14.5f, 7));
        new Coin(this).setPosition(new Vec2(4.5f, -8));
        new Coin(this).setPosition(new Vec2(2, 10));
        new Coin(this).setPosition(new Vec2(0.5f, 2));
        new Coin(this).setPosition(new Vec2(-12, 7));

        //make energy drink
        new EnergyDrink(this).setPosition(new Vec2(5, -0.6f));

    }

    //condition to pass the level
    @Override
    public boolean isComplete() {
        if (getPlayer().getCoins() == 0)
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
