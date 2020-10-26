package game;

import blocks.Block;

public class Scenario {
    Block[][] levelData;

    public Scenario(Block[][] levelData) {
        this.levelData = levelData;
    }

    public Block[][] getLevelData() {
        return levelData;
    }
}
