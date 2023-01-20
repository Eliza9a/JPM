package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class PlayerCollisions implements CollisionListener {

    private final Player player;
    private final Game game;

    public PlayerCollisions(Player p, Game game) {
        this.player = p;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Coin) {
            player.setCoins(player.getCoins() + 1);
            e.getOtherBody().destroy();
        }
        //player can pick energy drink if the energy is below 100
        if (player.getEnergy() < 100) {
            if (e.getOtherBody() instanceof EnergyDrink || e.getOtherBody() instanceof EnergyDrink_lvl5) {
                if (player.getEnergy() < 90)
                    player.setEnergy(player.getEnergy() + 20);
                else if (player.getEnergy() == 90)
                    player.setEnergy(player.getEnergy() + 10);
                e.getOtherBody().destroy();
                System.out.println("Energy:" + player.getEnergy());
            }

        }
        if (e.getOtherBody() instanceof Lava) {
            player.destroy();
            player.setEnergy(0);
            game.setGameOver(true);

        }
        if (e.getOtherBody() instanceof SmallObstacle) {
            player.setEnergy(player.getEnergy() - 30);

        }
        if (e.getOtherBody() instanceof MediumObstacle) {
            player.setEnergy(player.getEnergy() - 30);

        }
        if (e.getOtherBody() instanceof BigObstacle) {
            player.setEnergy(player.getEnergy() - 30);

        }
        if (e.getOtherBody() instanceof Enemy) {
            player.setEnergy(player.getEnergy() - 20);

        }
        if (e.getOtherBody() instanceof Obstacle_lvl4) {
            player.setEnergy(player.getEnergy() - 40);

        }
        if (e.getOtherBody() instanceof Obstacle) {
            player.setEnergy(player.getEnergy() - 40);
        }

        if (player.getEnergy() <= 0) {
            game.setGameOver(true);
        }

    }


}