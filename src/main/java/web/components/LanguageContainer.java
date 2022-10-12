package web.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LanguageContainer extends AbstractUIObject {


    @FindBy(xpath = ".//ul/li/a")
    private ExtendedWebElement languageName;

    @FindBy(xpath = ".//a/span")
    private ExtendedWebElement languageFlag;

    public LanguageContainer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getLanguageName() {
        return languageName.getText();
    }

    public String getLanguageFlag() {
        return languageFlag.getText();
    }

    @Override
    public String toString() {
        return "LanguageContainer{" +
                "languageName=" + languageName +
                ", languageFlag=" + languageFlag +
                '}';
    }

    public void clickLanguage() {
        languageName.clickByJs();
    }
}
