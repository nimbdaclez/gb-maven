//package on.lesson03;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//public class Lesson03 {
//
//    public static void main(String[] args) {
//        //System.setProperty("webdriver.chrome.driver", "scr/main/resources/chromedriver"); /* Подключаем локальный веб-драйвер */
//
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
//        //options.addArguments("--headless"); /* запустить в фоновом режиме */
//        options.addArguments("start-maximized");
//
//        WebDriver driver = new ChromeDriver(options); /* вызываем драйвер с опциями */
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        driver.get("https://google.com");
//
//        WebElement webElement = driver.findElement(By.name("q")); /* найди элемент */
//        WebElement webElement2 = driver.findElement(By.cssSelector("input.gLFyf.gsfi"));
//        WebElement webElement3 = driver.findElement(By.xpath(".//input[@name='q']"));
//
////        try {
////            WebElement WebElementError = driver.findElement(By.name("error"));
////        } catch (NoSuchElementException e) {
////            System.out.println(e.getSupportUrl());
////        }
//
//        WebElement WebElementError = driver.findElement(By.name("error")); /* проверить наличие эллемента */
//
//        List<WebElement> webElements = driver.findElements(By.name("error")); /* найди элементЫ */
//
////        if(webElements.size()>1) {
////            //todo
////        }
//
//        webElement.click(); /* сделать клик */
//        webElement2.sendKeys("Поиск"); /* ввести значение */
//
//        try { /* неявная задержка потока выполнения программы */
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        new WebDriverWait(driver, 50).until(ExpectedCondition.urlContains("google")); /* явное ожидание с условием */
//        new WebDriverWait(driver, 50); /* явное ожидание без условия */
//
//        driver.navigate().to("https://google.com"); /* переходим на ... */
//    }
//}
//
