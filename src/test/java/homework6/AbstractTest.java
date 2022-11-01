package homework6;

import io.cucumber.java.an.E;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
    private static WebDriver driver;
    public static String h1PageTitle = ".name-product-detail";
    public static String labirintDoorXpath = ".//*[text()='LABIRINT Входная металлическая дверь PIANO 3 орех премиум']";

    static EventFiringWebDriver eventDriver;


    public static File makeScreenshot (WebDriver driver, String filename){        // Функция создания скриншота
        File temp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("./screenshots/" + filename);
        try {
            FileUtils.copyFile(temp, destination);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return destination;
    }
    public static void getLogs(WebDriver driver){   // Логирование
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> allowRows = browserLogs.getAll();
        if (allowRows.size() > 0) {
            allowRows.forEach(LogEntry ->{
                System.out.println(LogEntry.getMessage());
            });
        }
    }
    @BeforeAll
    static void init () {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(10));

        eventDriver = new EventFiringWebDriver(new ChromeDriver(options));
        eventDriver.register(new MyWebDriverEventListener());
        eventDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow( ()-> getWebDriver().navigate().to("https://dverka.moscow"),
                "Страница не доступна");
        Assertions.assertTrue(true);
    }

    @AfterEach
    public void browserLogs () {
        List<LogEntry> allLogRows = getWebDriver().manage().logs().get(LogType.BROWSER).getAll();
        if(!allLogRows.isEmpty()){
            if(allLogRows.size() > 0) {
                allLogRows.forEach(logEntry -> {
                    System.out.println(logEntry.getMessage());
                });
            }
        }
    }

    @AfterAll
    static void close(){
        driver.quit();
    }

    public WebDriver getWebDriver(){
        return this.eventDriver;
    }
}
