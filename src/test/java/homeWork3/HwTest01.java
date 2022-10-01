package homeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HwTest01 {
    public static void main(String[] args) {

        /* Авторизация на сайте */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://dverka.moscow");

        WebElement webElement = driver.findElement(By.xpath(".//*[text()='Войти']"));
        webElement.click();
        WebElement webElement2 = driver.findElement(By.xpath(".//input[@name='USER_LOGIN']"));
        webElement2.sendKeys("kingarthur");
        WebElement webElement3 = driver.findElement(By.xpath(".//input[@name='USER_PASSWORD']"));
        webElement3.sendKeys("12345678");
        WebElement webElement4 = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        webElement4.click();

    }
}
