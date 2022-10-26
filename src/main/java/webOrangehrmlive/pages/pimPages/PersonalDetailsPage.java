package webOrangehrmlive.pages.pimPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.components.HamburgerMenu;
import webOrangehrmlive.pages.adminPages.EditPage;

public class PersonalDetailsPage extends AbstractPage {

    @FindBy(xpath = "")
    private HamburgerMenu hamburgerMenu;

    @FindBy(xpath = "//h6[text()=\"Personal Details\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//h6[@class=\"oxd-text oxd-text--h6 --strong\"]")
    private ExtendedWebElement nameField;

    public PersonalDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened(){
        return title.isElementPresent();
    }

    public String getProfileName(){
        return nameField.getText();
    }

    public HamburgerMenu getHamburgerMenu(){
        return hamburgerMenu;
    }
}
