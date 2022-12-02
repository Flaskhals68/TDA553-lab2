package main.cars;
import java.awt.geom.Point2D;

import main.interfaces.CanStoreCars;
import main.interfaces.Positionable;
import main.exceptions.Exceptions.*;

public class CarRepairShop implements Positionable, CanStoreCars {
    private static final int loadRange = 10;
    private int loadedCount = 0;
    private Car[] loadedCars;
    private int capacity;
    private Point2D.Double point;

<<<<<<< Updated upstream
    public CarRepairShop(Point2D.Double point, int capacity) {
        this.point = point;
        this.capacity = capacity;
        loadedCars = new Car[this.capacity];
=======
    public CarRepairShop(double x, double y, int capacity) {
        this.point = new DPoint(x, y);
        this.carStorage = new CarStorageStationary(capacity, loadRange, this);
>>>>>>> Stashed changes
    }

    public double getX() {
        return point.x;
    }

    public double getY() {
        return point.y;
    }

    public void load(Car car) {
        if (loadedCount >= capacity) throw new LoadingToFullBedException();
        else if (distanceToOther(car) > 10) throw new CarTooFarAwayException();
        loadedCars[++loadedCount] = car;
    }

    public Car unload() {
        Car car = loadedCars[--loadedCount];
        car.setX(getX());
        car.setY(getY() + loadRange);
        return car;
    }

<<<<<<< Updated upstream
    public Point2D.Double getPoint(){
=======
    public Car unloadCar(int index) throws UnloadingFromEmptyBedException {
        return carStorage.unloadCar(index);
    }

    public DPoint getPoint() {
>>>>>>> Stashed changes
        return point;
    }

    public double distanceToOther(Positionable other){
        return this.point.distance(other.getPoint());
    }

    public int getLoadCount() {
        return carStorage.getLoadCount();
    }
}