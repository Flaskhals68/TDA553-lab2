package main.parts;

public class TrimmedBody extends BaseBody {
    private final double trimFactor = 1.25;
    public double speedFactor() {
        return trimFactor;
    }
}
