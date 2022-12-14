package main.parts;

public class TurboEngine extends BaseEngine {
    private double turboFactor = 1.3;
    private boolean turboOn = false;

    public TurboEngine(int speedFactor) {
        super(speedFactor);
    }

    public double speedFactor() {
        return (turboOn) ? getEnginePower() * turboFactor : getEnginePower();
    }

    public void setTurboOn() {
        this.turboOn = true;
    }

    public void setTurboOff() {
        this.turboOn = false;
    }
}