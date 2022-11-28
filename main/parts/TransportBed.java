package main.parts;

import main.cars.Car;

public class TransportBed extends BaseBed {
    
    private boolean bedExtended = false;
    private static final int loadCapacity = 9;
    private Car[] loadedCars = new Car[loadCapacity];
    private int loadCount = 0;
    
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
        return loadCount < loadCapacity;
    }

    /**
     * Load car if load capacity is not exceeded
     * @param car
     */
    public void loadCar(Car car) {
        if (canLoad()) {
            loadedCars[loadCount] = car;
            loadCount++;
            // TODO chose where loaded car should end up
        }
    }

    /**
     * Unload and return the last car to be loaded
     * @return Car
     * @throws UnloadingFromEmptyBedException
     */
    public Car unloadCar() throws UnloadingFromEmptyBedException {
        if (isEmpty()) throw new UnloadingFromEmptyBedException();
        loadCount--;
        Car unloadedCar = loadedCars[loadCount];
        loadedCars[loadCount] = null;
        return unloadedCar;
    }

    /**
     * Unload all cars stored on the transporter bed
     * @return Car[] of all loaded cars
     * @throws UnloadingFromEmptyBedException
     */
    public Car[] unloadAll() throws UnloadingFromEmptyBedException {
        Car[] unloadedCars = new Car[loadCount];
        for (int i = loadCount-1; i > 0; i--) {
            unloadedCars[i] = unloadCar();
        }
        return unloadedCars;
    }

    private boolean isEmpty() {
        return loadCount <= 0;
    }

    public class UnloadingFromEmptyBedException extends Exception {
        public static final String message = "Unable to unload from empty bed";

        public UnloadingFromEmptyBedException() {
            super(message);
        }
    }
}
