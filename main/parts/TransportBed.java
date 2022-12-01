package main.parts;

import java.util.ArrayList;
import java.util.List;

import main.cars.Car;

public class TransportBed implements BaseBed {
    
    private boolean bedExtended = false;
    private static final int loadCapacity = 9;
    private final Car[] loadedCars = new Car[loadCapacity];
    private int loadedCount = 0;
    private static final int loadRange = 10;
    private Car owner;
    
    public TransportBed(Car owner) {
        this.owner = owner;
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
     * @throws NoCarInLoadRange
     * @throws LoadingToFullBedException
     * @throws LoadingWhileMovingException
     */
    public void loadCar(Car car) throws LoadingToFullBedException, LoadingWhileMovingException, NoCarInLoadRange {
        if (!getBedExtended()) throw new LoadingWhileMovingException();
        else if (!canLoad()) throw new LoadingToFullBedException();
        else if (!inLoadRange(car)) throw new NoCarInLoadRange();
        loadedCars[loadedCount] = car;
        loadedCount++;
    }

    public Car unloadCar() throws UnloadingFromEmptyBedException, LoadingWhileMovingException{
        if (!getBedExtended()) throw new LoadingWhileMovingException();
        if (isEmpty()) throw new UnloadingFromEmptyBedException();
        loadedCount--;
        Car unloadedCar = loadedCars[loadedCount];
        return unloadedCar;
    }

    private boolean isEmpty() {
        return loadedCount <= 0;
    }

    private boolean inLoadRange(Car car) {
        return owner.distToOther(car) <= loadRange;
    }

    public class LoadingWhileMovingException extends Exception {
        public static final String message = "";

        public LoadingWhileMovingException() {
            super(message);
        }
    }

    public void moveLoaded() {
        for (Car car : loadedCars) {
            car.setX(owner.getX());
            car.setY(owner.getY());
        }
    }
}
