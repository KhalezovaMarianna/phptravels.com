package webOrangehrmlive.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.pages.leavePage.ApplyPage;
import webOrangehrmlive.pages.leavePage.CalendarPage;

public class LeavePage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"oxd-table-filter\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//a[text()=\"Apply\"]")
    private ExtendedWebElement applyBtn;




    public LeavePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }

    public ApplyPage clickApplyButton(){
        applyBtn.click();
        return new ApplyPage(getDriver());
    }


}
