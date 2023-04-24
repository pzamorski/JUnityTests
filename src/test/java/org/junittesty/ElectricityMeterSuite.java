package org.junittesty;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junittesty.electricity.ElectricityMeter;
import org.junittesty.electricity.ElectricityMeterTest;
import org.junittesty.electricity.TwoElectricityMeterTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ElectricityMeterTest.class,
        ElectricityMeterTest.class,
        TwoElectricityMeterTest.class})
public class ElectricityMeterSuite {
}
