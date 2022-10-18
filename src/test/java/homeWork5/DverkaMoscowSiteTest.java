package homeWork5;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DverkaMoscowSiteTest extends AbstractTest {

    static WebDriver driver;

    //    @Test
//    @DisplayName("Добавление товара в корзину")
//    public void addToCart(){
//        new WebDriverWait(getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.urlContains("https://dverka.moscow"));
//        Assertions.assertTrue(getDriver().getTitle().contains("Интернет-магазин дверей | Продажа межкомнатных и входных дверей с доставкой по Москве и регионам России | Цены в каталоге ООО «ТРИЭР»"),"Страница входа недоступна");
//
//        Actions cartAdd = new Actions(getDriver());
//        cartAdd.sendKeys(getDriver().findElement(By.xpath(".//div[2]/div/input[@name='q']")),"5712302547")
//                .pause(1000L)
//                .click(getDriver().findElement(By.xpath(".//*[text()='LABIRINT Входная металлическая дверь PIANO 3 орех премиум']")))
//                .pause(1000l)
//                .click(getDriver().findElement(By.xpath(".//div[@data-id='114578']")))
//                .pause(1000l)
//                .click(getDriver().findElement(By.cssSelector("a.uk-modal-close.modal-transparent")))
//                .build()
//                .perform();
//    }
//    @Test
//    @DisplayName("Добавление товара в корзину")
//    public void deleteFromCartTest(){
//        WebElement webElement = driver.findElement(By.xpath(".//div[2]/div/input[@name='q']"));
//        webElement.sendKeys("5712302547");
//        webElement.submit();
//
//        WebElement webElement2 = driver.findElement(By.xpath(".//*[text()='LABIRINT Входная металлическая дверь PIANO 3 орех премиум']"));
//        webElement2.click();
//
//        WebElement webElement3 = driver.findElement(By.xpath(".//div[@data-id='114578']"));
//        webElement3.click();
//
//        driver.get("https://dverka.moscow");
//
//        WebElement webElement4 = driver.findElement(By.xpath(".//div[@class='basket-inner-counter']"));
//        webElement4.click();
//
//        WebElement webElement5 = driver.findElement(By.xpath(".//a[@id='basket-remove-all']"));
//        webElement5.click();
//    }
//
    @Test
    @DisplayName("Добавление товара в корзину")
    public void FilterWorking() {
//        new WebDriverWait(getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.urlContains("https://dverka.moscow"));
//        Assertions.assertTrue(getDriver().getTitle().contains("Интернет-магазин дверей | Продажа межкомнатных и входных дверей с доставкой по Москве и регионам России | Цены в каталоге ООО «ТРИЭР»"), "Страница входа недоступна");

        Actions filterWorking = new Actions(getDriver());
        filterWorking.click(getDriver().findElement(By.xpath(".//*[text()='Межкомнатные двери']")))
                .pause(1000L)
                .click(getDriver().findElement(By.xpath(".//*[text()='el`PORTA г. Рязань']")))
                .pause(2000L)
                .click(getDriver().findElement(By.xpath("//input[@id='set_filter']")))
                .build()
                .perform();

//    @Test
//    @DisplayName("Добавление товара в корзину")
//
//    public void SiteAuthorization(){
//        WebElement webElement = driver.findElement(By.xpath(".//*[text()='Войти']"));
//        webElement.click();
//        WebElement webElement2 = driver.findElement(By.xpath(".//input[@name='USER_LOGIN']"));
//        webElement2.sendKeys("kingarthur");
//        WebElement webElement3 = driver.findElement(By.xpath(".//input[@name='USER_PASSWORD']"));
//        webElement3.sendKeys("12345678");
//        WebElement webElement4 = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
//        webElement4.click();
//    }


    }
}