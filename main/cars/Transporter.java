package main.cars;

import java.awt.Color;

import main.interfaces.HasBed;
import main.parts.NormalBody;
import main.parts.NormalEngine;
import main.parts.TransportBed;

public class Transporter extends Car implements HasBed {
    private static final double loadDist = 10;
    private TransportBed bed = new TransportBed();

    public Transporter(double x, double y) {
        super(x, y, 80, 2, Color.white, "Transporter", new NormalEngine(80), new NormalBody());
        // this.bed = new TransportBed();
    }

    public boolean canMoveBed() {
        return true;
    }

    public void raise() {
        bed.raise();
    }

    public void lower() {
        bed.lower();
    }

    public void loadCar(Car car) {
        if (bed.getBedExtended() == true && distToCar(car) <= loadDist)
            bed.loadCar(car);
    }

    private double distToCar(Car car) {
        double dx = this.getX() - car.getX();
        double dy = this.getY() - car.getY();
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }
}
