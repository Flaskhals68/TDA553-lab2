package main.parts;

import main.cars.Car;
import main.interfaces.Positionable;

public class CarStorageStationary extends CarStorage{
    
    private int loadRange;
    private int loadedCount;
    private Car[] loadedCars;

    public CarStorageStationary(int capacity, int loadRange, Positionable owner){
        super(capacity, loadRange, owner);
    }

    public Car unloadCar(int index){
        Car car = loadedCars[index];
        car.setX(owner.getX());
        car.setY(owner.getY() + loadRange);
        --loadedCount;
        return car;
    }
}
