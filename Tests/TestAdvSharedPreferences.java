import src.controllers.DevicesAlarm;
import tests.AdvanceSharedPreferences;
import tests.FileIO;

import java.io.FileNotFoundException;

public class TestAdvSharedPreferences {

    public static void main(String[] args) throws FileNotFoundException {
        AdvanceSharedPreferences advSharedPreff = new AdvanceSharedPreferences();
        //считываем все параметры из файла
        String textFile = FileIO.loadFile(advSharedPreff.PATH_AND_NAME_FILE_PREF);
        advSharedPreff.loadPreferences(textFile);

        //Открываем Alarm
        DevicesAlarm da = new DevicesAlarm();

        //da.setAllSettings(da.getBasicSettings() , da.getBattery(), relays);
        FileIO.saveFile(advSharedPreff.PATH_AND_NAME_FILE_PREF, advSharedPreff.stringSettings(da));

    }
}
