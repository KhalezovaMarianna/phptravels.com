package webOrangehrmlive.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DirectoryPage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"oxd-table-filter-header\"]")
    private ExtendedWebElement title;

    public DirectoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }


}
