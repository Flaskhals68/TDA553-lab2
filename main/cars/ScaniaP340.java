package main.cars;

import java.awt.Color;
import java.awt.geom.Point2D;

import main.interfaces.HasBed;
import main.parts.DumpTruckBed;
import main.parts.NormalBody;
import main.parts.NormalEngine;

public class ScaniaP340 extends Car implements HasBed {
    private static final int enginePower = 80;
    private static final int nrDoors = 2;
    private DumpTruckBed bed;

    public ScaniaP340(Point2D.Double point) {
        super(point, enginePower, nrDoors, Color.black, "ScaniaP340", new NormalEngine(enginePower), new NormalBody());
        this.bed = new DumpTruckBed();
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

    public int getAngle(){
        return bed.getAngle();
    }

    public boolean canMoveBed() {
        return getCurrentSpeed() == 0;
    }

    @Override
    public void gas(double amount) {
        if (bed.getAngle() == 0) {
            super.gas(amount);
        }
    }
}
