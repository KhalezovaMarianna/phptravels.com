package web.pages;

import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends AbstractPage implements IMobileUtils {

    @FindBy(xpath = "//h3[@class='title']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//input[@name='email']")
    private ExtendedWebElement emailField;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened(){
        return title.isElementPresent();
    }

    public String checkUserIsCorrect(){
        return emailField.getAttribute("value");
    }
}
