package webOrangehrmlive.pages.pimPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DataImportPage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"orangehrm-card-container\"]")
    private ExtendedWebElement title;

    public DataImportPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }
}
