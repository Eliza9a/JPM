package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class FlameCollision  implements CollisionListener {



    //check when the flame hits any obstacle and destroy the obstacle and the flame
    @Override
    public void collide(CollisionEvent e1) {

            if (e1.getOtherBody() instanceof Obstacle) {
                e1.getOtherBody().destroy();
                e1.getReportingBody().destroy();
            }
            if (e1.getOtherBody() instanceof BigObstacle) {
                e1.getOtherBody().destroy();
                e1.getReportingBody().destroy();
            }
            if (e1.getOtherBody() instanceof MediumObstacle) {
                e1.getOtherBody().destroy();
                e1.getReportingBody().destroy();
            }
            if (e1.getOtherBody() instanceof SmallObstacle) {
                e1.getOtherBody().destroy();
                e1.getReportingBody().destroy();
            }

    }
}