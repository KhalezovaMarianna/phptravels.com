package webOrangehrmlive.utils.services;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import webOrangehrmlive.components.HamburgerMenu;
import webOrangehrmlive.components.HeaderMenu;
import webOrangehrmlive.pages.PimPage;
import webOrangehrmlive.utils.enums.HamburgerButtonsEnum;

public class NavigationService implements IDriverPool{

    public void goToHamburgerButtonsPage(HamburgerButtonsEnum hamburgerButtonsEnum){
        PimPage pimPage = new PimPage(getDriver());
        HamburgerMenu hamburgerMenu = pimPage.getHamburgerMenu();
        hamburgerMenu.openDifferencePages(hamburgerButtonsEnum.getButton());
    }

    public void goToPimButtonsPage(String button){
        PimPage pimPage = new PimPage(getDriver());
        pimPage.clickPimButtons(button);
    }

    public void goToHeaderMenuButtonsPage(String button){
        PimPage pimPage = new PimPage(getDriver());
        HeaderMenu headerMenu = pimPage.getHeaderMenu();
        headerMenu.clickProfileLabelButton();
        headerMenu.clickProfileButtons(button);
    }
}
