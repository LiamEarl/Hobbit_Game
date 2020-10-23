package game;

import creatures.*;

import java.util.ArrayList;

public class Game {

    private ArrayList <Dwarf> dwarves = new ArrayList <Dwarf>(); // Lists to hold all creatures
    private ArrayList<Hobbit> hobbits = new ArrayList<Hobbit>();
    private ArrayList<Goblin> goblins = new ArrayList<Goblin>();
    private ArrayList<Spider> spiders = new ArrayList<Spider>();
    private ArrayList <Human> humans  = new ArrayList <Human>();

    public Game() {

    }



    public ArrayList<Dwarf> getDwarves() {
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
}
