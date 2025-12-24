import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OrderErrorTest extends BaseTest {
    @Test
    public void invalidOrderTest() {
        mainPage.openPage();
        mainPage.clickStatusBtn();
        mainPage.waitVisibilityField();
        mainPage.setNumberOrder("0000");
        mainPage.clickGoBtn();
        orderNumberPage.waitVisibilityImg();

        assertTrue("Сообщение об ошибке не отображается", orderNumberPage.getImg().isDisplayed());
    }
}
