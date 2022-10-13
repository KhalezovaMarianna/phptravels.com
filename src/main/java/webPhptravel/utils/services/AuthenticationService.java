package webPhptravel.utils.services;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import webPhptravel.components.Header;
import webPhptravel.pages.AccountPage;
import webPhptravel.pages.HomePage;
import webPhptravel.pages.LoginPage;

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
