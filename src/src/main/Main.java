package src.main;

import tests.AdvanceSharedPreferences;

import java.io.FileNotFoundException;

public class Main {

    public static final String TEST_STRING = "Test main public static final String";

    public static void main(String[] args) throws FileNotFoundException {

        AdvanceSharedPreferences tsp = new AdvanceSharedPreferences();
        //считываем все параметры из файла
        AdvanceSharedPreferences.loadPreferences(tsp.PATH_AND_NAME_FILE_PREF);
        //устанавливаем считанные параметры в конструкторе DevicesAlarm()
       // DevicesAlarm da = new DevicesAlarm();

        System.out.println("****");

        //сохраняем все параметры в файл
      //  AdvanceSharedPreferences.savePreferences(tsp.PATH_AND_NAME_FILE_PREF, tsp.stringSettings(da));
    }
}
