package homeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DeleteFromCartTest {
    public static void main(String[] args) {

        /* Проверка удаления товара из корзины */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://dverka.moscow");

        WebElement webElement = driver.findElement(By.xpath(".//div[2]/div/input[@name='q']"));
        webElement.sendKeys("5712302547");
        webElement.submit();

        WebElement webElement2 = driver.findElement(By.xpath(".//*[text()='LABIRINT Входная металлическая дверь PIANO 3 орех премиум']"));
        webElement2.click();

        WebElement webElement3 = driver.findElement(By.xpath(".//div[@data-id='114578']"));
        webElement3.click();

        driver.get("https://dverka.moscow");

        WebElement webElement4 = driver.findElement(By.xpath(".//div[@class='basket-inner-counter']"));
        webElement4.click();

        WebElement webElement5 = driver.findElement(By.xpath(".//a[@id='basket-remove-all']"));
        webElement5.click();

    }
}
