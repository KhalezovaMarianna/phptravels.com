package webOrangehrmlive.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//h5[@class=\"oxd-text oxd-text--h5 orangehrm-login-title\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//input[@placeholder=\"Username\"]|//input[@placeholder=\"auth.username\"]")
    private ExtendedWebElement usernameField;

    @FindBy(xpath = "//input[@placeholder=\"Password\"]|//input[@placeholder=\"auth.password\"]")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void fillUsernameField(String username){
        usernameField.type(username);
    }

    public void fillPasswordField(String password){
        passwordField.type(password);
    }

    public boolean isOpened(){return title.isElementPresent();}
    public PimPage clickLoginButton(){
        loginBtn.click();
        return new PimPage(getDriver());
    }
}
