package webOrangehrmlive.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MyInfoPage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"orangehrm-edit-employee-imagesection\"]")
    private ExtendedWebElement title;

    public MyInfoPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }
}
