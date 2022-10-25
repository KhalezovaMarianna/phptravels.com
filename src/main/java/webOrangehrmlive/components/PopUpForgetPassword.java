package webOrangehrmlive.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PopUpForgetPassword extends AbstractUIObject {

    @FindBy(xpath = "//h6[text()=\"Reset Password\"]")
    private ExtendedWebElement title;

    public PopUpForgetPassword(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

     public boolean isOpened(){
       return title.isElementPresent();
     }
}
