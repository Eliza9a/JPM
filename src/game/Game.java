package game;


import javax.swing.*;
import java.awt.*;

/**
 * @author      Eliza Airinei
 * Create the game
 * */

public class Game {


    private GameLevel level;
    private final GameView view;
    private boolean gameOver;
    private final PlayerController controller;
    private boolean menuVisible;
    private final ControlPanel controlPanel;
    private final JFrame frame;
    private final SettingsPanel settingPanel;
    private final LevelsPanel levelsPanel;
    private final helpPanel helpPanel;


    /** Initialise a new Game. */
    public Game() {

        // initialize level to Level1
        level = new Level1(this);
        gameOver = false;
        menuVisible=false;


        //check if the game is over, if yes, stop the game
        if(this.isGameOver()) {
            level.stop();
        }

        // make a view
        view = new GameView(level, 1000, 600, this);
        view.setZoom(20);


        controller = new PlayerController(level.getPlayer(), this);
        view.addKeyListener(controller);
        view.addMouseListener(new DirectionalShooting(this, view));
        view.addMouseListener(new GiveFocus(view));


        //create the window
        frame = new JFrame("Adventure Land");
        frame.add(view);

        //menu
        controlPanel = new ControlPanel(this);
        settingPanel = new SettingsPanel(level, this);
        levelsPanel = new LevelsPanel(this);
        helpPanel = new helpPanel(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();

        frame.setVisible(true);

        //start the game
        level.start();
    }

    /**
     * For the transition between levels
     * <p>
     *     When one level ends, the music, background and player updates for the next level
     * </p>
     */
    public void goToNextLevel(){

        if (level instanceof Level1){
            level.stop();
            level.getGameMusic().close();
            level = new Level2(this);
            view.setWorld(level);
            controller.updatePlayer(level.getPlayer());
            level.start();
        }
        else if (level instanceof Level2){
            level.stop();
            level.getGameMusic().close();
            level = new Level3(this);
            view.setWorld(level);
            controller.updatePlayer(level.getPlayer());
            level.start();
        }
        else if (level instanceof Level3){
            level.stop();
            level.getGameMusic().close();
            level = new Level4(this);
            view.setWorld(level);
            controller.updatePlayer(level.getPlayer());
            level.start();
        }
        else if (level instanceof Level4){
            level.stop();
            level.getGameMusic().close();
            level = new Level5(this);
            view.setWorld(level);
            controller.updatePlayer(level.getPlayer());
            level.start();
        }
        else if (level instanceof Level5){
            System.exit(0);
        }
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }

    public boolean isGameOver(){
        return gameOver;
    }

    /**
     * If the game is over, everything stops and the foreground is changed
     * @param over is boolean and it is used to check if the game is over
     */
    //set what happens when the game is over
    public void setGameOver(boolean over){
        gameOver = over;
        level.stop();
        level.getGameMusic().stop();
        view.repaint();
    }

    public Player getPlayer(){
        return level.getPlayer();
    }

    /**
     * Shows or hides the menu
     */
    public void toggleMenu(){
        if(menuVisible){
            //hide
            frame.remove(controlPanel.mainPanel);
            menuVisible = false;
            frame.pack();
        }
        else{
            //show
            frame.add(controlPanel.mainPanel, BorderLayout.WEST);
            menuVisible = true;
            frame.pack();
        }
    }

    //the buttons of the menu

    /**
     * Make the transition from the main menu to the levels menu
     */
    public void transitionToLevels() {
        frame.remove(controlPanel.mainPanel);
        frame.add(levelsPanel.mainPanel, BorderLayout.WEST);
        frame.pack();
    }

    /**
     * Make the transition from the level menu to the main menu
     */
    public void transitionToMain1(){
        frame.remove(levelsPanel.mainPanel);
        frame.add(controlPanel.mainPanel, BorderLayout.WEST);
        frame.pack();
    }

    /**
     * Make the transition from the main menu to the settings menu
     */
    public void transitionToSettings(){
        frame.remove(controlPanel.mainPanel);
        frame.add(settingPanel.mainPanel, BorderLayout.WEST);
        frame.pack();
    }

    /**
     * Make the transition from the settings menu to the main menu
     */
    public void transitionToMain(){
        frame.remove(settingPanel.mainPanel);
        frame.add(controlPanel.mainPanel, BorderLayout.WEST);
        frame.pack();
    }

    /**
     * Make the transition from the main menu to the help menu
     */
    public void transitionToHelp(){
        frame.remove(controlPanel.mainPanel);
        frame.add(helpPanel.mainPanel, BorderLayout.WEST);
        frame.pack();
    }

    /**
     * Make the transition from the help menu to the main menu
     */
    public void transitionToMain2() {
        frame.remove(helpPanel.mainPanel);
        frame.add(controlPanel.mainPanel, BorderLayout.WEST);
        frame.pack();
    }

    /**
     * Button to pause the game
     */
    public void pauseGame(){
        level.stop();
        level.getGameMusic().pause();
    }

    /**
     * Button to resume the game
     */
    public void resumeGame(){
        level.start();
        level.getGameMusic().resume();
    }

    /**
     * Button to replay the game
     * <p>
     *     It goes back to the first level and resets everything
     * </p>
     */
    public void replayGame() {
        level.stop();
        level.getGameMusic().close();
        setGameOver(false);
        level = new Level1(this);
        view.setWorld(level);
        controller.updatePlayer(level.getPlayer());
        level.start();
        level.getGameMusic().play();
    }

    /**
     * Jump to level 2
     */
    public void goToLevel2() {
        level.stop();
        level.getGameMusic().close();
        level = new Level2(this);
        view.setWorld(level);
        controller.updatePlayer(level.getPlayer());
        level.start();
        level.getGameMusic().play();
    }

    /**
     * Jump to level 3
     */
    public void goToLevel3() {
        level.stop();
        level.getGameMusic().close();
        level = new Level3(this);
        view.setWorld(level);
        controller.updatePlayer(level.getPlayer());
        level.start();
        level.getGameMusic().play();
    }

    /**
     * Jump to level 4
     */
    public void goToLevel4() {
        level.stop();
        level.getGameMusic().close();
        level = new Level4(this);
        view.setWorld(level);
        controller.updatePlayer(level.getPlayer());
        level.start();
        level.getGameMusic().play();
    }

    /**
     * Jump to level 5
     */
    public void goToLevel5() {
        level.stop();
        level.getGameMusic().close();
        level = new Level5(this);
        view.setWorld(level);
        controller.updatePlayer(level.getPlayer());
        level.start();
        level.getGameMusic().play();
    }

    /**
     * Sets the music volume
     * <p>
     *     The music volume can be set to none, medium or high
     * </p>
     */
    //change the volume of the background music
    public void maxVolume(){
        level.getGameMusic().setVolume(2);
    }
    public void medVolume(){
         level.getGameMusic().setVolume(1);
    }
    public void noVolume(){
         level.getGameMusic().setVolume(0.0001);
    }

}
