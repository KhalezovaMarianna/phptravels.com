package webOrangehrmlive.pages.adminPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.components.HeaderMenu;

public class CorporateBrandingPage extends AbstractPage {

    @FindBy(xpath = "(//div[@class=\"oxd-color-input-preview\"])[5]")
    private ExtendedWebElement colorOne;

    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
    private ExtendedWebElement colorForm;

    @FindBy(xpath = "(//div[@class=\"oxd-color-input-preview\"])[6]")
    private ExtendedWebElement colorTwo;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private ExtendedWebElement saveBtn;

    @FindBy(xpath = "//label[text()=\"Keep Current\"]")
    private ExtendedWebElement successDownloadingTitle;

    @FindBy(xpath = "//div[@class=\"oxd-topbar-header\"]")
    private HeaderMenu headerMenu;

    @FindBy(xpath = "(//input[@type=\"file\"])[1]")
    private ExtendedWebElement downloadFileForm;

    public CorporateBrandingPage(WebDriver driver) {
        super(driver);
    }

    public void clickSaveButton() {
        saveBtn.click();
    }

    public void changeColorOne(String color) {
        colorOne.click();
        colorForm.getElement().clear();
        pause(1);
        colorForm.type(color);
    }

    public void changeColorTwo(String color) {
        colorTwo.click();
        colorForm.getElement().clear();
        pause(1);
        colorForm.type(color);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public void downloadFile() {
        downloadFileForm.attachFile("/Users/mkhalezova/IdeaProjects/Phptravel.com/src/main/resources/Screenshot 2022-10-21 at 10.34.17.png");
    }

    public boolean checkDownloadingImage() {

        return successDownloadingTitle.isElementPresent();
    }
}
