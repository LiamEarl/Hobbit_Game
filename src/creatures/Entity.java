package creatures;

import math.VectorF2D;

public abstract class Entity {
    protected VectorF2D position;
    protected int direction;

    public abstract VectorF2D getPosition();
    public abstract void setPosition(VectorF2D newPosition);
    public abstract void setPosition(float newXPosition, float newYPosition);
    public abstract void setDirection(int direction);
    public abstract int getDirection();
}



