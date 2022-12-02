package main.parts;

import main.cars.Car;
import main.interfaces.HasBed;

public abstract class BaseBed implements HasBed{

    private Car owner;

    public BaseBed(Car owner) {
        this.owner = owner;
    }

    public boolean canMoveBed() {
        return owner.getCurrentSpeed() == 0;
    }

    public abstract void raise();
    public abstract void lower();
}
