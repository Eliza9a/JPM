package game;

import city.cs.engine.*;

public class Portal extends StaticBody {


    private static final PolygonShape portalShape = new PolygonShape(-1.17f, 0.36f, -0.69f, 2.21f, 0.16f, 2.54f, 0.67f, 1.99f, 1.11f, -0.2f, 0.17f, -2.47f, -0.29f, -2.5f);

    private static final BodyImage image =
            new BodyImage("assets/portal.png", 5f);

    public Portal(World w) {
        super(w,portalShape);
        addImage(image);
    }

}
