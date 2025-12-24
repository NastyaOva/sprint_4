package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {

    private WebDriver driver;

    //локатор URL
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";

    //Test_1
    //кнопка куки
    private By cookieButton = By.id("rcc-confirm-button");

    //кнопки "Вопросы о важном"
    private By questionPayment = By.id("accordion__heading-0");
    private By questionSeveralscooters = By.id("accordion__heading-1");
    private By questionRentaltime = By.id("accordion__heading-2");
    private By questionOrderforToday = By.id("accordion__heading-3");
    private By questionOrder = By.id("accordion__heading-4");
    private By questionCharging = By.id("accordion__heading-5");
    private By questionOrdercancellation = By.id("accordion__heading-6");
    private By questionOrdermkad = By.id("accordion__heading-7");

    //массив кнопок
    private By[] buttons = {questionPayment, questionSeveralscooters, questionRentaltime, questionOrderforToday, questionOrder, questionCharging, questionOrdercancellation, questionOrdermkad};

    //выпадающий список для каждой кнопки "Вопросы о важном"
    private By textPayment = By.id("accordion__panel-0");
    private By textSeveralscooters = By.id("accordion__panel-1");
    private By textRentaltime = By.id("accordion__panel-2");
    private By textOrderforToday = By.id("accordion__panel-3");
    private By textOrder = By.id("accordion__panel-4");
    private By textCharging = By.id("accordion__panel-5");
    private By textOrdercancellation = By.id("accordion__panel-6");
    private By textOrdermkad = By.id("accordion__panel-7");

    //массив ответов на кнопки "Вопрос о важном"
    private By[] answers = {textPayment, textSeveralscooters, textRentaltime, textOrderforToday, textOrder, textCharging, textOrdercancellation, textOrdermkad};

    //ОР при нажатии на кнопки "Вопросы о важном"
    private final String[] EXPECTED_TEXT = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    //ФР при нажатии на кнопки "Вопросы о важном"
    private String[] result = new String[answers.length];

    //Test_2
    //кнопка "Заказать" в шапке страницы (точка входа 1)
    private static By orderBtnFirstPoint = By.cssSelector(".Button_Button__ra12g");

    //кнопка "Заказать" в шапке страницы (точка входа 2)
    private static By orderBtnSecondPoint = By.cssSelector(".Button_Button__ra12g.Button_UltraBig__UU3Lp");

    //Доп. задания
    //ФР нажатия на логотип "Самокат"
    private String actualUrlScooter;

    //ОР нажатия на логотип "Самокат"
    private String expectedUrlScooter = "https://qa-scooter.praktikum-services.ru/";

    //логотип "Яндекс"
    private By yandexLogo = By.xpath(".//img[@alt='Yandex']");

    //ФР нажатия на логотип "Яндекс"
    private String actualUrlYandex;

    //сохранение первоначального окна
    private String firstWindow;

    //кнопка "Статус заказа"
    private By statusBtn = By.className("Header_Link__1TAG7");

    //поле ввода номера заказа
    private By statusField = By.cssSelector("input[placeholder='Введите номер заказа']");

    //кнопка "Go"
    private By goBtn = By.xpath("//button[text()='Go!']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(URL);
    }

    public void checkCookieButton() {
        if (driver.findElement(cookieButton).isDisplayed()) {
            driver.findElement(cookieButton).click();
        }
    }

    public void scrollPage() {
        WebElement element = driver.findElement(questionPayment);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void checkButton() {
        for (int i = 0; i < buttons.length; i++) {
            driver.findElement(buttons[i]).click();
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(answers[i]));
            result[i] = driver.findElement(answers[i]).getText();
        }
    }

    public String[] getResult() {
        return result;
    }

    public String[] getEXPECTED_TEXT() {
        return EXPECTED_TEXT;
    }

    public static By getOrderBtnFirstPoint() {
        return orderBtnFirstPoint;
    }

    public static By getOrderBtnSecondPoint() {
        return orderBtnSecondPoint;
    }

    public void clickOrderBtnFirstPoint() {
        driver.findElement(orderBtnFirstPoint).click();
    }

    public String getActualUrlScooter() {
        actualUrlScooter = driver.getCurrentUrl();
        return actualUrlScooter;
    }

    public String getExpectedUrlScooter() {
        return expectedUrlScooter;
    }

    public void clickYandexLogo() {
        driver.findElement(yandexLogo).click();
    }

    public void waitWindowYandex() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> d.getWindowHandles().size() > 1);
    }

    public String saveWindow() {
        firstWindow = driver.getWindowHandle();
        return firstWindow;
    }


    public void newWindowYandex() {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!firstWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void waitUrlYandex() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> d.getCurrentUrl().contains("dzen"));
    }

    public String getActualUrlYandex() {
        actualUrlYandex = driver.getCurrentUrl();
        return actualUrlYandex;
    }

    public void clickStatusBtn() {
        driver.findElement(statusBtn).click();
    }

    public void waitVisibilityField() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(statusField));
    }

    public void setNumberOrder(String number) {
        driver.findElement(statusField).sendKeys(number);
    }

    public void clickGoBtn() {
        driver.findElement(goBtn).click();
    }
}

