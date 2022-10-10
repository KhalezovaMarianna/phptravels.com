package web.utils.services;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import org.testng.Assert;
import web.components.Header;
import web.pages.AccountPage;
import web.pages.HomePage;
import web.pages.LoginPage;

public class AuthenticationService implements IDriverPool {

    private final static String USERNAME = R.TESTDATA.get("TEST_USER");

    public AccountPage logIn() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        header.openBurgerMenu();
        header.clickAccountDropdown();
        LoginPage logInPage = header.clickCustomLoginButton();
        logInPage.fillEmailField(USERNAME);
        logInPage.fillPasswordField(R.TESTDATA.get("TEST_PASSWORD"));
        logInPage.clickLoginButton();
        return new AccountPage(getDriver());
    }
}
