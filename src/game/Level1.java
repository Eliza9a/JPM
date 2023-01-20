package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level1  extends GameLevel{

    private SoundClip gameMusic;
    Image background;


    public Level1(Game game){

        super(game);

        background = new ImageIcon("assets/BG.png").getImage();

        //add player, portal
        getPlayer().setPosition(new Vec2(-4, -12.5f));
        getPortal().setPosition(new Vec2(15,-9));
        getPlayer().addCollisionListener(new PlayerCollisions(getPlayer(), game));

        //add music
        try {
            gameMusic = new SoundClip("assets/BlueBoyAdventure.wav");   // Open an audio input stream
            gameMusic.loop();
            gameMusic.setVolume(0.5);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        // make the ground
        Shape shape = new BoxShape(16, 3f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(1f, -17.1f));
        ground.addImage(new BodyImage("assets/3.png", 6.3f));


        // make platforms
        Shape platform1Shape = new BoxShape(2.5f, 2.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(1, -13f));
        platform1.addImage(new BodyImage("assets/1.png", 5));

        PolygonShape platform2Shape = new PolygonShape(-1.72f,-1.248f, -0.908f,-1.248f, 1.714f,-0.133f, 1.72f,1.229f, -1.707f,1.243f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(-14.2f, 2.5f));
        platform2.addImage(new BodyImage("assets/16.png", 3));

        PolygonShape platform3Shape = new PolygonShape(1.714f,-1.241f, 0.853f,-1.248f, -1.707f,-0.133f, -1.707f,1.037f, -1.521f,1.229f, 1.707f,1.243f);
        StaticBody platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(14.3f, -12.7f));
        platform3.addImage(new BodyImage("assets/14.png", 3));

        Shape cactus1Shape = new BoxShape(1f, 1f);

        StaticBody cactus2 = new StaticBody(this, cactus1Shape);
        cactus2.setPosition(new Vec2(-15, -13f));
        cactus2.addImage(new BodyImage("assets/Cactus (1).png", 2));

        StaticBody cactus3 = new StaticBody(this, cactus1Shape);
        cactus3.setPosition(new Vec2(-7.5f, -13f));
        cactus3.addImage(new BodyImage("assets/Cactus (1).png", 2));

        StaticBody cactus4 = new StaticBody(this, cactus1Shape);
        cactus4.setPosition(new Vec2(-9, -13f));
        cactus4.addImage(new BodyImage("assets/Cactus (1).png", 2));

        StaticBody bush = new StaticBody(this, cactus1Shape);
        bush.setPosition(new Vec2(-12, -12.5f));
        bush.addImage(new BodyImage("assets/Bush (2).png", 3));

        PolygonShape treeShape = new PolygonShape(-1.62f,-3.94f, 2.6f,-3.96f, 4.95f,2.17f, 3.26f,3.65f, -1.93f,3.98f, -4.76f,2.56f, -4.72f,1.55f);
        StaticBody tree = new StaticBody(this, treeShape);
        tree.setPosition(new Vec2(-12f, -10.5f));
        tree.addImage(new BodyImage("assets/Tree.png", 8));


        //create coins
        for (int i=0; i<3; i++){
            Coin coin = new Coin(this);
            coin.setPosition(new Vec2(7+i,-13));
        }


    }

    //condition to pass the level
    @Override
    public boolean isComplete() {
        if (getPlayer().getCoins() == 3)
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
