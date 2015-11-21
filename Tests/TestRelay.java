import src.controllers.DevicesAlarm;
import src.controllers.ProcessingSMS;
import src.model.Relay;
import tests.AdvanceSharedPreferences;
import tests.FileIO;

import java.io.FileNotFoundException;

public class TestRelay {
    public static void main(String[] args) throws FileNotFoundException {
        String str;

        AdvanceSharedPreferences advSharedPref = new AdvanceSharedPreferences();
        //считываем все параметры из файла
        String textFile = FileIO.loadFile(advSharedPref.PATH_AND_NAME_FILE_PREF);
        advSharedPref.loadPreferences(textFile);

        //Создаем Alarm
 //       DevicesAlarm da = new DevicesAlarm();

 //       Relay[] relays = advSharedPref.getRelays();

      //  printRelays(relays);

//        da.setRelay(0, true,",00-00,0");
//        str = da.getRelayFull(0).textRelayCommand(da.getRelayFull(1));
//        //str = relays[0].relayOn(0, ",00-00,0");
//        System.out.println("Реле 1 -" + str);

//        str = relays[3].relayOff(3);
//        str = relays[3].relayOn(3, ",00-00,0");
//        System.out.println("Реле 4 -" + str);
//
//        str = relays[4].relayOff(4);
//        relays[4].getCount();
//        str = relays[0].relayOn(0, ",00-00,0");
//        System.out.println("Реле 5 -" + str);
//
//        str = String.valueOf(relays[2].isSwitchOnOff());
//        System.out.println("Реле 3 -" + str);

        //printRelays(relays);
        DevicesAlarm da = new DevicesAlarm();
        Relay[] relays = da.getRelays();

        String textSms = FileIO.loadSms();

        ProcessingSMS processingSMS = new ProcessingSMS(da);
        processingSMS.checkSMS(textSms);
        printRelays(relays);

        String  comRelay = relays[4].commandForSms();
        System.out.println(comRelay);


      FileIO.saveFile(AdvanceSharedPreferences.PATH_AND_NAME_FILE_PREF, advSharedPref.stringSettings(da));

    }

    public static void printRelays(Relay[] relays) {
        String str2;
        System.out.println("****************************");
        for (int i = 0; i < relays.length; i++) {
            str2 = String.valueOf(relays[i].isSwitchOnOff());
            System.out.println("Реле " + (i+1)+" -" + str2);
        }
        System.out.println("****************************");

    }
}
