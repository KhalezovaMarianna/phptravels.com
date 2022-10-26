package testsOrangehrmlive.pagesTests;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import testsOrangehrmlive.base.BaseTest;
import webOrangehrmlive.components.DeleteButton;
import webOrangehrmlive.pages.LeavePage;
import webOrangehrmlive.pages.PimPage;
import webOrangehrmlive.pages.adminPages.PopUpDeletePage;
import webOrangehrmlive.pages.leavePage.ApplyPage;
import webOrangehrmlive.pages.leavePage.CalendarPage;
import webOrangehrmlive.pages.pimPages.*;
import webOrangehrmlive.utils.SearchedDate;
import webOrangehrmlive.utils.enums.ButtonsEnum;

public class PimPageTests extends BaseTest {
    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckPIMButtonsIsWork() {
        authorisationService.login();
        navigationService.goToPimButtonsPage(ButtonsEnum.ADD_EMPLOYEE.getButton());
        AddEmployeePage addEmployeePage = new AddEmployeePage(getDriver());
        Assert.assertTrue(addEmployeePage.isOpened(), "Add employee page isn't opened");
        navigationService.goToPimButtonsPage(ButtonsEnum.REPORTS.getButton());
        ReportsPage reportsPage = new ReportsPage(getDriver());
        Assert.assertTrue(reportsPage.isOpened(), "Reports page isn't opened");
        navigationService.goToPimButtonsPage(ButtonsEnum.OPTIONAL_FIELDS.getButton());
        OptionalPage optionalPage = new OptionalPage(getDriver());
        Assert.assertTrue(optionalPage.isOpened(), "Optional page isn't opened");
        navigationService.goToPimButtonsPage(ButtonsEnum.DATA_IMPORT.getButton());
        DataImportPage dataImportPage = new DataImportPage(getDriver());
        Assert.assertTrue(dataImportPage.isOpened(), "Data import page isn't opened");
        navigationService.goToPimButtonsPage(ButtonsEnum.REPORTING_METHODS.getButton());
        ReportingMethodsPage reportingMethodsPage = new ReportingMethodsPage(getDriver());
        Assert.assertTrue(reportingMethodsPage.isOpened(), "Reporting Methods page isn't opened");
        navigationService.goToPimButtonsPage(ButtonsEnum.CUSTOM_FIELDS.getButton());
        CustomFieldsPage customFieldsPage = new CustomFieldsPage(getDriver());
        Assert.assertTrue(customFieldsPage.isOpened(), "Custom fields page isn't opened");
        navigationService.goToPimButtonsPage(ButtonsEnum.TERMINATION_REASONS.getButton());
        TerminationReasonsPage terminationReasonsPage = new TerminationReasonsPage(getDriver());
        Assert.assertTrue(terminationReasonsPage.isOpened(), "Termination Reasons page isn't opened");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckDownloadingFile() {
        authorisationService.login();
        navigationService.goToPimButtonsPage(ButtonsEnum.DATA_IMPORT.getButton());
        DataImportPage dataImportPage = new DataImportPage(getDriver());
        Assert.assertTrue(dataImportPage.isOpened(), "Data import page isn't opened");
        dataImportPage.downloadFile();
        Assert.assertTrue(dataImportPage.isErrorMessagePresent(), "File is download");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCalendar() {
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.LEAVE);
        LeavePage leavePage = new LeavePage(getDriver());
        Assert.assertTrue(leavePage.isOpened(), "Page isn't opened");
        ApplyPage applyPage = leavePage.clickApplyButton();
        Assert.assertTrue(applyPage.isOpened(), "Apply page isn't opened");
        applyPage.selectLeaveType();
        CalendarPage calendarPage = applyPage.clickFirstCalendar();
        SearchedDate date = new SearchedDate(12, "September", 2020);
        calendarPage.choiceDate(date);
        applyPage.clickSecondCalendar();
        calendarPage.choiceDate(date);
        applyPage.clickSaveButton();
        Assert.assertTrue(applyPage.isOpened(), "Page isn't opened");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckAddEmployee() {
        authorisationService.login();
        PimPage pimPage = new PimPage(getDriver());
        AddEmployeePage addEmployeePage = pimPage.clickAddButton();
        addEmployeePage.fillNameForm(R.TESTDATA.get("TEST_FIRSTNAME"));
        addEmployeePage.fillLastNameForm(R.TESTDATA.get("TEST_LASTNAME"));
        addEmployeePage.fillIDForm(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"), "2002");
        addEmployeePage.clickSaveButton();
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(getDriver());
        Assert.assertTrue(personalDetailsPage.isOpened(), "Personal details page isn't opened");
        Assert.assertEquals(personalDetailsPage.getProfileName(), "Marianna Khalezova", "Employee isn't correct");
    }

    @Test()
    @MethodOwner(owner = "Marianna")
    public void testCheckFindEndDeleteCreatedEmployeeByID() {
        authorisationService.login();
        addPersonsService.addEmployee();
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(getDriver());
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.PIM);
        PimPage pimPage = new PimPage(getDriver());
        pimPage.fillIDForm("2020");
        pimPage.clickSearchButton();
        Assert.assertEquals(pimPage.getSearchCount(), "1", "Search isn't correct");
        DeleteButton deleteButton =pimPage.getDeleteBtn();
         deleteButton.clickDeleteButton();
        PopUpDeletePage popUpDeletePage =new PopUpDeletePage(getDriver());
        popUpDeletePage.clickDeleteButton();
        Assert.assertNotEquals(pimPage.getSearchCount(), "1", "Delete isn't work");
    }
}
