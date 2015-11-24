import src.controllers.CommandsAlarm;
import src.controllers.DevicesAlarm;
import src.model.Relay;
import tests.AdvanceSharedPreferences;
import tests.FileIO;

import java.io.FileNotFoundException;

public class TestCommandsAlarm {
    public static void main(String[] args) throws FileNotFoundException {
        //считываем все параметры из файла
        String textFile = FileIO.loadFile(AdvanceSharedPreferences.PATH_AND_NAME_FILE_PREF);
        AdvanceSharedPreferences.loadPreferences(textFile);

        DevicesAlarm deviceAlarm = new DevicesAlarm();
        Relay relay[] = deviceAlarm.getRelays();

        String outSms = CommandsAlarm.outRelaySms(relay[1]);
        System.out.println(outSms);

    }


}
