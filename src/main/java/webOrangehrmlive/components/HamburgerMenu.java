package webOrangehrmlive.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HamburgerMenu extends AbstractUIObject {

    @FindBy(xpath = "//a[@href=\"%s\"]")
    private ExtendedWebElement hamburgerMenuBtn;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-x oxd-sidepanel-header-close\"]")
    private ExtendedWebElement closeBtn;

    public HamburgerMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void openDifferencePages(String button) {
        hamburgerMenuBtn.format(button).click();
    }
}
