package org.junittesty.electricity;

import org.junit.*;

public class ExistElectricityMeterTest {

    private static ElectricityMeter electricityMeter;

    @BeforeClass
    public static void init() {
//        Computation expensive steps
        ExistElectricityMeterTest.electricityMeter = new ElectricityMeter();
    }

    @Before
    public void setUp() {
        //assure deterministic start environment
        electricityMeter.reset();
    }

    @AfterClass
    public static void release(){

    }
    @After
    public void tearDown(){

    }

    @Test
    public void addHwh_newMeter_properAddition1() {
        electricityMeter.addHwh(1);
        Assert.assertTrue(electricityMeter.getKwh() == 1);
    }

    @Ignore("Not implemented yet:):)")
    @Test
    public void addHwh_newMeter_properAddition2() {
        electricityMeter.addHwh(1);
        electricityMeter.addHwh(4);
        Assert.assertTrue("Additional 1 and 4 shoud be 5", electricityMeter.getKwh() == 2);
    }

    @Test
    public void addHwh_newMeter_properAddition5() {
        electricityMeter.addHwh(1);
        electricityMeter.addHwh(4);
        electricityMeter.addHwh(4);
        electricityMeter.addHwh(4);
        electricityMeter.addHwh(4);
        Assert.assertTrue(electricityMeter.getKwh() == 17);
    }

    //G-W-T preferred way to write tests
    @Test
    public void givenNewMeterWhenFirsAddionTheProperCounter() {
        //Give/Arrange
        ElectricityMeter electricityMeter = new ElectricityMeter();
        //When/Act
        electricityMeter.addHwh(1);
        electricityMeter.addHwh(4);
        electricityMeter.addHwh(4);
        electricityMeter.addHwh(4);
        electricityMeter.addHwh(4);
        //Then/Assert
        Assert.assertTrue(electricityMeter.getKwh() == 17);
    }


    @Test(expected = ArithmeticException.class)
    public void getHowMoreExpensiveNormalIs() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.setCentsForKwh(90);
        electricityMeter.getHowMoreExpensiveNormalIs();
    }


}