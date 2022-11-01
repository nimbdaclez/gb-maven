package homework6;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CartTest extends AbstractTest{

    @Test
    @DisplayName("Добавление товара в корзину")
    void addToCart() throws InterruptedException, IOException {
        MainMenu mainMenu = new MainMenu(getWebDriver());
        ProductPage productPage = new ProductPage(getWebDriver());
        mainMenu.sendDoorId();
        WebElement webElement2 = getWebDriver().findElement(By.xpath(labirintDoorXpath));
        webElement2.click();
        productPage.addToCart();

        try { /* задержка для загрузки модального окна */
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement webElement4 = getWebDriver().findElement(By.cssSelector("a.uk-modal-close.modal-transparent"));
        webElement4.click();

        Assertions.assertTrue(getWebDriver().findElement(By.cssSelector(h1PageTitle)).getText().equals("LABIRINT Входная металлическая дверь PIANO 3 орех премиум 5712302547"));

        File file = makeScreenshot(getWebDriver(),"someScreenShot" + System.currentTimeMillis() +".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
    }
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Test
    @DisplayName("Удаление товара из корзины")
    public void deleteFromCart(){
        MainMenu mainMenu = new MainMenu(getWebDriver());
        ProductPage productPage = new ProductPage(getWebDriver());
        CartPage cartPage = new CartPage(getWebDriver());
        mainMenu.sendDoorId();

        WebElement webElement = getWebDriver().findElement(By.xpath(labirintDoorXpath));
        webElement.click();
        productPage.addToCart();

        getWebDriver().get("https://dverka.moscow");

        mainMenu.goBasket();
        cartPage.removeFromBasket();

        Assertions.assertTrue(getWebDriver().findElement(By.xpath(".//div[2]/p/font[@class='errortext']")).getText().equals("Ваша корзина пуста"));
    }

}
