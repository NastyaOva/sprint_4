import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.OrderNumberPage;
import pages.OrderPage;

public class BaseTest {
    WebDriver driver = new ChromeDriver();
    MainPage mainPage;
    OrderPage orderPage;
    OrderNumberPage orderNumberPage;

    @Before
    public void starUp() {
        WebDriverManager.chromedriver().setup();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
        orderNumberPage = new OrderNumberPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
