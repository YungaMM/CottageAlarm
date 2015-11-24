package src.controllers;

import org.jetbrains.annotations.NotNull;
import src.model.BasicSettings;
import src.model.Relay;

public class SmsCommandsAlarm {
    private String command;

    //метод возвращает команду Реле для СМС
    @NotNull
    public static String setRelay(Relay relay) {
        StringBuilder sb = new StringBuilder();

        sb.append("#R");
        sb.append(relay.getCount() + 1);
        sb.append("=");
        sb.append(relay.isSwitchOnOff() ? "1" : "0");
        if (!relay.getOption().equals("")) {
            sb.append(",");
            sb.append(relay.getOption());
            sb.append(",0");
        }
        return sb.toString();
    }

    public static String setTimeDate(BasicSettings basicSettings){
        return "V#D=" + basicSettings.getTimeInDevice() + "," + basicSettings.getDateInDevice();
    }

    public static String setPhoneSetting(final int countPhone){
        return "";
    }
    public static String queryRele(final String command){
        return command.equals("R2") ? "?R2" : ""; //вставить команду запроса первых реле
    }

    public static String queryFull(){
        return  "V?Z";
    }

    public static String queryPhone(){
        return "?4";
    }

    public static String queryDeviceStatus(){ return "?5";}
}
