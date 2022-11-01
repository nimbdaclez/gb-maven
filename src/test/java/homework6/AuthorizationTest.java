package homework6;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
@Story("Залогирование юзера на сайте") // "История" для тестов
public class AuthorizationTest extends AbstractTest {

    // @Step("Шаг") // Аннотация степов для методов


    @Test
    @DisplayName("Проверка авторизации")
    @Feature("Фича") // Аннотация фичи
    @Description("Тест проверят авторизацию на сайте") // Аннотация allure
    @Link("link") // Абстрактная ссылка allure
    @Issue("link") // Специализированная ссылка "allure" на тест-кесы
    @TmsLink("link") // Специализированная ссылка "allure" на баг-трекер
    @Severity(SeverityLevel.MINOR) // Критичность ошибки теста
    public void siteAuthorization(){
        MainMenu mainMenu = new MainMenu(getWebDriver());
        LoginPage loginPage = new LoginPage(getWebDriver());
        mainMenu.singInButton();
        loginPage.singIn("kingarthur","12345678");
        Assertions.assertTrue(getWebDriver().findElement(By.xpath(".//h1")).getText().equals("Личный кабинет"));
    }

}
