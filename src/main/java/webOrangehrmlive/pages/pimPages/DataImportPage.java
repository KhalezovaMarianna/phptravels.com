package webOrangehrmlive.pages.pimPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DataImportPage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"orangehrm-card-container\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//input[@type=\"file\"]")
    private ExtendedWebElement fileForm;

    @FindBy(xpath = "//span[text()=\"File type not allowed\"]")
    private ExtendedWebElement errorMessage;

    public DataImportPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }
    public void downloadFile() {
        fileForm.attachFile("/Users/mkhalezova/IdeaProjects/Phptravel.com/src/main/resources/resume.txt");
    }

    public boolean isErrorMessagePresent(){
        return errorMessage.isElementPresent();
    }


}
