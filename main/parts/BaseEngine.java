package main.parts;

public abstract class BaseEngine {

    private int enginePower;

    public BaseEngine(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public abstract double speedFactor();
}
