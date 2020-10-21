package creatures;

import math.VectorF2D;

public class Human extends Entity {
    private VectorF2D position;

    public Human(VectorF2D position) {
        this.position = position;
    }

    public VectorF2D getPosition() {
        return position;
    }

    public void setPosition(VectorF2D newPosition) {
        position = newPosition;
    }

    public void setPosition(float newXPosition, float newYPosition) {
        position.setValues(newXPosition, newYPosition);
    }
}

