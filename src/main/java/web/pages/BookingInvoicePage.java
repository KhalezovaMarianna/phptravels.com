package web.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BookingInvoicePage extends AbstractPage {

    @FindBy(xpath = "//span[@class=\"text-right\"]")
    private ExtendedWebElement reservationNumberTitle;

    @FindBy(xpath = "(//ul/li/span[contains(text(),\"Email:\")]/parent::li)[1]")
    private ExtendedWebElement usersEmail;


    public BookingInvoicePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return reservationNumberTitle.isElementPresent();
    }

    public String getUsersEmail() {
        return usersEmail.getText().substring(usersEmail.getText().lastIndexOf(' ') + 1);
    }
}
