package src.controllers;

import src.model.*;
import tests.AdvanceSharedPreferences;

public class DevicesAlarm {
    private BasicSettings basicSettings; //номер тел. сигнализ., номера тел. юзера, дата устройства

    private Temperature temperature; //Температура

    private Battery battery; //Заряд батареи

    private Relay[] relays;  //список реле

    private Energy energy; //электроэнергия вкл/выкл

    //устанавливаем DevicesAlarm в соответствии с сохраненными установками
    // в Андроид конструктор переделать чтобы считывал установки из SharedPreferences Андроида
    public DevicesAlarm() {
        this.basicSettings = new BasicSettings(AdvanceSharedPreferences.getAlarmPhone(),
                AdvanceSharedPreferences.getUserPhones(),
                AdvanceSharedPreferences.getDateInDevice(),
                AdvanceSharedPreferences.getTimeInDevice());
        this.temperature = new Temperature(AdvanceSharedPreferences.getTemperature());
        this.battery = new Battery(AdvanceSharedPreferences.getBattery());
        this.relays = AdvanceSharedPreferences.getRelays();
        this.energy = new Energy(AdvanceSharedPreferences.isEnergy());
    }

    public BasicSettings getBasicSettings() {
        return basicSettings;
    }

    public void setBasicSettings(BasicSettings basicSettings) {
        this.basicSettings = basicSettings;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Relay[] getRelays() {
        return relays;
    }

    public Relay getRelay(final int count) {
            return relays[count - 1];
    }

    public void setRelays(Relay[] relays) {
        this.relays = relays;
    }

    public Energy getEnergy() {
        return energy;
    }

    public void setEnergy(Energy energy) {
        this.energy = energy;
    }
}
