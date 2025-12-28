package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//Класс главной страницы Яндекс Самокат
public class MainPage {

    private WebDriver driver;

    //Локатор URL
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";

    //Кнопка куки
    private By cookieButton = By.id("rcc-confirm-button");

    //Кнопки "Вопросы о важном"
    private By questionBtn(int numberQuestion) {
        return By.id("accordion__heading-" + numberQuestion);
    }

    //Ответ при нажатии на кнопки "Вопросы о важном", номер ответа соответствует номеру вопроса
    private By answerText(int numberQuestion) {
        return By.id("accordion__panel-" + numberQuestion);
    }

    //Кнопка "Заказать" в шапке страницы (точка входа 1)
    private static By orderBtnFirstPoint = By.cssSelector(".Button_Button__ra12g");

    //Кнопка "Заказать" в шапке страницы (точка входа 2)
    private static By orderBtnSecondPoint = By.cssSelector(".Button_Button__ra12g.Button_UltraBig__UU3Lp");

    //ОР нажатия на логотип "Самокат"
    private String expectedUrlScooter = "https://qa-scooter.praktikum-services.ru/";

    //Логотип "Яндекс"
    private By yandexLogo = By.xpath(".//img[@alt='Yandex']");

    //Кнопка "Статус заказа"
    private By statusBtn = By.className("Header_Link__1TAG7");

    //Поле ввода номера заказа
    private By statusField = By.cssSelector("input[placeholder='Введите номер заказа']");

    //Кнопка "Go"
    private By goBtn = By.xpath("//button[text()='Go!']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Открываем сайт, если есть баннер с куки, то закрываем его
    public void openPage() {
        driver.get(URL);
        List<WebElement> cookies = driver.findElements(cookieButton);
        if (!cookies.isEmpty() && cookies.get(0).isDisplayed()) {
            cookies.get(0).click();
        }
    }

    //Скроллим страницу до кнопки "Вопросы о важном" и нажимаем на нее
    public void clickBtnQuestion(int numberQuestion) {
        WebElement element = driver.findElement(questionBtn(numberQuestion));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(answerText(numberQuestion)));
    }

    //Метод возвращает фактический текст ответа на вопрос в виде строки при нажатии на кнопку "Вопросы о важном" (необходимо для сравнения ФР и ОР)
    public String getActualText(int numberQuestion) {
        String actualText = driver.findElement(answerText(numberQuestion)).getText();
        return actualText;
    }

    //Нажимаем на кнопку "Заказать" (первая точка входа)
    public void clickOrderBtnFirstPoint() {
        driver.findElement(orderBtnFirstPoint).click();
    }

    //Нажимаем на кнопку "Заказать" (вторая точка входа)
    public void clickOrderBtnSecondPoint() {
        driver.findElement(orderBtnSecondPoint).click();
    }

    //Метод возвращает фактический URL в виде строки (переход на домашнюю страницу Яндекс Самокат, необходимо для сравнения ФР и ОР)
    public String getActualUrlScooter() {
        return driver.getCurrentUrl();
    }

    //Геттер ОР нажатия на логотип "Самокат" (необходимо для сравнения ФР и ОР)
    public String getExpectedUrlScooter() {
        return expectedUrlScooter;
    }

    //Нажимаем на логотип "Яндекс" и переходим в новое окно (Дзен)
    public void clickYandexLogo() {
        String firstWindow = driver.getWindowHandle();
        driver.findElement(yandexLogo).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> d.getWindowHandles().size() > 1);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!firstWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    //Ожидаем пока текущий URL будет содержать заданную строку
    public void waitUrl(String urlFragment) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> d.getCurrentUrl().contains(urlFragment));
    }

    //Метод возвращает фактический URL в виде строки (переход на домашнюю страницу Дзен, необходимо для проверки)
    public String getActualUrlYandex() {
        return driver.getCurrentUrl();
    }

    //Нажимаем на кнопку "Статус заказа"
    public void clickStatusBtn() {
        driver.findElement(statusBtn).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(statusField));
    }

    //Вводим значение в поле ввода номера заказа
    public void inputNumberOrder(String number) {
        driver.findElement(statusField).sendKeys(number);
    }

    //Нажимаем на кнопку "Go!"
    public void clickGoBtn() {
        driver.findElement(goBtn).click();
    }
}

