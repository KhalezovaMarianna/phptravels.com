package webOrangehrmlive.pages.leavePage;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.utils.utils.CalendarUtils;
import webOrangehrmlive.utils.utils.SearchedDate;

import java.util.List;

public class CalendarPage extends AbstractPage {
    private String searchedDate;
    @FindBy(xpath = "(//button[@class=\"oxd-icon-button\"])[2]")
    private ExtendedWebElement nextMonth;

    @FindBy(xpath = "(//button[@class=\"oxd-icon-button\"])[1]")
    private ExtendedWebElement previousMonth;

    @FindBy(xpath = "//div[@class=\"oxd-calendar-selector-year-selected\"]")
    private ExtendedWebElement chosenYearBtn;

    @FindBy(xpath = "//li[@class=\"oxd-calendar-selector-month\"]")
    private ExtendedWebElement chosenMonthBtn;

    @FindBy(xpath = "//div[text()=\"%s\"]")
    private ExtendedWebElement numberDay;

    @FindBy(xpath = "//div[@class=\"oxd-calendar-date\"]")
    private List<ExtendedWebElement> numbers;

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    public void choiceDate(SearchedDate date) {
        CalendarUtils calendarUtils = new CalendarUtils();
        calendarUtils.choiceDate(date.getMonth(), date.getYear());
//        numbers.stream().forEach(e -> System.out.println(e.getText()));
        numbers.stream().filter(f -> f.getText().equals(String.valueOf(date.getNumber()))).limit(1).forEach(e -> e.click());
    }

    public String getMonth() {
        return chosenMonthBtn.getText();
    }

    public String getYear() {
        return chosenYearBtn.getText();
    }

    public void clickPreviousButton() {
        previousMonth.click();
    }

    public void clickNextButton() {
        nextMonth.click();
    }

}
