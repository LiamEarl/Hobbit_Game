package creatures;

import math.VectorF2D;

public class Dwarf extends Entity {
    private VectorF2D position;

    public Dwarf(VectorF2D position) {
        this.position = position;
    } // Constructor

    public VectorF2D getPosition() {
        return position;
    } // Method to give the position of the entity.

    public void setPosition(VectorF2D newPosition) { position = newPosition; } // Method to set the position of the entity

    public void setPosition(float newXPosition, float newYPosition) {  // A different method to set the position of the entity.
        position.setValues(newXPosition, newYPosition);
    }
}

