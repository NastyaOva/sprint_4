package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    private WebDriver driver;

    //поле "Имя"
    private By fieldName = By.xpath(".//input[@placeholder='* Имя']");

    //поле "Фамилия"
    private By fieldSurname = By.xpath(".//input[@placeholder='* Фамилия']");

    //поле "Адрес"
    private By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //поле "Станция метро"
    private By fieldMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");

    //выпадающий список станций метро
    private By stationList = By.cssSelector(".select-search__select");

    //поле "Телефон"
    private By fieldTelephoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //кнопка "Далее"
    private By nextBtn = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    //поле "Дата аренды"
    private By fieldDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //кнопка в календаре при выборе даты аренды (дата - 17.12.25)
    private By calendarDate = By.xpath(".//div[@aria-label='Choose среда, 17-е декабря 2025 г.']");

    //поле "Срок аренды"
    private By fieldLeasing = By.className("Dropdown-placeholder");

    //выпадающий список "Срок аренды" (двое суток)
    private By numberOfDays = By.xpath(".//div[text()='двое суток']");

    //чекбокс "Цвет самоката" (черный жемчуг)
    private By checkboxColorScooter = By.id("black");

    //кнопка "Заказать"
    private By orderBtn = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text() = 'Заказать']");

    //кнопка "Да" во всплывающем окне "Хотите оформить заказ?"
    private By btnYes = By.xpath(".//button[text() = 'Да']");

    //сообщение об успешном оформлении заказа
    private By messageSuccessfulOrder = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ']");

    //ОР сообщения об успешном оформлении заказа
    private final String EXPECTED_MESSAGE = "Заказ оформлен";

    //Доп. задания
    //логотип "Самокат"
    private By scooterLogo = By.className("Header_LogoScooter__3lsAR");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickFieldName() {
        driver.findElement(fieldName).click();
    }

    public void inputFieldName(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }

    public void clickFieldSurname() {
        driver.findElement(fieldSurname).click();
    }

    public void inputFieldSurname(String surname) {
        driver.findElement(fieldSurname).sendKeys(surname);
    }

    public void clickFieldAddress() {
        driver.findElement(fieldAddress).click();
    }

    public void inputFieldAddress(String address) {
        driver.findElement(fieldAddress).sendKeys(address);
    }

    public void clickFieldMetroStation() {
        driver.findElement(fieldMetroStation).click();
    }

    public void inputFieldMetroStation(String metroStation) {
        driver.findElement(fieldMetroStation).sendKeys(metroStation);
    }

    public void clickFieldStationList() {
        driver.findElement(stationList).click();
    }

    public void clickFieldTelephoneNumber() {
        driver.findElement(fieldTelephoneNumber).click();
    }

    public void inputFieldTelephoneNumber(String telephoneNumber) {
        driver.findElement(fieldTelephoneNumber).sendKeys(telephoneNumber);
    }

    public void clickNextBtn() {
        driver.findElement(nextBtn).click();
    }

    public void clickFieldDate() {
        driver.findElement(fieldDate).click();
    }

    public void clickCalendarDate() {
        driver.findElement(calendarDate).click();
    }

    public void clickFieldLeasing() {
        driver.findElement(fieldLeasing).click();
    }

    public void clickNumberOfDays() {
        driver.findElement(numberOfDays).click();
    }

    public void clickCheckboxColorScooter() {
        driver.findElement(checkboxColorScooter).click();
    }

    public void clickOrderBtn() {
        driver.findElement(orderBtn).click();
    }

    public void waitBtnYes() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(btnYes));
    }

    public void clickBtnYes() {
        driver.findElement(btnYes).click();
    }

    public void waitPopup() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(messageSuccessfulOrder));
    }

    public WebElement getPopupSuccessfulOrder() {
        WebElement popup = driver.findElement(messageSuccessfulOrder);
        return popup;
    }

    public String getExpectedMessage() {
        return EXPECTED_MESSAGE;
    }

    public String getMessageSuccessfulOrder() {
        String message = driver.findElement(messageSuccessfulOrder).getText();
        return message;
    }

    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

}
