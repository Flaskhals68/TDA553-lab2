package main.interfaces;

import main.cars.Car;

public interface HasCarStorage {
    void loadCar(Car car) throws LoadingToFullBedException, TargetOutsideLoadingRangeException;
    Car unloadCar() throws UnloadingFromEmptyBedException;

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