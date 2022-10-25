package homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = ".//div[@data-id='114578']")
    private WebElement addToCartButton;

    @FindBy(xpath = ".name-product-detail")
    private WebElement productTitle;

    public ProductPage addToCart(){
        addToCartButton.click();
        return this;
    }



    public ProductPage(WebDriver driver) {
        super(driver);
    }
}
