package main.interfaces;

import main.cars.Car;

public interface HasCarStorage {
    void load(Car car);
    Car unload();
}