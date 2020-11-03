package rendering;

import blocks.Block;
import creatures.*;
import game.Game;
import game.Scenario;
import math.VectorF2D;
import processing.core.PApplet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Renderer {



    private final processing.core.PApplet PApplet;

    public static int GRID_SIZE;

    public Renderer(PApplet pApplet) {
        this.PApplet = pApplet;
        GRID_SIZE = (int) ((PApplet.width + PApplet.height) / 3f);
    }

    public void renderScene(Game game) {

        ArrayList<Block> blockOrderFlag = new ArrayList<Block>();

        Scenario currentScenario = game.getCurrentScenario(); // Getting the current scenario for its level data

        Block[][] scenarioData = currentScenario.getLevelData();


        // Render blocks

        for(int i = 0; i < scenarioData.length; i++) {
            for(int j = 0; j < scenarioData[i].length; j++) {
                Block currentBlock = scenarioData[i][j];

                if(currentBlock.getType() == "tree")
                    blockOrderFlag.add(new Block(new VectorF2D(currentBlock.getPosition().getX(), currentBlock.getPosition().getY()), "leaves"));

                renderBlock(currentBlock);
            }
        }

        ArrayList<Dwarf>  dwarves = game.getDwarves(); // Getting the lists of each type of entity
        ArrayList<Hobbit> hobbits = game.getHobbits();
        ArrayList<Goblin> goblins = game.getGoblins();
        ArrayList<Spider> spiders = game.getSpiders();
        ArrayList<Human>  humans  = game.getHumans ();

        // ===================== Rendering each instance of each entity if they are on the screen =====================

        for(int i = 0; i < dwarves.size(); i++) {
            if(inScreen(dwarves.get(i))) renderDwarf(dwarves.get(i));
        }

        for(int i = 0; i < hobbits.size(); i++) {
            if(inScreen(hobbits.get(i))) renderHobbit(hobbits.get(i));
        }

        for(int i = 0; i < goblins.size(); i++) {
            if(inScreen(goblins.get(i))) renderGoblin(goblins.get(i));
        }

        for(int i = 0; i < spiders.size(); i++) {
            if(inScreen(spiders.get(i))) renderSpider(spiders.get(i));
        }

        for(int i = 0; i < humans.size(); i++) {
            if(inScreen(humans.get(i))) renderHuman(humans.get(i));
        }

        // Render all objects in the order flag

        for(int i = 0; i < blockOrderFlag.size(); i ++) {
            renderBlock(blockOrderFlag.get(i));
        }

    }

    public void renderBlock(Block toRender) {
        float x = toRender.getPosition().getX() * GRID_SIZE; // Get X and Y of the block
        float y = toRender.getPosition().getY() * GRID_SIZE;

        switch(toRender.getType()) {

            case "grass":

                this.PApplet.fill(56, 102, 0);
                this.PApplet.rect(x, y, GRID_SIZE, GRID_SIZE);

                for(int leaf = 0; leaf < 4; leaf ++) {

                    long seed = (long)((x + y % 7) * x + (y * 2) + (leaf * 45));

                    float leafX = x + getRandomNumber(GRID_SIZE/15, GRID_SIZE - (GRID_SIZE / 15), seed);
                    float leafY = y + getRandomNumber(GRID_SIZE/15, GRID_SIZE - (GRID_SIZE / 15), seed / 4);

                    this.PApplet.fill(36, 72, 0);
                    this.PApplet.ellipse(leafX, leafY, GRID_SIZE / 15f, GRID_SIZE / 15f);
                }
                break;

            case "tree":

                this.PApplet.fill(56, 102, 0);
                this.PApplet.rect(x, y, GRID_SIZE, GRID_SIZE);

                this.PApplet.fill(83, 49, 24);
                this.PApplet.rect(x, y, GRID_SIZE, GRID_SIZE, GRID_SIZE / 4f);

                break;

            case "leaves":
                this.PApplet.rectMode(this.PApplet.CENTER);
                this.PApplet.fill(82, 111, 0, 100f);
                this.PApplet.ellipse(x + GRID_SIZE / 2f, y + GRID_SIZE / 2f, GRID_SIZE * 5f, GRID_SIZE * 5f);
                this.PApplet.rect(x + GRID_SIZE / 2f, y + GRID_SIZE / 2f, GRID_SIZE * 4.5f, GRID_SIZE * 4.5f, GRID_SIZE);
                this.PApplet.rectMode(this.PApplet.CORNER);
                break;
        }


    }

    public void renderDwarf(Dwarf toRender) {
        float x = toRender.getPosition().getX();
        float y = toRender.getPosition().getY();

        this.PApplet.pushMatrix();
        this.PApplet.translate(x, y);
        this.PApplet.rotate(toRender.getDirection());
        this.PApplet.rectMode(this.PApplet.CENTER);
        this.PApplet.fill(81, 47, 13);
        this.PApplet.rect((GRID_SIZE / 2f), (GRID_SIZE / 2f), GRID_SIZE * 0.9f, GRID_SIZE * 0.4f, GRID_SIZE / 15f);

        this.PApplet.fill(101, 67, 33);
        this.PApplet.rect((GRID_SIZE / 2f), (GRID_SIZE / 2f), GRID_SIZE * 0.65f, GRID_SIZE * 0.55f, GRID_SIZE / 5f);

        this.PApplet.fill(200, 200, 200);
        this.PApplet.rect(GRID_SIZE / 2f, GRID_SIZE / 2f, GRID_SIZE * 0.35f, GRID_SIZE * 0.45f, GRID_SIZE / 7f);

        this.PApplet.fill(203, 132, 66);
        this.PApplet.rect((GRID_SIZE / 2f), (GRID_SIZE * 0.45f), GRID_SIZE * 0.32f, GRID_SIZE * 0.32f, GRID_SIZE / 7f);

        this.PApplet.rectMode(this.PApplet.CORNER);
        this.PApplet.popMatrix();
    }

    public void renderHobbit(Hobbit toRender) {
        float x = toRender.getPosition().getX();
        float y = toRender.getPosition().getY();

        this.PApplet.pushMatrix();
        this.PApplet.translate(x, y);
        this.PApplet.rotate(toRender.getDirection());
        this.PApplet.rectMode(this.PApplet.CENTER);

        this.PApplet.fill(161, 61, 45);
        this.PApplet.rect((GRID_SIZE / 2f), (GRID_SIZE / 2f), GRID_SIZE * 0.75f, GRID_SIZE * 0.35f, GRID_SIZE / 10f);

        this.PApplet.fill(171, 71, 55);
        this.PApplet.rect((GRID_SIZE / 2f), (GRID_SIZE * 0.5f), GRID_SIZE * 0.45f, GRID_SIZE * 0.42f, GRID_SIZE / 10f);

        this.PApplet.fill(203, 132, 66);
        this.PApplet.rect((GRID_SIZE / 2f), (GRID_SIZE * 0.525f), GRID_SIZE * 0.05f, GRID_SIZE * 0.35f, GRID_SIZE / 20f);

        this.PApplet.fill(101, 67, 33);
        this.PApplet.rect((GRID_SIZE / 2f), (GRID_SIZE / 2f), GRID_SIZE * 0.3f, GRID_SIZE * 0.3f, GRID_SIZE / 20f);

        this.PApplet.rectMode(this.PApplet.CORNER);
        this.PApplet.popMatrix();
    }
    public void renderGoblin(Goblin toRender) {
        float x = toRender.getPosition().getX();
        float y = toRender.getPosition().getY();

        this.PApplet.pushMatrix();
        this.PApplet.translate(x, y);
        this.PApplet.rotate(toRender.getDirection());

        this.PApplet.rectMode(this.PApplet.CENTER);

        this.PApplet.fill(80, 90, 95);
        this.PApplet.rect((GRID_SIZE / 2f), (GRID_SIZE / 2f), GRID_SIZE * 0.75f, GRID_SIZE * 0.35f, GRID_SIZE / 10f);

        this.PApplet.fill(90, 100, 105);
        this.PApplet.rect((GRID_SIZE / 2f), (GRID_SIZE * 0.5f), GRID_SIZE * 0.45f, GRID_SIZE * 0.42f, GRID_SIZE / 10f);

        this.PApplet.fill(35, 116, 45);
        this.PApplet.rect((GRID_SIZE / 2f), (GRID_SIZE * 0.45f), GRID_SIZE * 0.5f, GRID_SIZE * 0.15f, GRID_SIZE / 20f);
        this.PApplet.fill(25, 106, 35);
        this.PApplet.rect((GRID_SIZE / 2f), (GRID_SIZE * 0.525f), GRID_SIZE * 0.05f, GRID_SIZE * 0.35f, GRID_SIZE / 20f);
        this.PApplet.rect(GRID_SIZE / 2f, (GRID_SIZE / 2f), GRID_SIZE * 0.3f, GRID_SIZE * 0.3f, GRID_SIZE / 20f);

        this.PApplet.rectMode(this.PApplet.CORNER);
        this.PApplet.popMatrix();
    }

    public void renderSpider(Spider toRender) {
        float x = toRender.getPosition().getX();
        float y = toRender.getPosition().getY();

        this.PApplet.pushMatrix();
        this.PApplet.translate(x, y);
        this.PApplet.rotate(toRender.getDirection());

        this.PApplet.stroke(35, 35, 45);
        this.PApplet.strokeWeight(GRID_SIZE / 20f);

        if(toRender.isMoving()) {
            float changeValue1 = processing.core.PApplet.sin(this.PApplet.frameCount / 4f) * (GRID_SIZE / 8f);
            float changeValue2 = processing.core.PApplet.sin((this.PApplet.frameCount + 5) / 4f) * (GRID_SIZE / 8f);
            float changeValue3 = processing.core.PApplet.sin((this.PApplet.frameCount + 10) / 4f) * (GRID_SIZE / 8f);


            this.PApplet.line(GRID_SIZE / 8f, GRID_SIZE / 3f - changeValue2, 0, GRID_SIZE / 10f - changeValue2);
            this.PApplet.line(GRID_SIZE / 8f, GRID_SIZE / 3f - changeValue2, GRID_SIZE / 2.5f, GRID_SIZE / 2f);

            this.PApplet.line(GRID_SIZE - (GRID_SIZE / 8f), GRID_SIZE / 3f + changeValue2, GRID_SIZE, GRID_SIZE / 10f + changeValue2);
            this.PApplet.line(GRID_SIZE - (GRID_SIZE / 8f), GRID_SIZE / 3f + changeValue2, GRID_SIZE - (GRID_SIZE / 2.5f), GRID_SIZE / 2f);

            this.PApplet.line(GRID_SIZE / 5f, GRID_SIZE / 4f - changeValue3, GRID_SIZE / 4f, -changeValue3);
            this.PApplet.line(GRID_SIZE / 5f, GRID_SIZE / 4f - changeValue3, GRID_SIZE / 2.5f, GRID_SIZE / 2f);

            this.PApplet.line(GRID_SIZE - (GRID_SIZE / 5f), GRID_SIZE / 4f + changeValue2, GRID_SIZE - (GRID_SIZE / 4f), changeValue2);
            this.PApplet.line(GRID_SIZE - (GRID_SIZE / 5f), GRID_SIZE / 4f + changeValue2, GRID_SIZE - (GRID_SIZE / 2.5f), GRID_SIZE / 2f);


            this.PApplet.line(GRID_SIZE / 8f, GRID_SIZE - (GRID_SIZE / 3f) + changeValue1, 0, GRID_SIZE - (GRID_SIZE / 10f) + changeValue1);
            this.PApplet.line(GRID_SIZE / 8f, GRID_SIZE - (GRID_SIZE / 3f) + changeValue1, GRID_SIZE / 2.5f, GRID_SIZE - (GRID_SIZE / 2f));

            this.PApplet.line(GRID_SIZE - (GRID_SIZE / 8f), GRID_SIZE - (GRID_SIZE / 3f) - changeValue1, GRID_SIZE, GRID_SIZE - (GRID_SIZE / 10f) - changeValue1);
            this.PApplet.line(GRID_SIZE - (GRID_SIZE / 8f), GRID_SIZE - (GRID_SIZE / 3f) - changeValue1, GRID_SIZE - (GRID_SIZE / 2.5f), GRID_SIZE - (GRID_SIZE / 2f));

            this.PApplet.line(GRID_SIZE / 5f, GRID_SIZE - (GRID_SIZE / 4f) + (changeValue1 / 2f), GRID_SIZE / 4f, GRID_SIZE + (changeValue1 / 2f));
            this.PApplet.line(GRID_SIZE / 5f, GRID_SIZE - (GRID_SIZE / 4f) + (changeValue1 / 2f), GRID_SIZE / 2.5f, GRID_SIZE - (GRID_SIZE / 2f));

            this.PApplet.line(GRID_SIZE - (GRID_SIZE / 5f), GRID_SIZE - (GRID_SIZE / 4f) - (changeValue1 / 2f), GRID_SIZE - (GRID_SIZE / 4f), GRID_SIZE - (changeValue1 / 2f));
            this.PApplet.line(GRID_SIZE - (GRID_SIZE / 5f), GRID_SIZE - (GRID_SIZE / 4f) - (changeValue1 / 2f), GRID_SIZE - (GRID_SIZE / 2.5f), GRID_SIZE - (GRID_SIZE / 2f));

        } else {
            this.PApplet.line(GRID_SIZE / 8f, GRID_SIZE / 3f, 0, GRID_SIZE / 10f);
            this.PApplet.line(GRID_SIZE / 8f, GRID_SIZE / 3f, GRID_SIZE / 2.5f, GRID_SIZE / 2f);
            this.PApplet.line(GRID_SIZE - (GRID_SIZE / 8f), GRID_SIZE / 3f, GRID_SIZE, GRID_SIZE / 10f);
            this.PApplet.line(GRID_SIZE - (GRID_SIZE / 8f), GRID_SIZE / 3f, GRID_SIZE - (GRID_SIZE / 2.5f), GRID_SIZE / 2f);

            this.PApplet.line(GRID_SIZE / 5f, GRID_SIZE / 4f, GRID_SIZE / 4f, 0);
            this.PApplet.line(GRID_SIZE / 5f, GRID_SIZE / 4f, GRID_SIZE / 2.5f, GRID_SIZE / 2f);
            this.PApplet.line(GRID_SIZE - (GRID_SIZE / 5f), GRID_SIZE / 4f, GRID_SIZE - (GRID_SIZE / 4f), 0);
            this.PApplet.line(GRID_SIZE - (GRID_SIZE / 5f), GRID_SIZE / 4f, GRID_SIZE - (GRID_SIZE / 2.5f), GRID_SIZE / 2f);


            this.PApplet.line(GRID_SIZE / 8f, GRID_SIZE - (GRID_SIZE / 3f), 0, GRID_SIZE - (GRID_SIZE / 10f));
            this.PApplet.line(GRID_SIZE / 8f, GRID_SIZE - (GRID_SIZE / 3f), GRID_SIZE / 2.5f, GRID_SIZE - (GRID_SIZE / 2f));
            this.PApplet.line(GRID_SIZE - (GRID_SIZE / 8f), GRID_SIZE - (GRID_SIZE / 3f), GRID_SIZE, GRID_SIZE - (GRID_SIZE / 10f));
            this.PApplet.line(GRID_SIZE - (GRID_SIZE / 8f), GRID_SIZE - (GRID_SIZE / 3f), GRID_SIZE - (GRID_SIZE / 2.5f), GRID_SIZE - (GRID_SIZE / 2f));

            this.PApplet.line(GRID_SIZE / 5f, GRID_SIZE - (GRID_SIZE / 4f), GRID_SIZE / 4f, GRID_SIZE);
            this.PApplet.line(GRID_SIZE / 5f, GRID_SIZE - (GRID_SIZE / 4f), GRID_SIZE / 2.5f, GRID_SIZE - (GRID_SIZE / 2f));
            this.PApplet.line(GRID_SIZE - (GRID_SIZE / 5f), GRID_SIZE - (GRID_SIZE / 4f), GRID_SIZE - (GRID_SIZE / 4f), GRID_SIZE);
            this.PApplet.line(GRID_SIZE - (GRID_SIZE / 5f), GRID_SIZE - (GRID_SIZE / 4f), GRID_SIZE - (GRID_SIZE / 2.5f), GRID_SIZE - (GRID_SIZE / 2f));
        }

        this.PApplet.noStroke();

        this.PApplet.rectMode(this.PApplet.CENTER);

        this.PApplet.fill(35, 35, 25);
        this.PApplet.rect(GRID_SIZE / 2f, GRID_SIZE * 0.3f, GRID_SIZE / 4f, GRID_SIZE / 4f, GRID_SIZE / 15f);

        this.PApplet.fill(45, 45, 35);
        this.PApplet.rect(GRID_SIZE / 2f, GRID_SIZE * 0.6f, GRID_SIZE / 2.5f, GRID_SIZE / 2.5f, GRID_SIZE / 8f);

        this.PApplet.fill(150, 20, 0);
        this.PApplet.ellipse(GRID_SIZE * 0.47f, GRID_SIZE * 0.27f, GRID_SIZE / 20f, GRID_SIZE / 20f);
        this.PApplet.ellipse(GRID_SIZE * 0.53f, GRID_SIZE * 0.27f, GRID_SIZE / 20f, GRID_SIZE / 20f);
        this.PApplet.ellipse(GRID_SIZE * 0.41f, GRID_SIZE * 0.31f, GRID_SIZE / 20f, GRID_SIZE / 20f);
        this.PApplet.ellipse(GRID_SIZE * 0.59f, GRID_SIZE * 0.31f, GRID_SIZE / 20f, GRID_SIZE / 20f);

        this.PApplet.rectMode(this.PApplet.CORNER);
        this.PApplet.popMatrix();
    }
    public void renderHuman(Human toRender) {
        this.PApplet.fill(0, 0, 150);
        this.PApplet.rect(GRID_SIZE / 2f, GRID_SIZE / 2f, GRID_SIZE, GRID_SIZE);
    }

    private boolean inScreen(Entity toAnalyze) {
        //if(Entity.getPosition().getX())
        return true;
    }

    public int getRandomNumber(int min, int max, long seed) {
        Random random = new Random();
        random.setSeed(seed);
        return random.nextInt(max - min) + min;
    }

}
