package game;


import city.cs.engine.*;


public class Lava extends StaticBody{

    private static final Shape lavaShape = new BoxShape(6.75f, 1.5f);

    //add image to lava
    private static final BodyImage image =
            new BodyImage("assets/giphy.gif", 3);

    public Lava(World w) {
        super(w,lavaShape);
        addImage(image);
    }
}
