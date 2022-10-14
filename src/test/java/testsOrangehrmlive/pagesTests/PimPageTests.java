package testsOrangehrmlive.pagesTests;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import testsOrangehrmlive.base.BaseTest;
import webOrangehrmlive.pages.PimPage;
import webOrangehrmlive.pages.pimPages.*;

public class PimPageTests extends BaseTest {
    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckPIMButtonsIsWork(){
        PimPage pimPage = authorisationService.login();
        AddEmployeePage addEmployeePage = pimPage.clickAddEmployeeButton();
        Assert.assertTrue(addEmployeePage.isOpened(),"Add employee page isn't opened");
        ReportsPage reportsPage=pimPage.clickReportsButton();
        Assert.assertTrue(reportsPage.isOpened(),"Reports page isn't opened");
        OptionalPage optionalPage=pimPage.clickOptionalButton();
//        Assert.assertTrue(optionalPage.isOpened(),"Optional page isn't opened");
        CustomFieldsPage customFieldsPage =pimPage.clickCustomFieldsButton();
        Assert.assertTrue(customFieldsPage.isOpened(),"Custom fields page isn't opened");
        DataImportPage dataImportPage =pimPage.clickDataImportButton();
        Assert.assertTrue(dataImportPage.isOpened(),"Data import page isn't opened");
        ReportingMethodsPage reportingMethodsPage=pimPage.clickReportingMethodsButton();
        Assert.assertTrue(reportingMethodsPage.isOpened(),"Reporting Methods page isn't opened");
        TerminationReasonsPage terminationReasonsPage =pimPage.clickTerminationReasonsButton();
        Assert.assertTrue(terminationReasonsPage.isOpened(),"Termination Reasons page isn't opened");
    }
}
