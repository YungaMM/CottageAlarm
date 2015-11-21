package src.model;

public class Battery {

    private  double battery; //пишем заряд батареи

    public Battery(final double battery) {
        this.battery = battery;
    }

    public  double getBattery() {
        return battery;
    }

    public  void setBattery(final double battery) {
        this.battery = battery;
    }
}
