package webOrangehrmlive.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.components.DeleteButton;
import webOrangehrmlive.components.EditButton;
import webOrangehrmlive.components.HeaderMenu;
import webOrangehrmlive.pages.adminPages.AddUserPage;
import webOrangehrmlive.pages.adminPages.ChangeProfilePage;
import webOrangehrmlive.pages.adminPages.CorporateBrandingPage;
import webOrangehrmlive.pages.leavePage.ApplyPage;

public class AdminPage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"oxd-topbar-header\"]")
    private HeaderMenu headerMenu;
    @FindBy(xpath = "//i[@class=\"oxd-icon bi-caret-down-fill\"]")
    private ExtendedWebElement systemsUsersFilter;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
    private ExtendedWebElement usernameForm;

    @FindBy(xpath = "//span[@class=\"oxd-text oxd-text--span\"]")
    private ExtendedWebElement countSearchTitle;

    @FindBy(xpath = "(//div[@role=\"cell\"])[2]")
    private ExtendedWebElement searchElementName;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-trash\"]")
    private DeleteButton deleteBtn;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-pencil-fill\"]")
    private EditButton editButton;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--ghost\"]")
    private ExtendedWebElement resetBtn;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
    private ExtendedWebElement addBtn;

    @FindBy(xpath = "//span[text()=\"More \"]")
    private ExtendedWebElement moreBtn;

    @FindBy(xpath = "//a[text()=\"Corporate Branding\"]")
    private ExtendedWebElement corporateBrandingBtn;


    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return systemsUsersFilter.isElementPresent();
    }

    public CorporateBrandingPage clickCorporateBranding(){
        moreBtn.clickIfPresent();
        corporateBrandingBtn.click();
        return new CorporateBrandingPage(getDriver());
    }

    public void fillUsernameField(String username) {
        systemsUsersFilter.clickIfPresent();
        usernameForm.type(username);
    }

    public void clickSearchButton() {
        searchBtn.click();
    }

    public String getSearchCount() {
        return countSearchTitle.getText().replaceAll("[^0-9]", "");
    }

    public String getSearchUsername() {
        return searchElementName.getText();
    }

    public DeleteButton getDeleteButton(){
        return deleteBtn;
    }

    public EditButton clickEditButton(){
        return editButton;
    }

    public void clickResetButton(){
        resetBtn.click();
    }
    public AddUserPage clickAddButton(){
        addBtn.click();
        return new AddUserPage(getDriver());
    }
}
