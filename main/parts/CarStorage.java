package main.parts;
import main.cars.Car;
import main.interfaces.HasCarStorage;
import main.interfaces.Positionable;
import main.misc.DPoint;

public abstract class CarStorage implements HasCarStorage, Positionable { 
    
    private Positionable owner;
    private int loadRange;
    private int capacity;
    private int loadedCount;
    private Car[] loadedCars;

    public CarStorage(int capacity, int range, Positionable owner) {
        this.capacity = capacity;
        this.loadRange = range;
        this.owner = owner;
        this.loadedCars = new Car[this.capacity];
    }

    public boolean inLoadingRange(Car car){
        return owner.getPoint().distance(car.getPoint()) <= loadRange;
    }

    public void loadCar(Car car) throws LoadingToFullStorageException, TargetOutsideLoadingRangeException {
        if (loadedCount >= capacity) throw new LoadingToFullStorageException();
        else if (!inLoadingRange(car)) throw new TargetOutsideLoadingRangeException();
        loadedCars[loadedCount++] = car;
    }

    public Car unloadCar() throws UnloadingFromEmptyStorageException {
        if (isEmpty()) throw new UnloadingFromEmptyStorageException();
        Car car = loadedCars[--loadedCount];
        car.setX(owner.getX());
        car.setY(owner.getY() + loadRange);
        return car;
    }

    private boolean isEmpty() {
        return loadedCount <= 0;
    }

    public double distanceToOther(Positionable other){
        return owner.distanceToOther(other);
    }

    public DPoint getPoint() {
        return owner.getPoint();
    }

    public double getX(){
        return owner.getX();
    }

    public double getY(){
        return owner.getY();
    }

    public int getLoadedCount() {
        return loadedCount;
    }
}
