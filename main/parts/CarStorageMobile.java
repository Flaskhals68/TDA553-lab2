package main.parts;

import main.cars.Car;
import main.interfaces.Positionable;

public class CarStorageMobile extends CarStorage{
    
    private int capacity;
    private int loadRange;
    private int loadedCount;
    private Car owner;
    private Car[] loadedCars;

    public CarStorageMobile(int capacity, int loadRange, Car owner){
        super(capacity, loadRange, owner);
    }

    public void moveLoaded() {
        for (Car car : loadedCars) {
            car.setPoint(owner.getPoint())
        }
    }
}
