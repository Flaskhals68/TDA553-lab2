package main.cars;

import java.awt.Color;

import main.interfaces.HasBed;
import main.interfaces.HasCarStorage;
import main.parts.NormalBody;
import main.parts.NormalEngine;
import main.parts.TransportBed;

public class Transporter extends Car implements HasBed, HasCarStorage {
    private TransportBed bed;

    public Transporter(double x, double y) {
        super(x, y, 80, 2, Color.white, "Transporter", new NormalEngine(80), new NormalBody());
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

    public void loadCar(Car car) throws TransportBed.LoadingToFullBedException, TransportBed.RampNotExtendedException, TargetOutsideLoadingRangeException {
        bed.loadCar(car);
    }

    public Car unloadCar() throws TransportBed.UnloadingFromEmptyBedException, TransportBed.RampNotExtendedException{
        return bed.unloadCar();
    }

    @Override
    public void move() {
        super.move();
        bed.moveLoaded();
    }
}
