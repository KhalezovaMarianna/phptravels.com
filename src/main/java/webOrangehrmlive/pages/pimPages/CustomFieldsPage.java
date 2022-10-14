package webOrangehrmlive.pages.pimPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CustomFieldsPage extends AbstractPage {

    @FindBy(xpath = "//h6[@class=\"oxd-text oxd-text--h6 orangehrm-main-title\"]")
    private ExtendedWebElement title;

    public CustomFieldsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened(){return title.isElementPresent();}
}
