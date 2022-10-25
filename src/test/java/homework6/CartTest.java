package homework6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartTest extends AbstractTest{

    @Test
    @DisplayName("Добавление товара в корзину")
    public void addToCart(){
        MainMenu mainMenu = new MainMenu(getDriver());
        ProductPage productPage = new ProductPage(getDriver());
        mainMenu.sendDoorId();
        WebElement webElement2 = getDriver().findElement(By.xpath(labirintDoorXpath));
        webElement2.click();
        productPage.addToCart();

        try { /* задержка для загрузки модального окна */
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement webElement4 = getDriver().findElement(By.cssSelector("a.uk-modal-close.modal-transparent"));
        webElement4.click();

        Assertions.assertTrue(getDriver().findElement(By.cssSelector(h1PageTitle)).getText().equals("LABIRINT Входная металлическая дверь PIANO 3 орех премиум 5712302547"));
    }

    @Test
    @DisplayName("Удаление товара из корзины")
    public void deleteFromCart(){
        MainMenu mainMenu = new MainMenu(getDriver());
        ProductPage productPage = new ProductPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        mainMenu.sendDoorId();

        WebElement webElement = getDriver().findElement(By.xpath(labirintDoorXpath));
        webElement.click();
        productPage.addToCart();

        getDriver().get("https://dverka.moscow");

        mainMenu.goBasket();
        cartPage.removeFromBasket();

        Assertions.assertTrue(getDriver().findElement(By.xpath(".//div[2]/p/font[@class='errortext']")).getText().equals("Ваша корзина пуста"));
    }

}
