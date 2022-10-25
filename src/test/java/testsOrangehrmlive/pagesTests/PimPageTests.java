package testsOrangehrmlive.pagesTests;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import testsOrangehrmlive.base.BaseTest;
import webOrangehrmlive.pages.AdminPage;
import webOrangehrmlive.pages.LeavePage;
import webOrangehrmlive.pages.leavePage.ApplyPage;
import webOrangehrmlive.pages.leavePage.CalendarPage;
import webOrangehrmlive.pages.pimPages.*;
import webOrangehrmlive.utils.SearchedDate;
import webOrangehrmlive.utils.enums.HamburgerButtonsEnum;
import webOrangehrmlive.utils.enums.PimButtonsEnum;

public class PimPageTests extends BaseTest {
    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckPIMButtonsIsWork(){
        authorisationService.login();
        navigationService.goToPimButtonsPage(PimButtonsEnum.ADD_EMPLOYEE.getButton());
        AddEmployeePage addEmployeePage =new AddEmployeePage(getDriver());
        Assert.assertTrue(addEmployeePage.isOpened(),"Add employee page isn't opened");
        navigationService.goToPimButtonsPage(PimButtonsEnum.REPORTS.getButton());
        ReportsPage reportsPage=new ReportsPage(getDriver());
        Assert.assertTrue(reportsPage.isOpened(),"Reports page isn't opened");
        navigationService.goToPimButtonsPage(PimButtonsEnum.OPTIONAL_FIELDS.getButton());
        OptionalPage optionalPage =new OptionalPage(getDriver());
        Assert.assertTrue(optionalPage.isOpened(),"Optional page isn't opened");
        navigationService.goToPimButtonsPage(PimButtonsEnum.DATA_IMPORT.getButton());
        DataImportPage dataImportPage = new DataImportPage(getDriver());
        Assert.assertTrue(dataImportPage.isOpened(),"Data import page isn't opened");
        navigationService.goToPimButtonsPage(PimButtonsEnum.REPORTING_METHODS.getButton());
        ReportingMethodsPage reportingMethodsPage =new ReportingMethodsPage(getDriver());
        Assert.assertTrue(reportingMethodsPage.isOpened(),"Reporting Methods page isn't opened");
        navigationService.goToPimButtonsPage(PimButtonsEnum.CUSTOM_FIELDS.getButton());
        CustomFieldsPage customFieldsPage =new CustomFieldsPage(getDriver());
        Assert.assertTrue(customFieldsPage.isOpened(),"Custom fields page isn't opened");
        navigationService.goToPimButtonsPage(PimButtonsEnum.TERMINATION_REASONS.getButton());
        TerminationReasonsPage terminationReasonsPage =new TerminationReasonsPage(getDriver());
        Assert.assertTrue(terminationReasonsPage.isOpened(),"Termination Reasons page isn't opened");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckDownloadingFile(){
       authorisationService.login();
       navigationService.goToPimButtonsPage(PimButtonsEnum.DATA_IMPORT.getButton());
       DataImportPage dataImportPage = new DataImportPage(getDriver());
       Assert.assertTrue(dataImportPage.isOpened(),"Data import page isn't opened");
       dataImportPage.downloadFile();
       Assert.assertTrue(dataImportPage.isErrorMessagePresent(),"File is download");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCalendar(){
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(HamburgerButtonsEnum.LEAVE);
        LeavePage leavePage =new LeavePage(getDriver());
        Assert.assertTrue(leavePage.isOpened(),"Page isn't opened");
        ApplyPage applyPage = leavePage.clickApplyButton();
        Assert.assertTrue(applyPage.isOpened(),"Apply page isn't opened");
        applyPage.selectLeaveType();
        CalendarPage calendarPage =applyPage.clickFirstCalendar();
        SearchedDate date = new SearchedDate(12,"September",2020);
        calendarPage.choiceDate(date);
        applyPage.clickSecondCalendar();
        calendarPage.choiceDate(date);
        applyPage.clickSaveButton();
        Assert.assertTrue(applyPage.isOpened(),"Page isn't opened");
    }

}
