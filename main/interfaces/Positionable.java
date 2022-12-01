package main.interfaces;
import java.awt.geom.Point2D;

public interface Positionable {
    public double distanceToOther(Positionable other);
    public Point2D.Double getPoint();
}
