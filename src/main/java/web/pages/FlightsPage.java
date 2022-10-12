package web.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.components.Footer;
import web.components.Header;

public class FlightsPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"fadein\"]/header/div")
    private Header header;

    @FindBy(xpath = "//*[@id=\"fadein\"]/section[4]")
    private Footer footer;


    public FlightsPage(WebDriver driver) {
        super(driver);
    }


    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }
}
