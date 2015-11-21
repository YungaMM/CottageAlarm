import src.controllers.DevicesAlarm;
import src.controllers.ProcessingSMS;
import tests.FileIO;
import tests.AdvanceSharedPreferences;

import java.io.FileNotFoundException;

public class TestReceiveSms {

    public static void main(String[] args) throws FileNotFoundException {
        //считываем все параметры из файла
        AdvanceSharedPreferences advSharedPreff = new AdvanceSharedPreferences();
        String textFile = FileIO.loadFile(advSharedPreff.PATH_AND_NAME_FILE_PREF);
        advSharedPreff.loadPreferences(textFile);

        //Открываем Alarm
        DevicesAlarm deviceAlarm = new DevicesAlarm();

        String textSms = FileIO.loadSms();

        ProcessingSMS processingSMS = new ProcessingSMS(deviceAlarm);
        processingSMS.checkSMS(textSms);

        System.out.println(advSharedPreff.stringSettings(deviceAlarm));

        //Сохраняем изменения
        String sett = advSharedPreff.stringSettings(deviceAlarm);
        FileIO.saveFile(advSharedPreff.PATH_AND_NAME_FILE_PREF, sett);
    }
}
