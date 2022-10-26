package webOrangehrmlive.pages.pimPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage extends AbstractPage {

    @FindBy(xpath = "//h6[text()=\"Add Employee\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//input[@name=\"firstName\"]")
    private ExtendedWebElement nameForm;

    @FindBy(xpath = "//input[@name=\"lastName\"]")
    private ExtendedWebElement lastnameForm;

    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
    private ExtendedWebElement idForm;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private ExtendedWebElement saveBtn;

    @FindBy(xpath = "//span[text()=\"Required\"]")
    private ExtendedWebElement errorMessage;


    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }

    public void fillIDForm(By by, String text) {
//        idForm.getElement().sendKeys("");
        WebElement element = driver.findElement(by);
        Actions navigator = new Actions(driver);
        navigator.click(element)
                .sendKeys(Keys.END)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.HOME)
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("2020")
                .perform();
    }

    public void fillNameForm(String name) {
        nameForm.type(name);
    }

    public void fillLastNameForm(String lastname) {
        lastnameForm.type(lastname);
    }

    public void clickSaveButton() {
        saveBtn.click();
    }

    public boolean isErrorMessagePresent() {
        return errorMessage.isElementPresent();
    }

}
