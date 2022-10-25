package webOrangehrmlive.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.pages.loginPages.ForgetPasswordPage;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//h5[@class=\"oxd-text oxd-text--h5 orangehrm-login-title\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//input[@placeholder=\"Username\"]")
    private ExtendedWebElement usernameField;

    @FindBy(xpath = "//input[@placeholder=\"Password\"]")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//p[@class=\"oxd-text oxd-text--p orangehrm-login-forgot-header\"]")
    private ExtendedWebElement forgetPasswordBtn;

    @FindBy(xpath = "//div[@role=\"alert\"]")
    private ExtendedWebElement errorMessage;

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

    public ForgetPasswordPage clickForgetPasswordButton(){
        forgetPasswordBtn.click();
        return new ForgetPasswordPage(getDriver());
    }

    public boolean isAlertPresented(){
       return errorMessage.isElementPresent();
    }
}
