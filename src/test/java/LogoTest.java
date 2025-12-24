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
        mainPage.saveWindow();
        mainPage.clickYandexLogo();
        mainPage.waitWindowYandex();
        mainPage.newWindowYandex();
        mainPage.waitUrlYandex();

        assertTrue("Не открылся сайт Яндекс", mainPage.getActualUrlYandex().contains("dzen.ru"));
    }
}
