package homework6;

import com.sun.tools.javac.Main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends AbstractPage {
//    public static String doorId = "5712302547";
//    public static String addToCartButton = ".//div[@data-id='114578']";
//    public static String h1PageTitle = ".name-product-detail";
//    public static String searchXpath = ".//div[2]/div/input[@name='q']";
//    public static String labirintDoorXpath = ".//*[text()='LABIRINT Входная металлическая дверь PIANO 3 орех премиум']";

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
