package main.parts;

import main.cars.Car;
import main.interfaces.Positionable;

public class CarStorageMobile extends CarStorage{
    
    private Positionable owner;
    private Car[] loadedCars;
    private int loadedCount;

    public CarStorageMobile(int capacity, int loadRange, Positionable owner){
        super(capacity, loadRange, owner);
    }

    public void moveLoaded() {
        // for (Car car : loadedCars) {
        //     car.setPoint(owner.getPoint());
        // }

        for (int i = 0; i < loadedCount; i++) {
            Car car = loadedCars[i];
            car.setPoint(owner.getPoint());
        }
    }
}
