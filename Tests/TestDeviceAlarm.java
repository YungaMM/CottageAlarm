import src.controllers.DevicesAlarm;
import src.model.*;
import tests.AdvanceSharedPreferences;
import tests.FileIO;

import java.io.FileNotFoundException;

public class TestDeviceAlarm {
    public static void main(String[] args) throws FileNotFoundException {
        //считываем все параметры из файла
        AdvanceSharedPreferences advSharedPreff = new AdvanceSharedPreferences();
        String textFile = FileIO.loadFile(advSharedPreff.PATH_AND_NAME_FILE_PREF);
        advSharedPreff.loadPreferences(textFile);

        String str;
//        Relay[] relays = advSharedPreff.getRelays();

        //Открываем Alarm
        DevicesAlarm deviceAlarm = new DevicesAlarm();



        //**************** Вносим все возможные изменения в DevicesAlarm

        // Проверяем BasicSettings
        BasicSettings basicSett = deviceAlarm.getBasicSettings();

        basicSett.setAlarmPhone("Alarm phone");
        basicSett.setUserPhone(0, "+79032045211");
        basicSett.setUserPhone(1, "+86332542");
        basicSett.setDateInDevice("25.01.15");
        basicSett.setTimeInDevice("12:45");

        // Проверяем аккумулятор
        Battery battery = deviceAlarm.getBattery();

        battery.setBattery(20.0);
        //str = deviceAlarm.getBatteryString();
        System.out.println(deviceAlarm.getBattery().getBattery());

        // Проверяем реле
       Relay[] relays = deviceAlarm.getRelays();

        relays[0].setSwitchOnOff(false);
        str = Relay.textRelayCommand(relays[0]);
        //str = Relay.textRelayCommand(deviceAlarm.getRelayFull(0));
        System.out.println("Реле 1 - " + str);
        System.out.println("***************************************");

//        deviceAlarm.setSwitchOnOff(1,true);
//        str = Relay.textRelayCommand(deviceAlarm.getRelayFull(1));
//        System.out.println("Реле 2 - " + str);
//        System.out.println("***************************************");

        relays[2].setSwitchOnOff(true, ",00-00,0");
        str = relays[2].textRelayCommand();
        System.out.println("Реле 3 - " + str);
        System.out.println("***************************************");

        // Проверяем температуру
        Temperature temperature = deviceAlarm.getTemperature();

        temperature.setTemperature(25);

        //Проверяем Energy
        Energy energy = deviceAlarm.getEnergy();

        energy.setEnergy(true);

        //Сохраняем изменения
        FileIO.saveFile(advSharedPreff.PATH_AND_NAME_FILE_PREF, advSharedPreff.stringSettings(deviceAlarm));

        System.out.println(advSharedPreff.stringSettings(deviceAlarm));

    }
}
