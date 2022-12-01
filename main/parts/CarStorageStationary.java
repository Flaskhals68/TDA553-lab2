package main.parts;

import main.cars.Car;

public class CarStorageStationary extends CarStorage{
    
    private int capacity;
    private int loadRange;
    private int loadedCount;
    private Car owner;
    private Car[] loadedCars;

    public CarStorageStationary(int capacity, int loadRange, Car owner){
        super(capacity, loadRange, owner);
    }

    public Car unloadCar(int index){
        Car car = loadedCars[index];
        --loadedCount;
        return car;
    }
}
