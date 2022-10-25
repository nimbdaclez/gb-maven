package homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {
    //    public static String doorId = "5712302547";
//    public static String addToCartButton = ".//div[@data-id='114578']";
//    public static String h1PageTitle = ".name-product-detail";
//    public static String searchXpath = ".//div[2]/div/input[@name='q']";
//    public static String labirintDoorXpath = ".//*[text()='LABIRINT Входная металлическая дверь PIANO 3 орех премиум']";

    @FindBy(xpath = ".//div[@data-id='114578']")
    private WebElement addToCartButton;

    public ProductPage addToCart(){
        addToCartButton.click();
        return this;
    }

    public ProductPage(WebDriver driver) {
        super(driver);
    }
}
