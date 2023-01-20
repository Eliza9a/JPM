package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class EnergyDrink extends StaticBody {

    private static final Shape energyDrinksShape = new BoxShape(0.7f,0.7f);
    private static SoundClip energyDrinkSound;

    //add image to the energy drink
    private static final BodyImage image =
            new BodyImage("assets/drink.png", 1.4f);

    public EnergyDrink(World world) {
        super(world,energyDrinksShape);
        addImage(image);
    }
    //add sound
    static {
        try {
            energyDrinkSound = new SoundClip("assets/powerup.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    // play sound when energy drink is collected
    @Override
    public void destroy()
    {
        energyDrinkSound.play();
        super.destroy();

    }

}


