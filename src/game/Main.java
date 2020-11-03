package game;

import processing.core.PApplet;
import processing.event.MouseEvent;
import rendering.Renderer;


public class Main extends PApplet {
    private boolean mouseDown = false;

    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;

    public Renderer renderer = new Renderer(this); // Renderer instance to display the game

    public Game game = new Game(renderer); // Game instance

    public boolean keys[];

    public Main() {

    }

    public void settings() {
        fullScreen();

    }

    public void setup() {
        SCREEN_WIDTH = width;
        SCREEN_HEIGHT = height;

        textAlign(CENTER, CENTER);
        noStroke();

        keys = new boolean[222];
    }

    public void draw() {

        background(255);
        renderer.renderScene(game);
    }

    @Override
    public void mouseWheel(MouseEvent event) {}

    @Override
    public void mousePressed()  {mouseDown = true; }

    @Override
    public void mouseReleased() {mouseDown = false; }

    @Override
    public void keyPressed() {keys[keyCode] = true; }

    @Override
    public void keyReleased() {keys[keyCode] = false; }

    public static void main(String[] args) {
        String[] appletArgs = new String[]{Main.class.getName()};
        PApplet.main(appletArgs);
    }
}