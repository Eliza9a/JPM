package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level2  extends GameLevel{

    private SoundClip gameMusic;
    private final Image background;

    public Level2(Game game){

        super(game);

        background = new ImageIcon("assets/bg_level2.jpg").getImage();

        //add player, portal
        getPlayer().setPosition(new Vec2(-13, -8.5f));
        getPortal().setPosition(new Vec2(-14,11));
        getPlayer().addCollisionListener(new PlayerCollisions(getPlayer(), game));

        //add music
        try {
            gameMusic = new SoundClip("assets/level2.wav");
            gameMusic.loop();
            gameMusic.setVolume(0.5);


        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        // make the ground
        Shape shape1 = new BoxShape(2, 2.5f);
        StaticBody ground1 = new StaticBody(this, shape1);
        ground1.setPosition(new Vec2(-14f, -12.5f));
        ground1.addImage(new BodyImage("assets/Tile_1.png", 5));

        Shape shape2 = new BoxShape(3, 1.5f);
        StaticBody ground2 = new StaticBody(this, shape2);
        ground2.setPosition(new Vec2(-9f, -13.5f));
        ground2.addImage(new BodyImage("assets/Object_15.png",3));

        Shape shape3 = new BoxShape(1.5f, 5f);
        StaticBody ground3 = new StaticBody(this, shape3);
        ground3.setPosition(new Vec2(-4.5f, -10));
        ground3.addImage(new BodyImage("assets/_Spritesheet1.png",10));

        Shape shape4 = new BoxShape(2, 4);
        StaticBody ground4 = new StaticBody(this, shape4);
        ground4.setPosition(new Vec2(-1, -11));
        ground4.addImage(new BodyImage("assets/_Spritesheet.png",8));


        Shape shape5 = new BoxShape(4, 2.5f);
        StaticBody ground5 = new StaticBody(this, shape5);
        ground5.setPosition(new Vec2(5, -12.5f));
        ground5.addImage(new BodyImage("assets/Object_15.png",5));


        Shape shape6 = new BoxShape(3.5f, 5.5f);
        StaticBody ground6 = new StaticBody(this, shape6);
        ground6.setPosition(new Vec2(12.5f, -9.5f));
        ground6.addImage(new BodyImage("assets/_Spritesheet.png",11));


        //platforms

        Shape platformShape = new PolygonShape(-2.217f,-0.891f, -4.01f,0.169f, -4.042f,0.902f, 4.01f,0.919f, 4.01f,0.185f, 2.38f,-0.94f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-13f, 8f));
        platform1.addImage(new BodyImage("assets/_Spritesheet2.png",2));


        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(-3.5f, 6f));
        platform2.addImage(new BodyImage("assets/_Spritesheet2.png",2));

        StaticBody platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(7f, 3f));
        platform3.setAngleDegrees(-10);
        platform3.addImage(new BodyImage("assets/_Spritesheet2.png",2));


        Shape shape = new BoxShape(3.5f, 0.3f);
        StaticBody bridge = new StaticBody(this, shape);
        bridge.setPosition(new Vec2(-9f, -7.8f));
        bridge.setAngleDegrees(38);
        bridge.addImage(new BodyImage("assets/bridge.png",0.9f));

        StaticBody bridge2 = new StaticBody(this, shape);
        bridge2.setPosition(new Vec2(5f, -6f));
        bridge2.setAngleDegrees(20);
        bridge2.addImage(new BodyImage("assets/bridge.png",0.9f));


        Shape box = new BoxShape(1.5f, 1.5f);
        StaticBody box1 = new StaticBody(this, box);
        box1.setPosition(new Vec2(14.5f, -3));
        box1.addImage(new BodyImage("assets/Object_4.png",3));

        Shape decor = new BoxShape(0.5f, 0.5f);
        StaticBody stone = new StaticBody(this, decor);
        stone.setPosition(new Vec2(-11, 9.5f));
        stone.addImage(new BodyImage("assets/Object_3.png",1));


        //make coins
        new Coin(this).setPosition(new Vec2(3, -1));
        new Coin(this).setPosition(new Vec2(4, -0.5f));
        new Coin(this).setPosition(new Vec2(3.5f, -2));
        new Coin(this).setPosition(new Vec2(4.5f, -1.5f));
        new Coin(this).setPosition(new Vec2(4, -3));
        new Coin(this).setPosition(new Vec2(5, -2.5f));
        new Coin(this).setPosition(new Vec2(2.5f, -2.5f));
        new Coin(this).setPosition(new Vec2(5.5f, -1f));
        for(int i =0; i<3;i++) new Coin(this).setPosition(new Vec2(-10.5f+i, -8.5f+i));
        new Coin(this).setPosition(new Vec2(0, 8));
        new Coin(this).setPosition(new Vec2(2, 9));
        new Coin(this).setPosition(new Vec2(3.5f, 8));
        new Coin(this).setPosition(new Vec2(4, 6));


    }


    //condition to pass the level
    @Override
    public boolean isComplete() {
        if (getPlayer().getCoins() == 15)
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
