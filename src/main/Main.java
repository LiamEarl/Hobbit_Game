package main;

import processing.core.PApplet;
import processing.event.MouseEvent;


public class Main extends PApplet {
    private boolean mouseDown = false;

    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;

    public Main() {

    }

    public void settings() {
        size(1000, 1000, P2D);

    }

    public void setup() {
        SCREEN_WIDTH = width;
        SCREEN_HEIGHT = height;

        textAlign(CENTER, CENTER);
    }

    public void draw() {
        background(abs(sin(frameCount/30)*255), abs(-sin(frameCount/15)*255), abs(sin(frameCount/60)*255));

        textSize(width/10);
        fill(0);
        text("this is a test", width/2, height/2);
    }


    @Override
    public void mouseWheel(MouseEvent event) {}

    @Override
    public void mousePressed() {mouseDown = true; }

    @Override
    public void mouseReleased() {mouseDown = false; }

    @Override
    public void keyPressed() {}

    @Override
    public void keyReleased() {}

    public static void main(String[] args) {
        String[] appletArgs = new String[]{Main.class.getName()};
        PApplet.main(appletArgs);
    }
}