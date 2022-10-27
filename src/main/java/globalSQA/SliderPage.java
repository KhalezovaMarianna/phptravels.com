package globalSQA;

import com.qaprosoft.carina.core.foundation.utils.IWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.utils.utils.ColorUtils;

public class SliderPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"post-2673\"]/div[2]/div/div/div[1]/p/iframe")
    private ExtendedWebElement frame;

    @FindBy(xpath = "//div[@id=\"red\"]/span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"]")
    private ExtendedWebElement blueSliderBtn;

    @FindBy(id = "id=\"red\"")
    private ExtendedWebElement sliderLine;

    @FindBy(id= "id=\"swatch\"")
    private ExtendedWebElement title;
    public SliderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened(){
        return title.isElementPresent();
    }
    public int getLocationSliderLineX(){
        return sliderLine.getLocation().x/2;
    }

    public int getLocationSliderLineY(){
        return sliderLine.getLocation().y;
    }

    public ExtendedWebElement getSlideButton(){
        return blueSliderBtn;
    }
    public void slideBlueButton(){
        getDriver().switchTo().frame(getDriver().findElement(frame.getBy()));
        WebElement slider = driver.findElement(blueSliderBtn.getBy());
        Actions SliderAction = new Actions(driver);
        SliderAction.clickAndHold(slider)
                .moveByOffset(-250,0)
                .release().perform();
    }

    public int getPixels(){
        return ColorUtils.colorOptions(getDriver(),title);
    }

}
