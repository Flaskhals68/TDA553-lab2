package main.parts;

import main.cars.Car;

public abstract class BaseBed {

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
