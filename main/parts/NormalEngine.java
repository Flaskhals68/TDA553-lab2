package main.parts;

public class NormalEngine extends BaseEngine {
    private double speedFactor = 1.25;

    public NormalEngine(int enginePower) {
        super(enginePower);
    }

    public double speedFactor() {
        return speedFactor;
    }
}