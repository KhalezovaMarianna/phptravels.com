package webOrangehrmlive.pages.adminPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.pages.AdminPage;

public class AddUserPage extends AbstractPage {

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private ExtendedWebElement saveBtn;

    @FindBy(xpath = "//span[text()=\"Required\"]")
    private ExtendedWebElement errorMessage;

    @FindBy(xpath = "//h6[text()=\"Add User\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "(//div[@class=\"oxd-select-text--after\"])[1]")
    private ExtendedWebElement userRoleForm;

    @FindBy(xpath = "//span[text()=\"ESS\"]")
    private ExtendedWebElement userRole;

    @FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
    private ExtendedWebElement employeeNameForm;

    @FindBy(xpath = "(//div[@class=\"oxd-select-text--after\"])[2]")
    private ExtendedWebElement statusForm;

    @FindBy(xpath = "//span[text()=\"Enabled\"]")
    private ExtendedWebElement selectStatus;

    @FindBy(xpath = "//label[contains(text(),'Username')]/parent::div/following-sibling::div/input")
    private ExtendedWebElement usernameForm;

    @FindBy(xpath = "(//input[@type=\"password\"])[%s]")
    private ExtendedWebElement passwordForm;

    public AddUserPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened(){
        return title.isElementPresent();
    }

    public AdminPage clickSaveButton() {
        saveBtn.click();
        return new AdminPage(getDriver());
    }

    public boolean checkSaveIsNotSuccess() {
        return errorMessage.isElementPresent();
    }

    public void fillPasswordForm(String password){
        passwordForm.format("1").type(password);
    }

    public void fillConfirmPasswordForm(String password){
        passwordForm.format("2").type(password);
    }

    public void fillUserRoleForm(){
        userRoleForm.click();
        userRole.click();
    }

    public void fillEmployeeForm(String username){
        employeeNameForm.type(username);
    }

    public void fillStatusForm(){
        statusForm.click();
        selectStatus.click();
    }

    public void fillUsernameForm(String username){
        usernameForm.type(username);
    }
}
