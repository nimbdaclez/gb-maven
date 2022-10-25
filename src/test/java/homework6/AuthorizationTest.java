package homework6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AuthorizationTest extends AbstractTest {

    @Test
    @DisplayName("Проверка авторизации")

    public void siteAuthorization(){
        MainMenu mainMenu = new MainMenu(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        mainMenu.singInButton();
        loginPage.singIn("kingarthur","12345678");
        Assertions.assertTrue(getDriver().findElement(By.xpath(".//h1")).getText().equals("Личный кабинет"));
    }
}
