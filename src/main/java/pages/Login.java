package pages;

//класс регистрации аренды самоката
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

    //Имя пользователя
    public String getName() {
        return name;
    }

    //Фамилия пользователя
    public String getSurname() {
        return surname;
    }

    //Адрес доставки заказа
    public String getAddress() {
        return address;
    }

    //Станция метро
    public String getMetroStation() {
        return metroStation;
    }

    //Номер телефона пользователя
    public String getTelephoneNumber() {
        return telephoneNumber;
    }
}
