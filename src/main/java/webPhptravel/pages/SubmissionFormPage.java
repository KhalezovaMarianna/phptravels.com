package webPhptravel.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SubmissionFormPage extends AbstractPage {

    @FindBy(xpath = "//h3[@class=\"title\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//button[@id=\"submit\"]")
    private ExtendedWebElement submitBtn;

    @FindBy(xpath = "//h5[@class=\"text-white wow fadeIn sub-title animated animated text-center mt-3\"]")//??? `TODO locator
    private ExtendedWebElement data;

    @FindBy(xpath = "//div[@class=\"card panel-primary\"]/div/h2")
    private ExtendedWebElement submitSuccessText;


    public SubmissionFormPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }

    public void clickSubmitButton() {
        submitBtn.click();
    }

    public String getData() {
        return data.getText();
    }

    public String getSuccessSubmitText() {
        return submitSuccessText.getText();
    }

}
