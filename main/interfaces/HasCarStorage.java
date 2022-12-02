package main.interfaces;

import main.cars.Car;

public interface HasCarStorage {
    void loadCar(Car car) throws LoadingToFullStorageException, TargetOutsideLoadingRangeException, RampNotExtendedException;
    Car unloadCar() throws UnloadingFromEmptyStorageException, RampNotExtendedException;
    int getLoadedCount();

    public class LoadingToFullStorageException extends Exception {
        public static final String message = "";

        public LoadingToFullStorageException() {
            super(message);
        }
    }

    public class UnloadingFromEmptyStorageException extends Exception {
        public static final String message = "";

        public UnloadingFromEmptyStorageException() {
            super(message);
        }
    }

    public class TargetOutsideLoadingRangeException extends Exception {
        public static final String message = "No car in load range was found";

        public TargetOutsideLoadingRangeException() {
            super(message);
        }
    }

    public class RampNotExtendedException extends Exception {
        public static final String message = "";

        public RampNotExtendedException() {
            super(message);
        }
    }
}