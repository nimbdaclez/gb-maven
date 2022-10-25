package homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class LoginPage extends AbstractPage{

    @FindBy(xpath = ".//input[@name='USER_LOGIN']")
    private WebElement inputLogin;

    @FindBy(xpath = ".//input[@name='USER_PASSWORD']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement submitLogin;

    public void singIn(String login, String password){
        Actions singIn = new Actions(getDriver());
        singIn
                .sendKeys(this.inputLogin,login)
                .sendKeys(this.inputPassword,password)
                .click(this.submitLogin)
                .build()
                .perform();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
