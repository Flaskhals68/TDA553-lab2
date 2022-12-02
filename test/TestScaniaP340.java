
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import main.cars.Car;

import main.cars.ScaniaP340;

public class TestScaniaP340 {

    @Test
    public void scania_can_raise_if_standing_still(){
        ScaniaP340 scania = new ScaniaP340(0, 0);
        scania.raise();
        assertEquals(10, scania.getAngle());

    }

    @Test
    public void can_lower_if_standing_still(){
        ScaniaP340 scania = new ScaniaP340(0, 0);
        scania.raise();
        scania.lower();
        assertEquals(0, scania.getAngle());

    }

    @Test
    public void cant_gas_if_angle_is_not_zero(){
        ScaniaP340 scania = new ScaniaP340(0, 0);
        scania.raise();
        scania.gas(1);
        assertEquals(0.0, scania.getCurrentSpeed(), 0.000);
    }

    @Test
    public void cant_raise_if_current_speed_above_zero(){
        ScaniaP340 scania = new ScaniaP340(0, 0);
        scania.gas(1);
        scania.raise();
        assertEquals(0, scania.getAngle());
    }

    @Test
    public void cant_lower_below_0_degrees(){
        ScaniaP340 scania = new ScaniaP340(0, 0);
        scania.lower();
        assertEquals(0, scania.getAngle());
    }
    
    @Test
    public void cant_raise_above_70_degrees(){
        ScaniaP340 scania = new ScaniaP340(0, 0);
        for (int i = 0; i <= 10; i++){
            scania.raise();
        }

    }
}
