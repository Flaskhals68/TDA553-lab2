package main.parts;

public class NormalEngine extends BaseEngine {

    public NormalEngine(int enginePower) {
        super(enginePower);
    }

    public double speedFactor() {
        return getEnginePower();
    }
}