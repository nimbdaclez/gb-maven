package homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private WebDriver driver;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this); // "Ленивый" поиск эллементов
    }

    protected WebDriver getDriver() {
        return this.driver;
    }
}
