package webPhptravel.pages;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage implements ICustomTypePageFactory, IMobileUtils {

    @FindBy(xpath = "//h5[@class='modal-title title']")
    private ExtendedWebElement loginTitle;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private ExtendedWebElement passwordForm;

    @FindBy(xpath = "//button[@type='submit']/span[text()='Login']")
    private ExtendedWebElement loginBtn;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return loginTitle.isElementPresent();
    }

    public AccountPage clickLoginButton() {
        loginBtn.click();
        return new AccountPage(getDriver());
    }

    public void fillEmailField(String email) {
        emailField.type(email);
    }

    public void fillPasswordField(String password) {
        passwordForm.type(password);
    }

}
