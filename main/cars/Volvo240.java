package main.cars;
import java.awt.Color;
import main.parts.*;

public class Volvo240 extends Car {

    private final static int enginePower = 100;

    public Volvo240(double x, double y) {
        super(x, y, 4, enginePower, Color.black, "Volvo240", new NormalEngine(enginePower), new TrimmedBody());
    }
}