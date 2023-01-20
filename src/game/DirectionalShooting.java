package game;


import org.jbox2d.common.Vec2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Shooting using the mouse
 */
public class DirectionalShooting implements MouseListener {

    private final GameView view;
    private final Game game;


    public DirectionalShooting(Game game, GameView v){
        super();
        this.game = game;
        view = v;
    }

    //3 coins needed to shoot

    /**
     * When the mouse is clicked, 3 coins are taken and a flame is going in the direction of the mouse
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Vec2 worldPoint = view.viewToWorld(e.getPoint());
            if (game.getPlayer().getCoins() >= 3) {
                game.getPlayer().shoot(worldPoint);
                game.getPlayer().setCoins(game.getPlayer().getCoins() - 3);
            }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

