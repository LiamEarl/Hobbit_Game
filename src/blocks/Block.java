package blocks;

import math.VectorF2D;

public class Block {
    private VectorF2D position;
    private String type;

    public Block(VectorF2D position, String type) {
        this.position = position;
        this.type = type;
    }

    public VectorF2D getPosition() {
        return position;
    }

    public void setPosition(VectorF2D position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }
}

