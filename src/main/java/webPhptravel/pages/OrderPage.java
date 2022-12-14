package webPhptravel.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends AbstractPage {

    @FindBy(xpath = "//h3[text()=\"Your Personal Information\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//label[@for=\"agreechb\"]")
    private ExtendedWebElement continuingBtn;

    @FindBy(xpath = "//input[contains(@name, \"%s\")]")
    private ExtendedWebElement textField;

    @FindBy(xpath = "//button[@id=\"booking\"]")
    private ExtendedWebElement confirmBookingBtn;

    @FindBy(xpath = "(//li/strong)[1]")//TODO locator
    private ExtendedWebElement totalPrice;

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }

    public BookingInvoicePage clickConfirmBookingButton() {
        continuingBtn.click();
        confirmBookingBtn.click();
        return new BookingInvoicePage(getDriver());
    }

    public void fillFirstNameField(String firstName) {
        textField.format("firstname").type(firstName);
    }

    public void fillLastNameField(String lastName) {
        textField.format("lastname").type(lastName);
    }

    public void fillEmailField(String email) {
        textField.format("email").type(email);
    }

    public void fillPhoneField(String phone) {
        textField.format("phone").type(phone);
    }

    public void fillAddressField(String address) {
        textField.format("address").type(address);
    }

    public String getTotalPrice(){return totalPrice.getText().substring(4);}//TODO number or string

}
