package web.components;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Footer extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//section//div/a/img[@alt=\"logo\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//a[@href=\"company\"]")
    private ExtendedWebElement companyBtn;

    @FindBy(xpath = "//a[@href=\"supprt\"]")
    private ExtendedWebElement supportBtn;

    @FindBy(xpath = "//input[@type=\"email\"]")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//a[@href=\"services\"]")
    private ExtendedWebElement servicesBtn;

    @FindBy(xpath = "//div[@class=\"subscriber-box\"]")
    private ExtendedWebElement communityForm;

    @FindBy(xpath = "//ul[@class=\"social-profile\"]")
    private ExtendedWebElement messengerLabels;

    @FindBy(xpath = "//div[@class=\"wow fadeIn subscriberesponse cw\"]")
    private ExtendedWebElement confirmationText;

    @FindBy(xpath = "//button[@id=\"email_subscribe\"]")
    private ExtendedWebElement subscribeBtn;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean checkLogoIsPresent() {
        return title.isElementPresent();
    }

    public boolean checkCommunityFormIsPresent() {
        return communityForm.isElementPresent();
    }

    public boolean checkMessengerLabelsArePresent() {
        return messengerLabels.isElementPresent();
    }

    public boolean checkServicesButtonsArePresent() {
        return servicesBtn.isElementPresent() && supportBtn.isElementPresent();
    }

    public void fillEmailField(String email) {
        emailField.type(email);
    }

    public String getConfirmationText() {
        return confirmationText.getAttribute("text");
    }

    public void clickSubscribeButton() {
        subscribeBtn.click();
    }

}
