package main.parts;

public class DumpTruckBed extends BaseBed {
    private int angle;
    private static final int maxAngle = 70;
    private static final int minAngle = 0;
    private static final int angleSpeed = 10;
    
    public DumpTruckBed() {
        this.angle = minAngle;
    }

    public void raise() {
        setAngle(Math.min(getAngle() + angleSpeed, maxAngle));
    }

    public void lower() {
        setAngle(Math.min(getAngle() - angleSpeed, minAngle));
    }

    public int getAngle() {
        return angle;
    }

    private void setAngle(int degrees) {
        angle = degrees;
    }
}
