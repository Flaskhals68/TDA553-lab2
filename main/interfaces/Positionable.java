package main.interfaces;

import main.misc.DPoint;

public interface Positionable {
    public double distanceToOther(Positionable other);
    public DPoint getPoint();
    public double getX();
    public double getY();
}
