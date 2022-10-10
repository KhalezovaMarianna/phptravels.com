package web.pages;

import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage implements IMobileUtils {

    @FindBy(xpath = "//a[@data-scroll=\"description\"]")
    private ExtendedWebElement hotelsDetailsBtn;

    @FindBy(xpath = "(//button[@type=\"submit\"])[1]")
    private ExtendedWebElement bookNowFirstBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened(){
        return hotelsDetailsBtn.isElementPresent();
    }

    public OrderPage clickBookNow(){
        bookNowFirstBtn.click();
        return new OrderPage(getDriver());
    }


}
