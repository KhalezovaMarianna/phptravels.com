package testsPhptravels.componentsTests;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.components.Footer;
import web.components.Header;
import web.pages.FlightsPage;
import web.pages.HomePage;
import web.utils.enums.LanguagesEnum;


public class ComponentsTests extends AbstractTest {

    @Test
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testCheckHeaderIsPresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        header.openBurgerMenu();
        Assert.assertTrue(header.checkTitleIsPresent(), "Title isn't present");
    }

    @Test
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testCheckFooterIsPresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Footer footer = homePage.getFooter();
        Assert.assertTrue(footer.checkCommunityFormIsPresent(), "Community form isn't present");
        Assert.assertTrue(footer.checkLogoIsPresent(), "logo isn't present");
        Assert.assertTrue(footer.checkMessengerLabelsArePresent(), "Messengers labels aren't present");
        Assert.assertTrue(footer.checkServicesButtonsArePresent(), "Services buttons aren't present");
    }


    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckFeedbackIsWorkNegative() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        FlightsPage  flightsPage = header.clickFlightsButton();
        Footer footer = flightsPage.getFooter();
        footer.clickSubscribeButton();
        Assert.assertNotEquals(footer.getConfirmationText(),"Email exist","Email is correct and community form is work");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckLanguageIsCorrect() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        header.openBurgerMenu();
        header.clickLanguageButton();
        header.setLanguage(LanguagesEnum.TURKISH, homePage);
        Assert.assertEquals(header.getLanguage(), LanguagesEnum.TURKISH, "The language is specified incorrectly");
    }
}
