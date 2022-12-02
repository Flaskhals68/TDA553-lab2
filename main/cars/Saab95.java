package main.cars;
import java.awt.geom.Point2D;
import java.awt.Color;
import main.parts.NormalBody;
import main.parts.TurboEngine;

public class Saab95 extends Car {

    public boolean turboOn;
    private static final int enginePower = 125;
    
    public Saab95(double x, double y) {
        super(new Point2D.Double(x, y), 4, enginePower, Color.red, "Saab95", new TurboEngine(enginePower), new NormalBody());
	    turboOn = false;
    }
    
    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    // @Override
    // protected double speedFactor(){
    //     double turbo = 1;
    //     if(turboOn) turbo = 1.3;
    //     return getEnginePower() * 0.01 * turbo;
    // }
}
