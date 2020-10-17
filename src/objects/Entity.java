package objects;

import math.VectorF2D;

public abstract class Entity {
    protected VectorF2D position;

    abstract VectorF2D getPosition();
    abstract void setPosition(VectorF2D newPosition);
    abstract void setPosition(float newXPosition, float newYPosition);
}



