package main.parts;

import main.cars.Car;

public class DumpTruckBed extends BaseBed {
    
    private static final int maxAngle = 70;
    private static final int minAngle = 0;
    private static final int angleSpeed = 10;
    private Car owner;
    private int angle;
    
    public DumpTruckBed(Car owner) {
        super(owner);
        this.angle = minAngle;
    }

    public void raise() {
        setAngle(Math.min(getAngle() + angleSpeed, maxAngle));
    }

    public void lower() {
        setAngle(Math.max(getAngle() - angleSpeed, minAngle));
    }

    public int getAngle() {
        return angle;
    }

    private void setAngle(int degrees) {
        angle = degrees;
    }
}
