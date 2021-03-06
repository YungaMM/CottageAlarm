package tests;

import org.jetbrains.annotations.NotNull;
import src.controllers.DevicesAlarm;
import src.model.*;

import java.io.*;

public class AdvanceSharedPreferences {
    public static final String PATH_AND_NAME_FILE_PREF = "./settings.txt";
    public static final int COUNT_USER_PHONES = 4;

    //************************* Alarm Devices  *************************
    private static String ALARM_PHONE; //Номер телефона сигнализации
    private static UserPhones[] USER_PHONES = new UserPhones[COUNT_USER_PHONES];//Номера телефонов забитые в сигнадлизации
    private static String DATE_IN_DEVICE; //дата установленная в устройстве
    private static String TIME_IN_DEVICE; //дата установленная в устройстве

    private static int TEMPERATURE; //Температура
    private static double BATTERY; //Заряд батареи
    private static boolean ENERGY; //электроэнергия вкл/выкл

    private static int COUNT_RELAY = 6; //количество реле
    private static boolean[] RELAY = new boolean[COUNT_RELAY]; //список реле вкл/выкл
    private static String OPTION_RELAY;
   // private static int COUNT_RELAY;

    // метод создает String с переменными для записи в файл
    @NotNull
    public final String stringSettings(DevicesAlarm da) {
        BasicSettings basicSett = da.getBasicSettings();
        Temperature tmpr = da.getTemperature();
        Battery batt = da.getBattery();
        Relay[] relay = da.getRelays();
        Energy energy = da.getEnergy();

        StringBuilder sb = new StringBuilder();

        sb.append("alarmPhone=" + basicSett.getAlarmPhone() + "\n");
        for (int i = 0; i < basicSett.getUserPhones().length; i++) {
            sb.append("userPhones[" + i + "]=" + basicSett.getUserPhoneNumber(i) + "\n");
        }
        sb.append("timeInDevice=" + basicSett.getTimeInDevice() + "\n");
        sb.append("dateInDevice=" + basicSett.getDateInDevice() + "\n");
        sb.append("temperature=" + tmpr.getTemperature() + "\n");
        sb.append("battery=" + batt.getBattery() + "\n");
        sb.append("energy=" + energy.isEnergy() + "\n");
        for (Relay aRelay : relay) {
            sb.append("relay[" + aRelay.getCount() + "]="
                    + aRelay.isSwitchOnOff()
                    + aRelay.getOption() + "\n");
        }

        return sb.toString();
    }


    //метод открывает файл с настройками и устанавливает основные переменные
    public static void loadPreferences(String fileText) throws FileNotFoundException {
        //String s = FileIO.loadFile(fileText);

        int start = 0;
        int end = fileText.indexOf("\n");

        while (end > 0) {
            checkStringPreferences(fileText.substring(start, end));
            start = end + 1;
            end = fileText.indexOf("\n", start);
        }
    }

    //Проверяем полученную строку и устанавливаем переменные
    private static void checkStringPreferences(String s) {
        UserPhones phone = new UserPhones("");

        int i = s.indexOf("=") + 1;
        switch (s.substring(0, i)) {
            case "alarmPhone=":
                ALARM_PHONE = s.substring(i);
                break;
            case "userPhones[0]=":
                phone.setPhone(s.substring(i));
                USER_PHONES[0] = phone;
               break;
            case "userPhones[1]=":
                phone.setPhone(s.substring(i));
                USER_PHONES[1] = phone;
                break;
            case "userPhones[2]=":
                phone.setPhone(s.substring(i));
                USER_PHONES[2] = phone;
                break;
            case "userPhones[3]=":
                phone.setPhone(s.substring(i));
                USER_PHONES[3] = phone;
                break;
            case "dateInDevice=":
                DATE_IN_DEVICE = s.substring(i);
                break;
            case "timeInDevice=":
                TIME_IN_DEVICE = s.substring(i);
                break;
            case "temperature=":
                TEMPERATURE = Integer.valueOf(s.substring(i));
                break;
            case "battery=":
                BATTERY = Double.valueOf(s.substring(i));
                break;
            case "energy=":
                ENERGY = s.substring(i).equals("true") ? true : false;
                break;
            case "relay[1]=":
                checkRelayString(s, 0);
                break;
            case "relay[2]=":
                checkRelayString(s, 1);
                break;
            case "relay[3]=":
                checkRelayString(s, 2);
                break;
            case "relay[4]=":
                checkRelayString(s, 3);
                break;
            case "relay[5]=":
                checkRelayString(s, 4);
                break;
            case "relay[6]=":
                checkRelayString(s, 5);
                break;
            default:
                break;
        }
    }
//переделать а то опции перезаписываются с каждым новым прочитанным реле
    // надо делать переменную типа Relay
    private static void checkRelayString(final String s, final int i) {
        if (s.indexOf(",") > 0) {
            RELAY[i] = s.substring(s.indexOf("=") + 1, s.indexOf(",")).equals("true") ? true : false;
            OPTION_RELAY = s.substring(s.indexOf(","));
            COUNT_RELAY = i;
        } else {
            RELAY[i] = s.substring(s.indexOf("=") + 1).equals("true") ? true : false;
            OPTION_RELAY = "";
            COUNT_RELAY = i;
        }
    }

    //************* Геттеры *****************************************

    public static String getAlarmPhone() {
        return ALARM_PHONE;
    }

    public static UserPhones[] getUserPhones() {
        return USER_PHONES;
    }

    public static String getDateInDevice() {
        return DATE_IN_DEVICE;
    }

    public static int getTemperature() {
        return TEMPERATURE;
    }

    public static double getBattery() {
        return BATTERY;
    }

    public static Relay[] getRelays() {
        Relay[] result = new Relay[RELAY.length];
        for (int i = 0; i < RELAY.length; i++) {
            result[i] = new Relay(i, RELAY[i], "");
           // result[i] = RELAY[i];//переделать а то получается возвращаем реле без параметров
       }
        return result;
    }

    public static boolean isEnergy() {
        return ENERGY;
    }

    public static String getTimeInDevice() {
        return TIME_IN_DEVICE;
    }
}
