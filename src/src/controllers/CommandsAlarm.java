package src.controllers;

import org.jetbrains.annotations.NotNull;
import src.model.BasicSettings;
import src.model.Relay;

public class CommandsAlarm {
    private String command;

    //метод возвращает команду Реле для СМС
    @NotNull
    public static String outRelaySms(Relay relay) {
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

    @NotNull
    public static String outSetTimeDate(BasicSettings basicSettings){
        return "V#D=" + basicSettings.getTimeInDevice() + "," + basicSettings.getDateInDevice();
    }

}
