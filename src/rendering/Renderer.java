package rendering;

import creatures.*;
import processing.core.PApplet;

public class Renderer {

    private final processing.core.PApplet PApplet;

    public Renderer(PApplet pApplet) {
        this.PApplet = pApplet;
    }

    public void renderDwarf(Dwarf toRender) {
        this.PApplet.fill(100, 100, 100);
        this.PApplet.rect(toRender.getPosition().getX(), toRender.getPosition().getX(), 25, 25);
    }
    public void renderHobbit(Hobbit toRender) {

    }
    public void renderGoblin(Goblin toRender) {

    }
    public void renderSpider(Spider toRender) {

    }
    public void renderHuman(Human toRender) {

    }

    public void renderScene() {

    }


}
