package org.junittesty.electricity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class TariffElectricityMeterTest {

    ElectricityMeter electricityMeter;
    TariffProvaider tp;

    @Before
    public void setUp(){
        tp = Mockito.mock(TariffProvaider.class);
        electricityMeter = new ElectricityMeter(tp);
        electricityMeter.setTariffOn(true);
        electricityMeter.setEletriciryTariffStartHour(12);
        electricityMeter.setEletriciryTariffEndHour(14);
    }

    @Test
    public void  GivenOnTariffWhenKwhAdditionalThenCounterTariffIsIncrresed(){
        //Given
        // TODO: 2023-04-25 mock isTariffNow!
        Mockito.when(tp.isTariffNow()).thenReturn(true);
        //When
        electricityMeter.addHwh(100);
        //Then
        Assert.assertEquals(100,electricityMeter.getKhwThariff(),0.01);


    }

    @Test
    public void  GivenNotTariffWhenKwhAdditionalThenCounterTariffIsIncrresed(){
        //Given
        // TODO: 2023-04-25 mock is NO Tariff
        Mockito.when(tp.isTariffNow()).thenReturn(false);
        //When
        electricityMeter.addHwh(100);
        //Then
        Assert.assertEquals(100,electricityMeter.getKwh(),0.01);


    }
}
