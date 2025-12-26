import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LogoTest extends BaseTest {
    @Test
    public void scooterLogoTest() {
        mainPage.openPage();
        mainPage.clickOrderBtnFirstPoint();
        orderPage.clickScooterLogo();

        assertEquals("Не открылся сайт Яндекс Самокат", mainPage.getExpectedUrlScooter(), mainPage.getActualUrlScooter());
    }

    @Test
    public void yandexLogoTest() {
        mainPage.openPage();
        mainPage.clickYandexLogo();
        mainPage.waitUrl("dzen");

        assertTrue("Не открылся сайт Яндекс", mainPage.getActualUrlYandex().contains("dzen.ru"));
    }
}
