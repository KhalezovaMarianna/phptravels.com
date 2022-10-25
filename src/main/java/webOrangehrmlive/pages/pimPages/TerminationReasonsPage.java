package webOrangehrmlive.pages.pimPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TerminationReasonsPage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"orangehrm-header-container\"]")
    private ExtendedWebElement title;

    public TerminationReasonsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened(){return title.isElementPresent();}
}
