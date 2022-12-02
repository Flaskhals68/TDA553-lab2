package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import main.cars.Car;
import main.cars.Saab95;

public class TestSaab95 {
    
    @Test
    public void saab_should_move_to_positive_coordinates() {
        Saab95 saab = new Saab95(0, 0);
        saab.gas(0.5);
        saab.move();
        assertEquals(0.625, saab.getY(), 0.001);
        assertEquals(0, saab.getX(), 0.001);

        saab.turnRight();
        saab.move();
        assertEquals(0.625, saab.getY(), 0.001);
        assertEquals(0.625, saab.getX(), 0.001);
    }

    @Test
    public void saab_should_move_to_negative_coordinates() {
        Saab95 saab = new Saab95(0, 0);
        saab.gas(0.5);
        saab.turnRight();
        saab.turnRight();
        saab.move();
        assertEquals(-0.625, saab.getY(), 0.001);
        assertEquals(0, saab.getX(), 0.001);

        saab.turnRight();
        saab.move();
        assertEquals(-0.625, saab.getY(), 0.001);
        assertEquals(-0.625, saab.getX(), 0.001);
    }

    @Test
    public void saab_should_not_exceed_max_speed() {
        Saab95 saab = new Saab95(0, 0);
        for(int i = 0 ; i < 100 ; i++) {
            saab.gas(1);
        }
        assertEquals(saab.getEnginePower(), saab.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void saab_should_have_correct_speed_after_braking() {
        Saab95 saab = new Saab95(0, 0);
        saab.gas(0.5);
        saab.brake(0.25);
        assertEquals(0.3125, saab.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void saab_should_have_correct_speed_after_gassing() {
        Saab95 saab = new Saab95(0, 0);
        saab.gas(0.75);
        assertEquals(0.9375, saab.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void saab_should_throw_exception_when_given_negative_argument() {
        Saab95 saab = new Saab95(0, 0);
        assertThrows(IllegalArgumentException.class,
            ()-> {
                saab.gas(-1);
            });
    }

    @Test
    public void saab_should_not_be_able_to_decrement_speed_under_zero() {
        Saab95 saab = new Saab95(0, 0);
        saab.gas(1);
        for(int i = 0; i <= 100; i++){
            saab.brake(1);
        }
        assertEquals(0, saab.getCurrentSpeed(), 0.00001 );
    }

}
