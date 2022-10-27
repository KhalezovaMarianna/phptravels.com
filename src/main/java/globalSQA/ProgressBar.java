package globalSQA;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.components.EditButton;

public class ProgressBar extends AbstractPage {
    static final Logger LOGGER = LogManager.getLogger(ProgressBar.class);

    @FindBy(xpath = "//button[@id=\"downloadButton\"]")
    private ExtendedWebElement startDownloadBtn;

    @FindBy(xpath = "(//iframe)[4]")
    private ExtendedWebElement frame;

    @FindBy(xpath = "//div[@class=\"progress-label\"]")
    private ExtendedWebElement downloadingProcessText;

    public ProgressBar(WebDriver driver) {
        super(driver);
    }

    public void clickStartDownloadingBtn() {
        getDriver().switchTo().frame(getDriver().findElement(frame.getBy()));
        startDownloadBtn.click();
    }

    public boolean checkProcessDownloading() {
        pause(20);
        if (downloadingProcessText.getText().equals("Complete!")) {
            return true;
        } else
            return false;
    }
}