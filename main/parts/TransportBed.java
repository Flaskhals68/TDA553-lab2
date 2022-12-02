package main.parts;

import java.awt.geom.Point2D.Double;

import main.cars.Car;
import main.interfaces.HasCarStorage;
import main.interfaces.Positionable;

public class TransportBed implements BaseBed, Positionable, HasCarStorage{
    
    private boolean bedExtended = false;
    private static final int loadCapacity = 9;
    private static final int loadRange = 10;
    private Car owner;
    private CarStorageMobile carStorage;
    
    public TransportBed(Car owner) {
        this.owner = owner;
        this.carStorage = new CarStorageMobile(loadCapacity, loadRange, this);
    }

    public void raise() {
        bedExtended = true;
    }

    public void lower() {
        bedExtended = false;
    }

    public boolean getBedExtended() {
        return bedExtended;
    }

    /**
     * Load car if load capacity is not exceeded
     * @param car
     * @throws TargetOutsideLoadingRangeException
     * @throws LoadingToFullBedException
     * @throws RampNotExtendedException
     */
    public void loadCar(Car car) throws LoadingToFullBedException, RampNotExtendedException, TargetOutsideLoadingRangeException {
        if (!getBedExtended()) throw new RampNotExtendedException();
        //else if (!canLoad()) throw new LoadingToFullBedException();
        //else if (!inLoadRange(car)) throw new TargetOutsideLoadingRangeException();
        //loadedCars[loadedCount] = car;
        //loadedCount++;
        carStorage.loadCar(car);
    }

    public Car unloadCar() throws UnloadingFromEmptyBedException, RampNotExtendedException{
        if (!getBedExtended()) throw new RampNotExtendedException();
        //if (isEmpty()) throw new UnloadingFromEmptyBedException();
        //loadedCount--;
        //Car unloadedCar = loadedCars[loadedCount];
        //return unloadedCar;
        return carStorage.unloadCar();
    }

    public double distanceToOther(Positionable other){
        return owner.distanceToOther(other);
    }

    public Double getPoint() {
        return owner.getPoint();
    }

    public double getX() {
        return owner.getX();
    }

    public double getY(){
        return owner.getY();
    }

    public void moveLoaded() {
        carStorage.moveLoaded();
    }
}
