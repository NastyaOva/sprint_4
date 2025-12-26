package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Класс страницы статуса заказа
public class OrderNumberPage {

    private WebDriver driver;

    //сообщение об отсутствии вводимого номера заказа
    private By imgResult = By.cssSelector("img[alt='Not found']");

    public OrderNumberPage(WebDriver driver) {
        this.driver = driver;
    }

    //Ожидаем пока появится ошибка об отсутствии заказа
    public void waitVisibilityImg() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(imgResult));
    }

    //Метод возвращает изображение ошибки об отсутствии заказа (необходимо для проверки)
    public WebElement getImg() {
        WebElement errorImg = driver.findElement(imgResult);
        return errorImg;
    }
}
