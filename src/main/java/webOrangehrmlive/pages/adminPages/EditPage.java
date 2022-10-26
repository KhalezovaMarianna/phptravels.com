package webOrangehrmlive.pages.adminPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.pages.AdminPage;

public class EditPage extends AbstractPage {

    @FindBy(xpath = "//h6[text()=\"Edit User\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
    private ExtendedWebElement usernameForm;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private ExtendedWebElement saveBtn;

    public EditPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened(){
        return title.isElementPresent();
    }

    public void fillUsernameForm(String username){
        usernameForm.type(username);
    }

    public AdminPage clickSaveButton(){
        saveBtn.click();
        return new AdminPage(getDriver());
    }
}
