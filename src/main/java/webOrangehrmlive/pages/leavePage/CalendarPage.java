package webOrangehrmlive.pages.leavePage;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.utils.CalendarUtils;
import webOrangehrmlive.utils.SearchedDate;

import java.util.List;
import java.util.stream.Collectors;

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

    public String choiceDate(SearchedDate date) {
        CalendarUtils calendarUtils = new CalendarUtils();
        calendarUtils.choiceDate(date.getMonth(), date.getYear());
        List<ExtendedWebElement> days = numbers.stream().filter(f -> f.getText().equals(String.valueOf(date.getNumber()))).collect(Collectors.toList());
                days.get(0).click();
            searchedDate = days.get(0).getText() + " " + chosenMonthBtn.getText();

        return searchedDate;
    }

    public String getMonth(){
        return chosenMonthBtn.getText();
    }

    public String getYear(){
        return chosenYearBtn.getText();
    }

    public void clickPreviousButton(){
        previousMonth.click();
    }

    public void clickNextButton(){
        nextMonth.click();
    }

}
