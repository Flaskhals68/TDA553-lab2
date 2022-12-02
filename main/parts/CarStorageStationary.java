package main.parts;

import main.cars.Car;
import main.interfaces.Positionable;

public class CarStorageStationary extends CarStorage{
    
    private int loadedCount;
    private Car[] loadedCars;

    public CarStorageStationary(int capacity, int loadRange, Positionable owner){
        super(capacity, loadRange, owner);
    }

    public Car unloadCar(int index) throws UnloadingFromEmptyBedException {
        if (loadedCount <= 0) throw new UnloadingFromEmptyBedException();
        Car car = loadedCars[index];
        loadedCount--;
        return car;
    }
}
