package main.cars;

import main.interfaces.HasCarStorage;
import main.interfaces.Positionable;
import main.misc.DPoint;
import main.parts.CarStorageStationary;

public class CarRepairShop implements Positionable, HasCarStorage {
    private static final int loadRange = 10;
    private DPoint point;
    private CarStorageStationary carStorage;

    public CarRepairShop(DPoint point, int capacity) {
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

    public DPoint getPoint() {
        return point;
    }

    public double distanceToOther(Positionable other){
        return this.point.distance(other.getPoint());
    }

}