package main.cars;

import java.awt.Color;

import main.parts.NormalBody;
import main.parts.NormalEngine;

public class ScaniaP340 extends Car {
    private static final int enginePower = 80;
    private static final int nrDoors = 2;

    public ScaniaP340(double x, double y) {
        super(x, y, enginePower, nrDoors, Color.black, "ScaniaP340", new NormalEngine(enginePower), new NormalBody());
    }
}
