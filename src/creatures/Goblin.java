package creatures;

import math.VectorF2D;

public class Goblin extends Entity {
    private VectorF2D position;

    public Goblin(VectorF2D position) { // Constructor
        this.position = position;
    }

    public VectorF2D getPosition() {
        return position;
    } // Method to give the position of the entity.

    public void setPosition(VectorF2D newPosition) { position = newPosition; } // Method to set the position of the entity

    public void setPosition(float newXPosition, float newYPosition) {  // A different method to set the position of the entity.
        position.setValues(newXPosition, newYPosition);
    }
}

