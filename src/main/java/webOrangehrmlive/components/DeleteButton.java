package webOrangehrmlive.components;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DeleteButton extends AbstractUIObject {

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-trash\"]")
    private ExtendedWebElement deleteBtn;

    public DeleteButton(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickDeleteButton(){
        deleteBtn.click();
    }
}
