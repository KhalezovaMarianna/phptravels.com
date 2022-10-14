package webOrangehrmlive.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.components.HamburgerMenu;
import webOrangehrmlive.components.HeaderMenu;
import webOrangehrmlive.pages.pimPages.*;

public class PimPage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"oxd-topbar-header\"]")
    private HeaderMenu headerMenu;

    @FindBy(xpath = "//div[@class=\"oxd-sidepanel-body\"]")
    private HamburgerMenu hamburgerMenu;

    @FindBy(xpath = "//div[@class=\"oxd-table-filter\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "(//a[@role=\"menuitem\"])[%s]")
    private ExtendedWebElement configurationAnyBtn;

    @FindBy(xpath = "//li[@class=\"oxd-topbar-body-nav-tab --parent\"]")
    private ExtendedWebElement configurationBtn;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-three-dots-vertical\"]")
    private ExtendedWebElement moreBtn;

    @FindBy(xpath = "(//a[@class=\"oxd-topbar-body-nav-tab-link --more\"])[%s]")
    private ExtendedWebElement moreAnyBtn;

    public PimPage(WebDriver driver) {
        super(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public HamburgerMenu getHamburgerMenu() {
        return hamburgerMenu;
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }

    public AddEmployeePage clickAddEmployeeButton(){
        moreBtn.clickIfPresent();
        moreAnyBtn.format("1").click();
        return new AddEmployeePage(getDriver());
    }

    public ReportsPage clickReportsButton(){
        moreBtn.clickIfPresent();
        moreAnyBtn.format("2").click();
        return new ReportsPage(getDriver());
    }

    public OptionalPage clickOptionalButton(){
        configurationBtn.clickIfPresent();
        configurationAnyBtn.format("1").click();
        return new OptionalPage(getDriver());
    }

    public CustomFieldsPage clickCustomFieldsButton(){
        configurationBtn.clickIfPresent();
        configurationAnyBtn.format("2").click();
        return new CustomFieldsPage(getDriver());
    }

    public DataImportPage clickDataImportButton(){
        configurationBtn.clickIfPresent();
        configurationAnyBtn.format("3").click();
        return new DataImportPage(getDriver());
    }

    public ReportingMethodsPage clickReportingMethodsButton(){
        configurationBtn.clickIfPresent();
        configurationAnyBtn.format("4").click();
        return new ReportingMethodsPage(getDriver());
    }

    public TerminationReasonsPage clickTerminationReasonsButton(){
        configurationBtn.clickIfPresent();
        configurationAnyBtn.format("5").click();
        return new TerminationReasonsPage(getDriver());
    }
}
