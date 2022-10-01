package homeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HwTest02 {
    public static void main(String[] args) {

        /* Проверка функциональности фильтра */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://dverka.moscow");

        WebElement webElement = driver.findElement(By.xpath(".//*[text()='Межкомнатные двери']"));
        webElement.click();

        WebElement webElement2 = driver.findElement(By.xpath(".//*[text()='el`PORTA г. Рязань']"));
        webElement2.click();

        try { /* неявная задержка для прогрузки фильтра */
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement webElement4 = driver.findElement(By.xpath("//input[@id='set_filter']"));
        webElement4.click();

    }
}
