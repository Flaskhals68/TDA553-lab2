package main.parts;

public class DumpTruckBed implements BaseBed {
    
    private static final int maxAngle = 70;
    private static final int minAngle = 0;
    private static final int angleSpeed = 10;
    private int angle;
    
    public DumpTruckBed() {
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
