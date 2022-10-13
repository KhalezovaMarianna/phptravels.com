package webPhptravel.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webPhptravel.components.Footer;
import webPhptravel.components.Header;

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
