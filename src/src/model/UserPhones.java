package src.model;


public class UserPhones {
    private String number;
    private String[] option ={"0","0","0","0","0","0","0"};

    public UserPhones(String number, String[] option) {
        this.number = number;
        this.option = option;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String[] getOption() {
        return option;
    }

    public void setOption(String[] option) {
        this.option = option;
    }
}

