package webOrangehrmlive.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.components.HeaderMenu;

public class MyInfoPage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"orangehrm-edit-employee-imagesection\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//input[@name=\"firstname\"]")
    private ExtendedWebElement nameForm;

    @FindBy(xpath = "//input[@name=\"lastname\"]")
    private ExtendedWebElement lastnameForm;

    @FindBy(xpath = "//div[@class=\"oxd-topbar-header\"]")
    private HeaderMenu headerMenu;

    public MyInfoPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }

    public String getFirstName() {
       return  nameForm.getText();
    }

    public String getLastName() {
        return lastnameForm.getText();
    }
    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }
}
