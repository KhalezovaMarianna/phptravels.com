package webOrangehrmlive.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.utils.utils.ColorUtils;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-list oxd-topbar-header-hamburger\"]")
    private ExtendedWebElement hamburgerMenuBtn;

    @FindBy(xpath = "//img[@alt=\"profile picture\"]")
    private ExtendedWebElement profileLabelBtn;


    @FindBy(xpath = "//a[text()=\"%s\"]")
    private ExtendedWebElement profileBtn;

    @FindBy(xpath = "//p[@class=\"oxd-userdropdown-name\"]")
    private ExtendedWebElement profileName;

    @FindBy(xpath = "//div[@class=\"oxd-topbar-header-title\"]")
    private ExtendedWebElement header;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void openHamburgerMenu() {
        hamburgerMenuBtn.clickIfPresent();
    }

    public void clickProfileLabelButton() {
        profileLabelBtn.click();
    }

    public void clickProfileButtons(String button){
        profileBtn.format(button).click();
    }

    public String getFirstName(){
        String str = profileName.format("firstName").getText();
        return str.substring(0, str.indexOf(" "));
    }

    public int getPixels(){
        return ColorUtils.colorOptions(getDriver(),header);
    }

    public String getLastName(){
        String str = profileName.format("lastName").getText();
        return str.substring(str.indexOf(" ")+1);
    }

}
