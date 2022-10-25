package homework6;

import com.sun.tools.javac.Main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends AbstractPage {

    @FindBy(xpath = ".//div[2]/div/input[@name='q']")
    private WebElement searchXpath;

    @FindBy(xpath = ".//*[text()='Войти']" )
    private WebElement singInButton;

    @FindBy(xpath = ".//*[text()='Межкомнатные двери']")
    private WebElement doorCategory;

    @FindBy(xpath = ".//div[@class='basket-inner-counter']")
    private WebElement goToBasket;

    public MainMenu sendDoorId(){
        searchXpath.sendKeys("5712302547");
        return this;
    }

    public MainMenu singIn(){
        singInButton.click();
        return this;
    }

    public MainMenu goToCategory(){
        doorCategory.click();
        return this;
    }

    public MainMenu goBasket(){
        goToBasket.click();
        return this;
    }
    public MainMenu(WebDriver driver) {
        super(driver);
    }


}
