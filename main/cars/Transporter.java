package main.cars;

import java.awt.Color;

import main.interfaces.HasBed;
import main.parts.NormalBody;
import main.parts.NormalEngine;
import main.parts.TransportBed;

public class Transporter extends Car implements HasBed {
    private boolean lowered = false;
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
}
