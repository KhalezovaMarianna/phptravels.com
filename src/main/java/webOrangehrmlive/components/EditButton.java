package webOrangehrmlive.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EditButton extends AbstractUIObject{

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-pencil-fill\"]")
    private ExtendedWebElement editBtn;

    public EditButton(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickEditButton(){
        editBtn.click();
    }
}
