package game;

import blocks.Block;
import creatures.*;
import math.VectorF2D;
import rendering.Renderer;

import java.util.ArrayList;
import java.lang.Math;

public class Game {

    private ArrayList<Scenario> scenarios = new ArrayList<Scenario>();

    private ArrayList <Dwarf> dwarves = new ArrayList <Dwarf>(); // Lists to hold all entities
    private ArrayList<Hobbit> hobbits = new ArrayList<Hobbit>();
    private ArrayList<Goblin> goblins = new ArrayList<Goblin>();
    private ArrayList<Spider> spiders = new ArrayList<Spider>();
    private ArrayList <Human> humans  = new ArrayList <Human>();

    Renderer renderer; // Renderer instance to display the game with

    private int currentScenario;

    public Game(Renderer renderer) {
        this.renderer = renderer; // Renderer instance to display the game with

        int[][] scenario1 = {                               // Data for the first scenario
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };

        scenarios.add(new Scenario(createLevelData(scenario1)));

        this.currentScenario = 0;

        test();
    }


    public void test() {
        dwarves.add(new Dwarf(new VectorF2D(500, 500), 245));
        hobbits.add(new Hobbit(new VectorF2D(500, 800), 11));
        goblins.add(new Goblin(new VectorF2D(200, 500),45));
        spiders.add(new Spider(new VectorF2D(1200, 500),90));
    }

    public ArrayList<Dwarf> getDwarves() { // Getting the lists that hold entities

        //dwarves.get(0).setDirection(dwarves.get(0).getDirection() - 1);
        return dwarves;
    }

    public ArrayList<Hobbit> getHobbits() {
        return hobbits;
    }

    public ArrayList<Goblin> getGoblins() {
        return goblins;
    }

    public ArrayList<Spider> getSpiders() {
        return spiders;
    }

    public ArrayList<Human> getHumans() {
        return humans;
    }

    public Scenario getCurrentScenario() {
        return scenarios.get(currentScenario);
    }

    private Block[][] createLevelData(int[][] integerBlockMap) {
        Block [][] levelData = new Block[integerBlockMap.length][integerBlockMap.length];

        for(int i = 0; i < integerBlockMap.length; i++) {
            for(int j = 0; j < integerBlockMap[i].length; j++) {
                int currentLocation = integerBlockMap[i][j];
                String type = "";

                if(currentLocation == 0)
                    type = "grass";

                if(currentLocation == 1)
                    type = "tree";

                levelData[i][j] = new Block(new VectorF2D(j, i), type);
            }
        }

        return levelData;
    }



}
