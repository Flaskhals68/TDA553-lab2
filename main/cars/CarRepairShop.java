package main.cars;
import java.awt.geom.Point2D;

import main.interfaces.HasCarStorage;
import main.interfaces.Positionable;
import main.parts.CarStorageStationary;
import main.exceptions.Exceptions.*;

public class CarRepairShop implements Positionable, HasCarStorage {
    private static final int loadRange = 10;
    private int loadedCount = 0;
    private Car[] loadedCars;
    private int capacity;
    private Point2D.Double point;
    private CarStorageStationary carStorage;

    public CarRepairShop(Point2D.Double point, int capacity) {
        this.point = point;
        this.carStorage = new CarStorageStationary(capacity, loadRange, this);
    }

    public double getX() {
        return point.x;
    }

    public double getY() {
        return point.y;
    }

    public void loadCar(Car car) throws LoadingToFullBedException, TargetOutsideLoadingRangeException{
        carStorage.loadCar(car);
    }

    public Car unloadCar() throws UnloadingFromEmptyBedException{
        return carStorage.unloadCar();
    }

    public Car unloadCar(int index) {
        return carStorage.unloadCar(index);
    }

    public Point2D.Double getPoint(){
        return point;
    }

    public double distanceToOther(Positionable other){
        return this.point.distance(other.getPoint());
    }

}