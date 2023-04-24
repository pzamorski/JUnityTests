package org.junittesty.electricity;

import java.util.Calendar;

public class ElectricityMeter {

    TariffProvaider tp;
    private float kwh = 0.0f;
    private int centsForKwh = 0;
    private boolean tariffOn = false;
    private float khwThariff = 0;
    private int centsForThariff = 0;
    private int eletriciryTariffStartHour = 0;
    private int eletriciryTariffEndHour = 0;

    public ElectricityMeter() {
        tp = () -> {//kod jałowy
            Calendar rightNow = Calendar.getInstance();
            int hour = rightNow.get(Calendar.HOUR_OF_DAY);
            return hour > eletriciryTariffStartHour && hour < eletriciryTariffEndHour;
        };
    }


    public ElectricityMeter(TariffProvaider tp) {
        this.tp = tp;
    }

    public void addHwh(float kwhToAdd) {
        if (isTariffNow()) {
            khwThariff += kwhToAdd;
        } else {
            kwh += kwhToAdd;
        }
    }

    private boolean isTariffNow() {
        return tp.isTariffNow();

    }

    /**
     * @return how much more expensive is normal price comparing to tariff in percentages
     */

    public int getHowMoreExpensiveNormalIs() {
        return (centsForKwh * 100 / centsForThariff) - 100;
    }

    void setCentsForKwh(int centsForKwh) {
        this.centsForKwh = centsForKwh;
    }

    void setTariffOn(boolean tariffOn) {
        this.tariffOn = tariffOn;
    }

    void setCentsForThariff(int centsForThariff) {
        this.centsForThariff = centsForThariff;
    }

    void setEletriciryTariffStartHour(int eletriciryTariffStartHour) {
        this.eletriciryTariffStartHour = eletriciryTariffStartHour;
    }

    void setEletriciryTariffEndHour(int eletriciryTariffEndHour) {
        this.eletriciryTariffEndHour = eletriciryTariffEndHour;
    }

    public float getKwh() {
        return kwh;
    }

    public float getKhwThariff() {
        return khwThariff;
    }

    public void reset() {

        this.kwh = 0.0f;
        this.centsForKwh = 0;
        this.tariffOn = false;
        this.khwThariff = 0;
        this.centsForThariff = 0;
        this.eletriciryTariffStartHour = 0;
        this.eletriciryTariffEndHour = 0;

    }
}
