package webOrangehrmlive.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.components.EditButton;

public class MaintenancePage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"orangehrm-card-container\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//button[text()=\" Cancel \"]")
    private ExtendedWebElement cancelBtn;

    @FindBy(xpath = "//button[text()=\" Confirm \"]")
    private ExtendedWebElement confirmBtn;

    @FindBy(xpath = "//h6[text()=\"Purge Employee Records\"]")
    private ExtendedWebElement mainPageTitle;
    @FindBy(xpath = "//input[@name=\"password\"]")
    private ExtendedWebElement passwordForm;

    public MaintenancePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }

    public PimPage clickCancelButton(){
        cancelBtn.click();
        return new PimPage(getDriver());
    }

    public void clickConfirmButton(){
        confirmBtn.click();
    }

    public void fillPasswordForm(String password){
        passwordForm.type(password);
    }

    public boolean mainPageIsOpened(){
       return mainPageTitle.isElementPresent();
    }
}
