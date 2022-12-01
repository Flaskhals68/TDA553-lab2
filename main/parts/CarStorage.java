package main.parts;
import main.cars.Car;
import main.interfaces.Positionable;

public abstract class CarStorage {
    
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

    public void load(Car car) throws LoadingToFullBedException, TargetOutsideLoadingRangeException {
        if (loadedCount >= capacity) throw new LoadingToFullBedException();
        else if (!carInRange(car)) throw new TargetOutsideLoadingRangeException();
        loadedCars[++loadedCount] = car;
    }

    public boolean carInRange(Car car){
        return owner.getPoint().distance(car.getPoint()) <= loadRange;
    }

    public Car unloadCar() throws UnloadingFromEmptyBedException{
        if (isEmpty()) throw new UnloadingFromEmptyBedException();
        loadedCount--;
        Car unloadedCar = loadedCars[loadedCount];
        return unloadedCar;
    }

    private boolean isEmpty() {
        return loadedCount <= 0;
    }

    public class LoadingToFullBedException extends Exception {
        public static final String message = "";

        public LoadingToFullBedException() {
            super(message);
        }
    }

    public class UnloadingFromEmptyBedException extends Exception {
        public static final String message = "";

        public UnloadingFromEmptyBedException() {
            super(message);
        }
    }

    public class TargetOutsideLoadingRangeException extends Exception {
        public static final String message = "No car in load range was found";

        public TargetOutsideLoadingRangeException() {
            super(message);
        }
    }
}
