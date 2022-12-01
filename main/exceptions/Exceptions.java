package main.exceptions;

public class Exceptions {
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

    public class NoCarInLoadRange extends Exception {
        public static final String message = "No car in load range was found";

        public NoCarInLoadRange() {
            super(message);
        }
    }
}
