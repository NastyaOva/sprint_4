import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertEquals;

public class FaqTest extends BaseTest {

    @Test
    public void faqAnswersTest() {
        mainPage.openPage();
        mainPage.checkCookieButton();
        mainPage.scrollPage();
        mainPage.checkButton();
        for (int i = 0; i < mainPage.getResult().length; i++) {
            assertEquals("Неверный текст ответа на вопрос", mainPage.getEXPECTED_TEXT(), mainPage.getResult());
        }
    }
}
