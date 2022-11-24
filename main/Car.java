package main;
import java.awt.*;

public abstract class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x; // The x coordiante of the car
    private double y; // The y coordiante of the car
    private Direction direction; // The Enum Direction direction of the car (UP, DOWN, LEFT, RIGHT)
    
    public Car(double x, double y, int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.direction = Direction.UP;
        stopEngine();
    }
    
    public enum Direction {
        UP,
        LEFT,
        RIGHT,
        DOWN,
    }
    
    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);

    protected abstract double speedFactor();

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    protected void setCurrentSpeed(double newCurrentSpeed){
        currentSpeed = newCurrentSpeed;
    }

    public String getModelName(){
        return modelName;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public Direction getDirection(){
        return direction;
    }

    private void setDirection(Direction newDirection) {
        direction = newDirection;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }
    
    public void gas(double amount){
        if (amount < 0 || amount > 1) throw new IllegalArgumentException();
        incrementSpeed(amount);
    }

    public void brake(double amount){
        if (amount < 0 || amount > 1) throw new IllegalArgumentException();
        decrementSpeed(amount);
    }

    public void move() {
        double speed = getCurrentSpeed();
        switch (direction) {
            case UP:
                y += speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case DOWN:
                y -= speed;
                break;
            case LEFT:
                x -= speed;
                break;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case UP:
                setDirection(Direction.LEFT);
                break;
            case RIGHT:
                setDirection(Direction.UP);
                break;
            case DOWN:
                setDirection(Direction.RIGHT);
                break;
            case LEFT:
                setDirection(Direction.DOWN);
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case UP:
                setDirection(Direction.RIGHT);
                break;
            case RIGHT:
                setDirection(Direction.DOWN);
                break;
            case DOWN:
                setDirection(Direction.LEFT);
                break;
            case LEFT:
                setDirection(Direction.UP);
                break;
        }
    }
}
