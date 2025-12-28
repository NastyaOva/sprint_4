import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import pages.Login;

import java.util.function.Consumer;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {
    private final Consumer<MainPage> clickBtn;
    private final Login login;

    public OrderTest(Consumer<MainPage> clickBtn, Login login) {
        this.clickBtn = clickBtn;
        this.login = login;

    }

    @Parameterized.Parameters(name = "Кнопка {0}:")
    public static Object[][] testLogin() {
        return new Object[][]{
                {(Consumer<MainPage>) (MainPage::clickOrderBtnFirstPoint), new Login("Анастасия", "Пугалова", "проспект Мира, 176", "ВДНХ", "89112345789")},
                {(Consumer<MainPage>) (MainPage::clickOrderBtnSecondPoint), new Login("Захар", "Любимов", "Хорошёвское шоссе, 5к2", "Беговая", "89281234567")}
        };
    }


    @Test
    public void orderTest() {
        mainPage.openPage();
        clickBtn.accept(mainPage);
        orderPage.fillFirstForm(login.getName(), login.getSurname(), login.getAddress(), login.getMetroStation(), login.getTelephoneNumber());
        orderPage.fillSecondForm();
        orderPage.waitBtnYes();
        orderPage.clickBtnYes();
        orderPage.waitSuccessfulOrder();

        assertTrue("Всплывающее окно не появилось", orderPage.getSuccessfulOrder().isDisplayed());
        assertTrue("Сообщения об успешном создании заказе нет", orderPage.getMessageSuccessfulOrder().contains("Заказ оформлен"));
    }
}


