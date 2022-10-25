package homework6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SiteFunctionsTest extends AbstractTest {


    @Test
    @DisplayName("Проверка фильтра")
    public void filterWorking(){
        MainMenu mainMenu = new MainMenu(getDriver());

        mainMenu.goToCategory();
        WebElement webElement2 = getDriver().findElement(By.xpath(".//*[text()='el`PORTA г. Рязань']"));
        webElement2.click();

        try { /* неявная задержка для прогрузки фильтра */
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainMenu.clickSetFilterButton();
        Assertions.assertTrue(getDriver().findElement(By.cssSelector(".h1")).getText().equals("Межкомнатные двери — Производитель: el`PORTA г. Рязань"));
    }


    @Test
    @DisplayName("Проверка выбора другого цвета двери")
    public void changeColorOption(){
        MainMenu mainMenu = new MainMenu(getDriver());
        mainMenu.sendDoorId();
        WebElement webElement1 = getDriver().findElement(By.xpath(".//*[text()='LABIRINT Входная металлическая дверь PIANO 3 орех премиум']"));
        webElement1.click();
        WebElement webElement3 = getDriver().findElement(By.xpath(".//div[2]/div[3]/div[2]/div/a[2]"));
        webElement3.click();
        Assertions.assertTrue(getDriver().findElement(By.cssSelector(h1PageTitle)).getText().equals("LABIRINT Входная металлическая дверь PIANO 3 сандал белый 5716975659"));
    }

    @Test
    @DisplayName("Проверка переключения опций")
    void changeProductOptions () {
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

//        Assertions.assertTrue(getDriver().findElement(By.id(".//*[@data-id='11164']")).getText().equals("11164")); // не пойму как в обновившейся дом структуре сравнить данные

        }

}
