package homework6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AbstractTest {
    private static WebDriver driver;
    public static String h1PageTitle = ".name-product-detail";
    public static String labirintDoorXpath = ".//*[text()='LABIRINT Входная металлическая дверь PIANO 3 орех премиум']";
    @BeforeAll
    static void init () {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://dverka.moscow"),
                "Страница не доступна");
    }

    @AfterAll
    static void close(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
