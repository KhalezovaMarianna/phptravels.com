package webOrangehrmlive.pages.leavePage;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ApplyPage extends AbstractPage {

    @FindBy(xpath = "//h6[text()=\"Apply Leave\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private ExtendedWebElement saveBtn;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"]")
    private ExtendedWebElement selectBtn;

    @FindBy(xpath = "//div[@role=\"option\"]/span[text()=\"CAN - Bereavement\"]")
    private ExtendedWebElement selectType;

    @FindBy(xpath = "(//i[@class=\"oxd-icon bi-calendar oxd-date-input-icon\"])[1]")
    private ExtendedWebElement firstCalendar;

    @FindBy(xpath = "(//i[@class=\"oxd-icon bi-calendar oxd-date-input-icon\"])[2]")
    private ExtendedWebElement secondCalendar;

    public ApplyPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }

    public void clickSaveButton(){
        saveBtn.click();
    }
    public void selectLeaveType(){
        selectBtn.click();
        selectType.click();
    }

    public CalendarPage clickFirstCalendar(){
        firstCalendar.click();
        return new CalendarPage(getDriver());
    }

    public CalendarPage clickSecondCalendar(){
        secondCalendar.click();
        return new CalendarPage(getDriver());
    }



}
