package main.parts;

import java.util.ArrayList;
import java.util.List;

import main.cars.Car;

public class TransportBed extends BaseBed {
    
    private boolean bedExtended = false;
    private static final int loadCapacity = 9;
    private Car[] loadedCars = new Car[loadCapacity];
    private int loadedCount = 0;
    
    public TransportBed() {
        // this.bedExtended = false;
    }

    public void raise() {
        bedExtended = true;
    }

    public void lower() {
        bedExtended = false;
    }

    public boolean getBedExtended() {
        return bedExtended;
    }

    private boolean canLoad() {
        return loadedCount < loadCapacity;
    }

    /**
     * Load car if load capacity is not exceeded
     * @param car
     */
    public void loadCar(Car car) {
        if (canLoad()) {
            loadedCars[loadedCount] = car;
            loadedCount++;
        }
    }

    public Car unloadCar() throws UnloadingFromEmptyBedException{
        if (isEmpty()) throw new UnloadingFromEmptyBedException();
        loadedCount--;
        Car unloadedCar = loadedCars[loadedCount];
        return unloadedCar;
    }

    private boolean isEmpty() {
        return loadedCount <= 0;
    }

    public class UnloadingFromEmptyBedException extends Exception {
        public static final String message = "";

        public UnloadingFromEmptyBedException() {
            super(message);
        }
    }
}
