package math;

public class VectorF2D {

    private float x, y;

    public VectorF2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setValues(float newX, float newY) {
        x = newX;
        y = newY;
    }

    public float getX() { return x; }

    public void setX(float x) { this.x = x; }

    public float getY() { return y; }

    public void setY(float y) { this.y = y; }
}
