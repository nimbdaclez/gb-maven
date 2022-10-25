package homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage{

    @FindBy(xpath = ".//a[@id='basket-remove-all']")
    private WebElement removeBasket;

    public CartPage removeFromBasket(){
        removeBasket.click();
        return this;
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }

}
