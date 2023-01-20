package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class PortalEncounter implements CollisionListener {

    private final GameLevel level;
    private final Game game;

    public PortalEncounter(GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent e) {

        //goToNextLevel
        if (e.getOtherBody() instanceof Portal && level.isComplete()){
            game.goToNextLevel();
            System.out.println("done");
        }
    }
}
