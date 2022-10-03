package testsPhptravels.headerTests;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.components.Header;
import web.pages.HomePage;
import web.utils.enums.CurrencyEnum;
import web.utils.enums.LanguagesEnum;

public class HeaderTests extends AbstractTest {

    @Test
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testCheckChosenLanguageIsCorrect() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        header.openBurgerMenu();
        header.selectLanguage(LanguagesEnum.ENGLISH);
        Assert.assertEquals(header.checkChosenLanguage(),LanguagesEnum.ENGLISH.getLanguage().toUpperCase(),"Chosen language isn't correct");
        header.selectLanguage(LanguagesEnum.TURKISH);
        Assert.assertEquals(header.checkChosenLanguage(),LanguagesEnum.TURKISH.getLanguage().toUpperCase(),"Chosen language isn't correct");
//        header.choiceLanguage(LanguagesEnum.RUSSIAN);
//        Assert.assertEquals(header.checkChosenLanguage(),LanguagesEnum.RUSSIAN.getLanguage().toUpperCase(),"Chosen language isn't correct");
//        header.choiceLanguage(LanguagesEnum.PHILIPPINE);
//        Assert.assertEquals(header.checkChosenLanguage(),LanguagesEnum.PHILIPPINE.getLanguage().toUpperCase(),"Chosen language isn't correct");
//        header.choiceLanguage(LanguagesEnum.KOREAN);
//        Assert.assertEquals(header.checkChosenLanguage(),LanguagesEnum.KOREAN.getLanguage().toUpperCase(),"Chosen language isn't correct");
//        header.choiceLanguage(LanguagesEnum.KHMER);
//        Assert.assertEquals(header.checkChosenLanguage(),LanguagesEnum.KHMER.getLanguage().toUpperCase(),"Chosen language isn't correct");
//        header.choiceLanguage(LanguagesEnum.INDONESIA);
//        Assert.assertEquals(header.checkChosenLanguage(),LanguagesEnum.INDONESIA.getLanguage().toUpperCase(),"Chosen language isn't correct");
//        header.choiceLanguage(LanguagesEnum.FRENCH);
//        Assert.assertEquals(header.checkChosenLanguage(),LanguagesEnum.FRENCH.getLanguage().toUpperCase(),"Chosen language isn't correct");
//        header.choiceLanguage(LanguagesEnum.SPANISH);
//        Assert.assertEquals(header.checkChosenLanguage(),LanguagesEnum.SPANISH.getLanguage().toUpperCase(),"Chosen language isn't correct");
//        header.choiceLanguage(LanguagesEnum.GERMAN);
//        Assert.assertEquals(header.checkChosenLanguage(),LanguagesEnum.GERMAN.getLanguage().toUpperCase(),"Chosen language isn't correct");
//        header.choiceLanguage(LanguagesEnum.CHINESE);
//        Assert.assertEquals(header.checkChosenLanguage(),LanguagesEnum.CHINESE.getLanguage().toUpperCase(),"Chosen language isn't correct");
    }


    @Test
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testCheckChosenCurrencyIsCorrect() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        header.openBurgerMenu();
//        Currency currency=header.clickCurrency();
//        homePage=currency.choiceCurrency(CurrencyEnum.CNY);
//        header.choiceCurrency(CurrencyEnum.CNY);
        Assert.assertEquals(header.checkChosenCurrency(), CurrencyEnum.CNY,"currency isn't correct");

    }




}
