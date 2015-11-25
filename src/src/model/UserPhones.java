package src.model;


public class UserPhones {
    private String phone;
    private String[] option ={"1","1","1","1","1","1","1"};

    public UserPhones (final String phone){
        this.phone = phone;
    }
    public UserPhones(final String phone, final String[] option) {
        this.phone = phone;
        this.option = option;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String[] getOption() {
        return option;
    }

    public void setOption(String[] option) {
        this.option = option;
    }
}

