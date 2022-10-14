package webOrangehrmlive.pages.headerPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.pages.PimPage;

public class PopUpAboutPage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"oxd-grid-2 orangehrm-about\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//button[text()=\"×\"]")
    private ExtendedWebElement closeBtn;

    public PopUpAboutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened(){
        return title.isElementPresent();
    }

    public PimPage clickCloseButton(){
        closeBtn.click();
        return new PimPage(getDriver());
    }
}
