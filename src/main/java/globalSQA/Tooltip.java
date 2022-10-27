package globalSQA;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Tooltip extends AbstractPage {

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div/div/div[2]/div/div/div[1]/p[1]/iframe")
    private ExtendedWebElement frame;

    @FindBy(xpath = "//a[text()='Vienna, Austria']/parent::h3")
    private ExtendedWebElement textCity;

    @FindBy(xpath = "//div[@role=\"tooltip\"]")
    private ExtendedWebElement tooltip;

    public Tooltip(WebDriver driver) {
        super(driver);
    }

    public void hoverTextCity() {
        getDriver().switchTo().frame(getDriver().findElement(frame.getBy()));
        textCity.hover();
    }

    public boolean isTooltipPresent() {
        return tooltip.isElementPresent();

    }

}

