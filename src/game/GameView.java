package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import javax.swing.*;
import java.awt.*;


public class GameView extends UserView {


    private GameLevel level;
    private final Image foreground_l;
    private final Image foreground_r;
    private final Image foreground_over;
    private final Image foreground_lvl3;
    private final Game game;


    public GameView(GameLevel w, int width, int height, Game game) {
        super(w, width, height);
        level = w;
        this.game = game;
        foreground_l = new ImageIcon("assets/foreg_l.jpg").getImage();
        foreground_r = new ImageIcon("assets/foreg_r.png").getImage();
        foreground_over = new ImageIcon("assets/oover.jpg").getImage();
        foreground_lvl3 = new ImageIcon("assets/1078079_cf64b.gif").getImage();
    }


    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(level.getBackground(), 0, 0, getWidth(),getHeight(), this);
    }

    @Override
    public void setWorld(World w){
        super.setWorld(w);
        level = (GameLevel) w;
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);
        g.drawImage(foreground_r, 825, 0, 175, 600, this);
        g.drawImage(foreground_l, 0, 0, 175, 600, this);

        g.setColor(Color.black);
        g.setFont(new Font("Verdana", Font.BOLD, 15));
        g.drawString("Coins: " + level.getPlayer().getCoins(), 870,170);

        if(!game.isGameOver()) {

            if (level instanceof Level1)
                g.drawString("Level: 1", 870, 290);
            else if (level instanceof Level2)
                g.drawString("Level: 2", 870, 290);
            else if (level instanceof Level3) {
                g.drawImage(foreground_lvl3, 175, 0,650, 600, this);
                g.drawString("Level: 3", 870, 290);
            }
            else if (level instanceof Level4)
                g.drawString("Level: 4", 870, 290);
            else if (level instanceof Level5)
                g.drawString("Level: 5", 870, 290);

            g.drawString("Life: " + level.getPlayer().getEnergy(), 870, 380);

            if (level.getPlayer().getEnergy() == 100) {
                g.setFont(new Font("Verdana", Font.BOLD, 9));
                g.drawString("You have full life!", 870, 400);
            }
        }
        else{
            g.drawImage(foreground_over, 0, 0,getWidth() , getHeight(), this);
            g.drawString("GameOver", getWidth()/2-50, getHeight()/2);
        }
    }
}
