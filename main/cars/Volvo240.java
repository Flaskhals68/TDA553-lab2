package main.cars;
import java.awt.*;
import main.parts.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;
    private final static int enginePower = 100;

    public Volvo240(double x, double y) {
        super(x, y, 4, enginePower, Color.black, "Volvo240", new NormalEngine(enginePower), new TrimmedBody());
    }

    // @Override
    // protected double speedFactor() {
    //     return getEnginePower() * 0.01 * trimFactor;
    // }
}