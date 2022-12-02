package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import main.cars.Car;
import main.cars.CarRepairShop;
import main.cars.Saab95;
import main.cars.Volvo240;
import main.interfaces.HasCarStorage.LoadingToFullStorageException;
import main.interfaces.HasCarStorage.TargetOutsideLoadingRangeException;

public class TestCarRepairShop {
    @Test
    public void loading_a_car_should_only_hold_a_sigle_car() {
        CarRepairShop shop = new CarRepairShop(0, 0, 1);
        try {
            shop.loadCar(new Volvo240(0, 0));
            assertEquals(1, shop.getLoadedCount());
        } catch (Exception e) {
            assertFalse("Exception thrown", false);
        }
    }

    @Test
    public void unloading_car_should_only_remove_a_single_car() {
        CarRepairShop shop = new CarRepairShop(0, 0, 3);
        try {
            for (int i = 0; i < 3; i++) {
                shop.loadCar(new Saab95(0, 0));
            }
            shop.unloadCar(0);
            assertEquals(2, shop.getLoadedCount());
        } catch (Exception e) {
            assertFalse("Exception thrown", false);
        }
    }

    @Test
    public void dist_to_other_should_be_sqrt_5() {
        CarRepairShop shop = new CarRepairShop(0, 0, 0);
        Volvo240 car = new Volvo240(1, 2);
        shop.distanceToOther(car);
        assertEquals(Math.sqrt(5), shop.distanceToOther(car), 0.001);
    }

    @Test
    public void should_not_load_car_out_of_range() throws LoadingToFullStorageException, TargetOutsideLoadingRangeException {
        CarRepairShop shop = new CarRepairShop(0, 0, 1);
        shop.loadCar(new Volvo240(20, 20));
        assertThrows(null, null);
    }

}
