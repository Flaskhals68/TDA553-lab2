package main.interfaces;

import main.cars.Car;

public interface CanStoreCars {
    void load(Car car);
    Car unload();
}