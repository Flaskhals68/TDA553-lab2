package main.cars;

import main.interfaces.HasCarStorage;
import main.interfaces.Positionable;
import main.misc.DPoint;
import main.parts.CarStorageStationary;

public class CarRepairShop implements Positionable, HasCarStorage {
    private static final int loadRange = 10;
    private DPoint point;
    private CarStorageStationary carStorage;

    public CarRepairShop(double x, double y, int capacity) {
        this.point = new DPoint(x, y);
        this.carStorage = new CarStorageStationary(capacity, loadRange, this);
    }

    public double getX() {
        return point.x;
    }

    public double getY() {
        return point.y;
    }

    public void loadCar(Car car) throws LoadingToFullStorageException, TargetOutsideLoadingRangeException{
        carStorage.loadCar(car);
    }

    public Car unloadCar() throws UnloadingFromEmptyStorageException{
        return carStorage.unloadCar();
    }

    public Car unloadCar(int index) {
        return carStorage.unloadCar(index);
    }

    public DPoint getPoint() {
        return point;
    }

    public double distanceToOther(Positionable other){
        return this.point.distance(other.getPoint());
    }

    public int getLoadedCount() {
        return carStorage.getLoadedCount();
    }
}