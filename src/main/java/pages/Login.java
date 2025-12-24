package pages;

public class Login {
    private String name;
    private String surname;
    private String address;
    private String metroStation;
    private String telephoneNumber;

    public Login(String name, String surname, String address, String metroStation, String telephoneNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }
}
