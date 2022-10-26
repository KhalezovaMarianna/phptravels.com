package webOrangehrmlive.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.components.DeleteButton;
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

    @FindBy(xpath = "//a[text()=\"%s\"]")
    private ExtendedWebElement configurationAnyBtn;

    @FindBy(xpath = "//li[@class=\"oxd-topbar-body-nav-tab --parent\"]")
    private ExtendedWebElement configurationBtn;

    @FindBy(xpath = "//button[text()=\" Add \"]")
    private ExtendedWebElement addBtn;

    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
    private ExtendedWebElement idForm;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//div/span[@class=\"oxd-text oxd-text--span\"]")
    private ExtendedWebElement countSearchTitle;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-trash\"]")
    private DeleteButton deleteBtn;

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

    public void clickPimButtons(String button) {
        configurationBtn.clickIfPresent();
        configurationAnyBtn.format(button).click();
    }

    public AddEmployeePage clickAddButton() {
        addBtn.click();
        return new AddEmployeePage(getDriver());
    }

    public void fillIDForm(String id) {
        idForm.type(id);
    }

    public void clickSearchButton() {
        searchBtn.click();
    }

    public String getSearchCount() {
        return countSearchTitle.getText().replaceAll("[^0-9]", "");
    }

    public DeleteButton getDeleteBtn(){
        return deleteBtn;
    }
}
