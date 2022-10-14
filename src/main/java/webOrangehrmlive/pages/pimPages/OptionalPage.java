package webOrangehrmlive.pages.pimPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OptionalPage extends AbstractPage {

    @FindBy(xpath = "//p[@class=\"oxd-text oxd-text--p orangehrm-main-title\"]")
    private ExtendedWebElement title;

    public OptionalPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened(){
        return title.isElementPresent();
    }
}
