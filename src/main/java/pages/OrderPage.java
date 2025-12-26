package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Класс страницы оформления заказа самоката
public class OrderPage {

    private WebDriver driver;

    //Поле "Имя"
    private By fieldName = By.xpath(".//input[@placeholder='* Имя']");

    //Поле "Фамилия"
    private By fieldSurname = By.xpath(".//input[@placeholder='* Фамилия']");

    //Поле "Адрес: куда привести заказ"
    private By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Поле "Станция метро"
    private By fieldMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");

    //Раскрывающийся список станций метро
    private By stationList = By.cssSelector(".select-search__select");

    //Поле "Телефон: на него позвонит курьер"
    private By fieldTelephoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка "Далее"
    private By nextBtn = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    //Поле "Когда привезти самокат"
    private By fieldDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Кнопка в календаре при выборе даты аренды (дата - 17.12.25)
    private By calendarDate = By.xpath(".//div[@aria-label='Choose среда, 17-е декабря 2025 г.']");

    //Поле "Срок аренды"
    private By fieldLeasing = By.className("Dropdown-placeholder");

    //Раскрывающийся список "Срок аренды" (двое суток)
    private By numberOfDays = By.xpath(".//div[text()='двое суток']");

    //Чекбокс "Цвет самоката" (черный жемчуг)
    private By checkboxColorScooter = By.id("black");

    //Кнопка "Заказать"
    private By orderBtn = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text() = 'Заказать']");

    //Кнопка "Да" во всплывающем окне "Хотите оформить заказ?"
    private By btnYes = By.xpath(".//button[text() = 'Да']");

    //Сообщение об успешном оформлении заказа
    private By messageSuccessfulOrder = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ']");

    //Логотип "Самокат"
    private By scooterLogo = By.className("Header_LogoScooter__3lsAR");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Нажимаем на поле "Имя"
    public void clickFieldName() {
        driver.findElement(fieldName).click();
    }

    //Вводим имя в поле "Имя"
    public void inputFieldName(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }

    //Нажимаем на поле "Фамилия"
    public void clickFieldSurname() {
        driver.findElement(fieldSurname).click();
    }

    //Вводим фамилию в поле "Фамилия"
    public void inputFieldSurname(String surname) {
        driver.findElement(fieldSurname).sendKeys(surname);
    }

    //Нажимаем на поле "Адрес: куда привести заказ"
    public void clickFieldAddress() {
        driver.findElement(fieldAddress).click();
    }

    //Вводим адрес доставки в поле "Адрес: куда привести заказ"
    public void inputFieldAddress(String address) {
        driver.findElement(fieldAddress).sendKeys(address);
    }

    //Нажимаем на поле "Станция метро"
    public void clickFieldMetroStation() {
        driver.findElement(fieldMetroStation).click();
    }

    //Вводим станцию метро в поле "Станция метро"
    public void inputFieldMetroStation(String metroStation) {
        driver.findElement(fieldMetroStation).sendKeys(metroStation);
    }

    //Нажимаем на станцию метро в раскрывающемся списке
    public void clickFieldStationList() {
        driver.findElement(stationList).click();
    }

    //Нажимаем на поле "Телефон: на него позвонит курьер"
    public void clickFieldTelephoneNumber() {
        driver.findElement(fieldTelephoneNumber).click();
    }

    //Вводим номер телефона в поле "Телефон: на него позвонит курьер"
    public void inputFieldTelephoneNumber(String telephoneNumber) {
        driver.findElement(fieldTelephoneNumber).sendKeys(telephoneNumber);
    }

    //Нажимаем на кнопку "Далее"
    public void clickNextBtn() {
        driver.findElement(nextBtn).click();
    }

    //Объединение методов для заполнения информации в первую форму аренды самоката
    public void fillFirstForm(String name, String surname, String address, String metroStation, String telephoneNumber) {
        inputFieldName(name);
        clickFieldName();
        inputFieldSurname(surname);
        clickFieldSurname();
        inputFieldAddress(address);
        clickFieldAddress();
        inputFieldMetroStation(metroStation);
        clickFieldStationList();
        clickFieldMetroStation();
        inputFieldTelephoneNumber(telephoneNumber);
        clickFieldTelephoneNumber();
        clickNextBtn();
    }

    //Нажимаем на поле "Когда привести самокат"
    public void clickFieldDate() {
        driver.findElement(fieldDate).click();
    }

    //Нажимаем на дату аренды (дата - 17.12.25)
    public void clickCalendarDate() {
        driver.findElement(calendarDate).click();
    }

    //Нажимаем на поле "Срок аренды"
    public void clickFieldLeasing() {
        driver.findElement(fieldLeasing).click();
    }

    //Нажимаем в раскрывающемся списке на кол-во суток аренды (двое суток)
    public void clickNumberOfDays() {
        driver.findElement(numberOfDays).click();
    }

    //Отмечаем выбор цвета самоката на чекбоксе (чёрный жемчуг)
    public void clickCheckboxColorScooter() {
        driver.findElement(checkboxColorScooter).click();
    }

    //Нажимаем на кнопку "Заказать", расположенную под формой аренды самоката
    public void clickOrderBtn() {
        driver.findElement(orderBtn).click();
    }

    //Объединение методов для заполнения информации во вторую форму аренды самоката
    public void fillSecondForm() {
        clickFieldDate();
        clickCalendarDate();
        clickFieldLeasing();
        clickNumberOfDays();
        clickCheckboxColorScooter();
        clickOrderBtn();
    }

    //Ожидаем появление окна "Хотите оформить заказ?", а точнее кнопки "Да" в данном окне
    public void waitBtnYes() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(btnYes));
    }

    //Нажимаем на кнопку "Да"
    public void clickBtnYes() {
        driver.findElement(btnYes).click();
    }

    //Ожидаем появление окна "Заказ оформлен", а точнее сообщение об успешном заказе
    public void waitSuccessfulOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(messageSuccessfulOrder));
    }

    //Метод возвращает сообщение об успешном заказе (необходимо для проверки)
    public WebElement getSuccessfulOrder() {
        WebElement message = driver.findElement(messageSuccessfulOrder);
        return message;
    }

    //Метод возвращает сообщение об успешном заказе в виде строки (необходимо для проверки)
    public String getMessageSuccessfulOrder() {
        String messageText = driver.findElement(messageSuccessfulOrder).getText();
        return messageText;
    }

    //Нажимаем на логотип "Самокат"
    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

}
