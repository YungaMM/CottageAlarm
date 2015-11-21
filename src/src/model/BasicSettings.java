package src.model;

public class BasicSettings {
    private String alarmPhone; //Номер телефона сигнализации

    private String[] userPhones; //Номера телефонов забитые в сигнадлизации

    private String dateInDevice; //дата установленная в устройстве

    private String timeInDevice; //время в устройстве

    public BasicSettings(final String alarmPhone,
                         final String[] userPhones,
                         final String dateInDevice,
                         final String timeInDevice) {
        this.alarmPhone = alarmPhone;
        this.userPhones = userPhones;
        this.dateInDevice = dateInDevice;
        this.timeInDevice = timeInDevice;
    }

    public String getAlarmPhone() {
        return alarmPhone;
    }

    public void setAlarmPhone(final String alarmPhone) {
        this.alarmPhone = alarmPhone;
    }

    public String[] getUserPhones() {
        return userPhones;
    }


    public void setUserPhones(final String[] userPhones) {
        this.userPhones = userPhones;
    }
    public String getUserPhone(final int count) {
        return userPhones[count];
    }

    public void setUserPhone(final int count, final String userPhones) {
        this.userPhones[count] = userPhones;
    }

    public String getDateInDevice() {
        return dateInDevice;
    }

    public void setDateInDevice(final String dateInDevice) {
        this.dateInDevice = dateInDevice;
    }

    public String getTimeInDevice() {
        return timeInDevice;
    }

    public void setTimeInDevice(String timeInDevice) {
        this.timeInDevice = timeInDevice;
    }
}
