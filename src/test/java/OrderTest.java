import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pages.MainPage;
import pages.Login;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {
    private final By orderBtnPoint;
    private final Login login;

    public OrderTest(By orderBtnPoint, Login login) {
        this.orderBtnPoint = orderBtnPoint;
        this.login = login;

    }

    @Parameterized.Parameters
    public static Object[][] testLogin() {
        return new Object[][]{
                {MainPage.getOrderBtnFirstPoint(), new Login("Анастасия", "Пугалова", "проспект Мира, 176", "ВДНХ", "89112345789")},
                {MainPage.getOrderBtnSecondPoint(), new Login("Захар", "Любимов", "Хорошёвское шоссе, 5к2", "Беговая", "89281234567")}
        };
    }


    @Test
    public void orderTest() {
        mainPage.openPage();
        mainPage.checkCookieButton();
        driver.findElement(orderBtnPoint).click();
        orderPage.clickFieldName();
        orderPage.inputFieldName(login.getName());
        orderPage.clickFieldSurname();
        orderPage.inputFieldSurname(login.getSurname());
        orderPage.clickFieldAddress();
        orderPage.inputFieldAddress(login.getAddress());
        orderPage.clickFieldMetroStation();
        orderPage.inputFieldMetroStation(login.getMetroStation());
        orderPage.clickFieldStationList();
        orderPage.clickFieldTelephoneNumber();
        orderPage.inputFieldTelephoneNumber(login.getTelephoneNumber());
        orderPage.clickNextBtn();
        orderPage.clickFieldDate();
        orderPage.clickCalendarDate();
        orderPage.clickFieldLeasing();
        orderPage.clickNumberOfDays();
        orderPage.clickCheckboxColorScooter();
        orderPage.clickOrderBtn();
        orderPage.waitBtnYes();
        orderPage.clickBtnYes();
        orderPage.waitPopup();

        assertTrue("Всплывающее окно не появилось", orderPage.getPopupSuccessfulOrder().isDisplayed());
        MatcherAssert.assertThat("Сообщения об успешном создании заказе нет", orderPage.getMessageSuccessfulOrder(), containsString(orderPage.getExpectedMessage()));
    }
}


