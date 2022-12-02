package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.cars.CarRepairShop;
import main.cars.ScaniaP340;
import main.cars.Volvo240;

public class TestCarRepairShop {
    @Test
    public void loading_one_car_should_only_contain_single_car() {
        CarRepairShop shop = new CarRepairShop(0, 0, 1);
        try {
            shop.loadCar(new Volvo240(0, 0));
            assertEquals(1, shop.getLoadCount());
        } catch (Exception e) {}
    }

    @Test
    public void unloading_car_should_leave_empty_storage() {
        CarRepairShop shop = new CarRepairShop(0, 0, 1);
        try {
            shop.loadCar(new ScaniaP340(0, 0));
            shop.unloadCar(0);
            assertEquals(0, shop.getLoadCount());
        } catch (Exception e) {}
    }
}
