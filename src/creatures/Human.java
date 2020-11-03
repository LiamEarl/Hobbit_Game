package creatures;

import math.VectorF2D;

public class Human extends Entity {
    private VectorF2D position;

    private int direction;

    public Human(VectorF2D position, int direction) { // Constructor
        this.position = position;
        this.direction = direction;
    }

    public VectorF2D getPosition() {
        return position;
    } // Method to give the position of the entity.

    public void setPosition(VectorF2D newPosition) { position = newPosition; } // Method to set the position of the entity

    public void setPosition(float newXPosition, float newYPosition) {  // A different method to set the position of the entity.
        position.setValues(newXPosition, newYPosition);
    }

    public int getDirection() { // Method to get the direction of the entity
        return direction;
    }

    public void setDirection(int direction) { // Method to set the direction of the entity;
        this.direction = direction;
    }
}

