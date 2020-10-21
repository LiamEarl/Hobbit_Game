package rendering;
import creatures.Entity;
import math.VectorF2D;

public class Camera {
    private Entity target;
    private VectorF2D position;

    public Camera(Entity target) {
        this.target = target;
    }

    public void updateCameraPosition() {
        position = target.getPosition();
    }

    public void setTarget(Entity newTarget) {
        target = newTarget;
    }

    public VectorF2D getCameraPosition() {
        return position;
    }
}
