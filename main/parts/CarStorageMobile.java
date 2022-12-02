package main.parts;

import main.cars.Car;
import main.interfaces.Positionable;

public class CarStorageMobile extends CarStorage{
    
    private int capacity;
    private int loadRange;
    private int loadedCount;
    private Positionable owner;
    private Car[] loadedCars;

    public CarStorageMobile(int capacity, int loadRange, Positionable owner){
        super(capacity, loadRange, owner);
    }

    public void moveLoaded() {
        for (Car car : loadedCars) {
            car.setPoint(owner.getPoint());
        }
    }
}
