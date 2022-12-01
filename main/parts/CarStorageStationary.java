package main.parts;

import main.cars.Car;
import main.interfaces.Positionable;

public class CarStorageStationary extends CarStorage{
    
    private int capacity;
    private int loadRange;
    private int loadedCount;
    private Positionable owner;
    private Car[] loadedCars;

    public CarStorageStationary(int capacity, int loadRange, Positionable owner){
        super(capacity, loadRange, owner);
    }

    public Car unloadCar(int index){
        Car car = loadedCars[index];
        --loadedCount;
        return car;
    }
}
