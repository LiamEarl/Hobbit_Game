package creatures;

import math.VectorF2D;

public abstract class Entity {
    protected VectorF2D position;

    public abstract VectorF2D getPosition();
    public abstract void setPosition(VectorF2D newPosition);
    public abstract void setPosition(float newXPosition, float newYPosition);
}



