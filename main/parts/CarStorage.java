package main.parts;
import main.cars.Car;
import main.interfaces.HasCarStorage;
import main.interfaces.Positionable;

public abstract class CarStorage implements HasCarStorage{
    
    private Positionable owner;
    private int loadRange;
    private int capacity;
    private int loadedCount;
    private Car[] loadedCars;

    public CarStorage(int capacity, int range, Positionable owner){
        this.capacity = capacity;
        this.loadRange = range;
        this.owner = owner;
        this.loadedCars = new Car[this.capacity];
    }

    public boolean carInRange(Car car){
        return owner.getPoint().distance(car.getPoint()) <= loadRange;
    }

    public void loadCar(Car car) throws LoadingToFullBedException, TargetOutsideLoadingRangeException {
        if (loadedCount >= capacity) throw new LoadingToFullBedException();
        else if (!carInRange(car)) throw new TargetOutsideLoadingRangeException();
        loadedCars[++loadedCount] = car;
    }

    public Car unloadCar() throws UnloadingFromEmptyBedException {
        if (isEmpty()) throw new UnloadingFromEmptyBedException();
        Car car = loadedCars[--loadedCount];
        car.setX(owner.getX());
        car.setY(owner.getY() + loadRange);
        return car;
    }

    private boolean isEmpty() {
        return loadedCount <= 0;
    }
}
