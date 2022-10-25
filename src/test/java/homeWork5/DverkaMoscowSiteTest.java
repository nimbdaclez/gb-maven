package homeWork5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Test;
import java.time.Duration;



public class DverkaMoscowSiteTest extends AbstractTest {

    static WebDriver driver;


    @Test
    @DisplayName("Добавление товара в корзину")
    public void addToCart(){
        WebElement webElement = getDriver().findElement(By.xpath(searchXpath));
        webElement.sendKeys(doorId);
        webElement.submit();
        WebElement webElement2 = getDriver().findElement(By.xpath(labirintDoorXpath));
        webElement2.click();

        WebElement webElement3 = getDriver().findElement(By.xpath(addToCartButton));
        webElement3.click();

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
    public void deleteFromCartTest(){
        WebElement webElement = getDriver().findElement(By.xpath(searchXpath));
        webElement.sendKeys(doorId);
        webElement.submit();

        WebElement webElement2 = getDriver().findElement(By.xpath(labirintDoorXpath));
        webElement2.click();

        WebElement webElement3 = getDriver().findElement(By.xpath(addToCartButton));
        webElement3.click();

        getDriver().get("https://dverka.moscow");

        WebElement webElement4 = getDriver().findElement(By.xpath(".//div[@class='basket-inner-counter']"));
        webElement4.click();

        WebElement webElement5 = getDriver().findElement(By.xpath(".//a[@id='basket-remove-all']"));
        webElement5.click();
        try { /* неявная задержка для прогрузки фильтра */
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(getDriver().findElement(By.xpath(".//div[2]/p/font[@class='errortext']")).getText().equals("Ваша корзина пуста"));
    }

    @Test
    @DisplayName("Проверка фильтра")
    public void FilterWorking() {
        WebElement webElement = getDriver().findElement(By.xpath(".//*[text()='Межкомнатные двери']"));
        webElement.click();

        WebElement webElement2 = getDriver().findElement(By.xpath(".//*[text()='el`PORTA г. Рязань']"));
        webElement2.click();

        try { /* неявная задержка для прогрузки фильтра */
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement webElement4 = getDriver().findElement(By.xpath("//input[@id='set_filter']"));
        webElement4.click();
        Assertions.assertTrue(getDriver().findElement(By.cssSelector(".h1")).getText().equals("Межкомнатные двери — Производитель: el`PORTA г. Рязань"));
    }

    @Test
    @DisplayName("Проверка авторизации")

    public void SiteAuthorization(){
        WebElement webElement = getDriver().findElement(By.xpath(".//*[text()='Войти']"));
        webElement.click();
        WebElement webElement2 = getDriver().findElement(By.xpath(".//input[@name='USER_LOGIN']"));
        webElement2.sendKeys("kingarthur");
        WebElement webElement3 = getDriver().findElement(By.xpath(".//input[@name='USER_PASSWORD']"));
        webElement3.sendKeys("12345678");
        WebElement webElement4 = getDriver().findElement(By.xpath("//input[@class='btn btn-primary']"));
        webElement4.click();
        Assertions.assertTrue(getDriver().findElement(By.xpath(".//h1")).getText().equals("Личный кабинет"));
    }
    @Test
    @DisplayName("Проверка выбора другого цвета двери")
    public void changeColor(){
        WebElement webElement = getDriver().findElement(By.xpath(searchXpath));
        webElement.sendKeys(doorId);
        webElement.submit();
        WebElement webElement2 = getDriver().findElement(By.xpath(labirintDoorXpath));
        webElement2.click();
        WebElement webElement3 = getDriver().findElement(By.xpath(".//div[2]/div[3]/div[2]/div/a[2]"));
        webElement3.click();
        Assertions.assertTrue(getDriver().findElement(By.cssSelector(h1PageTitle)).getText().equals("LABIRINT Входная металлическая дверь PIANO 3 сандал белый 5716975659"));

    }
    @Test
    @DisplayName("Проверка переключения опций")
    void ActionTest01 () throws InterruptedException {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://dverka.moscow"));
        Assertions.assertTrue(getDriver().getTitle().contains("Интернет-магазин дверей | Продажа межкомнатных и входных дверей с доставкой по Москве и регионам России | Цены в каталоге ООО «ТРИЭР»"),"Не главная страница");

        getDriver().get("https://dverka.moscow/catalog/vkhodnye-dveri/optim-dekor/vkhodnaya-dver-stroygost-5-1-antik-med/");

        Actions changeOptions = new Actions(getDriver());
        changeOptions.click(getDriver().findElement(By.xpath(".//div[@data-id='22']")))
                .pause(1000l)
                .click(getDriver().findElement(By.xpath(".//div[@data-id='21']")))
                .pause(1000l)
                .click(getDriver().findElement(By.xpath(".//div[@data-id='2']")))
                .pause(1000l)
                .click(getDriver().findElement(By.xpath(".//div[@data-id='1']")))
                .pause(1000L)
                .build()
                .perform();
    }
}