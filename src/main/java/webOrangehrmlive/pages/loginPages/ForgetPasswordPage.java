package webOrangehrmlive.pages.loginPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.components.PopUpForgetPassword;

public class ForgetPasswordPage extends AbstractPage {

    @FindBy(xpath = "//h6[text()=\"Reset Password\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private ExtendedWebElement resetBtn;

    @FindBy(xpath = "//input[@placeholder=\"Username\"]")
    private ExtendedWebElement usernameForm;

    @FindBy(xpath = "//span[text()=\"Required\"]")
    private ExtendedWebElement errorMessage;

    @FindBy(xpath = "//div[@class=\"orangehrm-card-container\"]")
    private PopUpForgetPassword popUpForgetPassword;

    public ForgetPasswordPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }

    public void fillUsernameForm(String username) {
        usernameForm.type(username);
    }

    public boolean isErrorMessagePresent() {
        return errorMessage.isElementPresent();
    }

    public PopUpForgetPassword clickResetBtn() {
        resetBtn.click();
        return popUpForgetPassword;
    }
}
