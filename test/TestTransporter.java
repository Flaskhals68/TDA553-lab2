package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import main.cars.Car;

import main.cars.ScaniaP340;
import main.cars.Transporter;
import main.cars.Volvo240;
import main.interfaces.HasCarStorage.LoadingToFullBedException;
import main.interfaces.HasCarStorage.RampNotExtendedException;
import main.interfaces.HasCarStorage.TargetOutsideLoadingRangeException;
import main.interfaces.HasCarStorage.UnloadingFromEmptyBedException;
import main.misc.DPoint;

public class TestTransporter {
    @Test
    public void should_not_move_when_bed_is_down(){
        Transporter transporter = new Transporter(0, 0);
        transporter.lower();
        transporter.gas(1);
        assertEquals(0.0, transporter.getCurrentSpeed(), 0.0000);

    }

    @Test
    public void should_not_load_car_if_bed_not_extended() throws LoadingToFullBedException, RampNotExtendedException, TargetOutsideLoadingRangeException{
        Transporter transporter = new Transporter(0, 0);
        Volvo240 volvo = new Volvo240(0, 0);
        assertThrows(RampNotExtendedException.class,
            ()-> {
                transporter.loadCar(volvo);
            });
        
    }

    @Test
    public void should_not_load_car_if_car_out_of_range(){
        Transporter transporter = new Transporter(0, 0);
        Volvo240 volvo = new Volvo240(100, 100);
        transporter.raise();
        assertThrows(TargetOutsideLoadingRangeException.class,
            ()-> {
                transporter.loadCar(volvo);
            });
    }

    @Test
    public void should_not_load_if_storage_is_full_to_the_brim() throws LoadingToFullBedException, RampNotExtendedException, TargetOutsideLoadingRangeException{
        Transporter transporter = new Transporter(0, 0);
        transporter.raise();
        Volvo240 volvo;
        for(int i = 0; i <= 8; i++){
            volvo = new Volvo240(0, 0);
            transporter.loadCar(volvo);

        }

        Volvo240 volvo2 = new Volvo240(0, 0);
        
        assertThrows(LoadingToFullBedException.class,
            ()-> {
                transporter.loadCar(volvo2);
            });
    }

    @Test
    public void should_not_unload_if_empty() throws UnloadingFromEmptyBedException, RampNotExtendedException{
        Transporter transporter = new Transporter(0, 0);
        transporter.raise();
        

        assertThrows(UnloadingFromEmptyBedException.class,
            ()-> {
                transporter.unloadCar();
            });
    }
}
