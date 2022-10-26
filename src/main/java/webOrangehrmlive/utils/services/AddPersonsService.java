package webOrangehrmlive.utils.services;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import org.openqa.selenium.By;
import org.testng.Assert;
import webOrangehrmlive.pages.PimPage;
import webOrangehrmlive.pages.pimPages.AddEmployeePage;
import webOrangehrmlive.pages.pimPages.PersonalDetailsPage;

public class AddPersonsService implements IDriverPool {

    public void addEmployee(){
        PimPage pimPage = new PimPage(getDriver());
        AddEmployeePage addEmployeePage = pimPage.clickAddButton();
        addEmployeePage.fillNameForm(R.TESTDATA.get("TEST_FIRSTNAME"));
        addEmployeePage.fillLastNameForm(R.TESTDATA.get("TEST_LASTNAME"));
        addEmployeePage.fillIDForm(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"), "2020");
        addEmployeePage.clickSaveButton();
        PersonalDetailsPage personalDetailsPage= new PersonalDetailsPage(getDriver());
        Assert.assertTrue(personalDetailsPage.isOpened(),"Personal details page isn't opened");
    }


}
