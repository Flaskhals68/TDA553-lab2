package main.cars;

import java.awt.Color;
import java.awt.geom.Point2D;

import main.interfaces.HasBed;
import main.interfaces.Positionable;
import main.parts.NormalBody;
import main.parts.NormalEngine;
import main.parts.TransportBed;
import main.parts.TransportBed.NoCarInLoadRange;

public class Transporter extends Car implements HasBed {
    private TransportBed bed;

    public Transporter(double x, double y) {
        super(new Point2D.Double(x, y), 80, 2, Color.white, "Transporter", new NormalEngine(80), new NormalBody());
        bed = new TransportBed(this);
    }

    public boolean canMoveBed() {
        return !bed.getBedExtended();
    }

    public void raise() {
        if (canMoveBed()) {
            bed.raise();
        }
    }

    public void lower() {
        if (canMoveBed()) {
            bed.lower();
        }
    }

    public void loadCar(Car car) throws TransportBed.LoadingToFullBedException, TransportBed.LoadingWhileMovingException, NoCarInLoadRange {
        bed.loadCar(car);
    }

    public Car unloadCar() throws TransportBed.UnloadingFromEmptyBedException, TransportBed.LoadingWhileMovingException{
        return bed.unloadCar();
    }

    @Override
    public void move() {
        super.move();
        bed.moveLoaded();
    }

    public int getLoadCount() {
        return bed.getLoadCount();
    }
}
