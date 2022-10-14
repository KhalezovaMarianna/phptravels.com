package webOrangehrmlive.pages.headerPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends AbstractPage {

    @FindBy(xpath = "//form[@class=\"oxd-form\"]")
    private ExtendedWebElement title;
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened(){
        return title.isElementPresent();
    }
}
