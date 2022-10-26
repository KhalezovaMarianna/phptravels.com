package webOrangehrmlive.utils;

import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import webOrangehrmlive.pages.leavePage.CalendarPage;

import java.util.HashMap;
import java.util.Map;

public class CalendarUtils implements IMobileUtils {
    private static Map<String, Integer> months = new HashMap();

    static {
        months.put("January", 1);
        months.put("February", 2);
        months.put("March", 3);
        months.put("April", 4);
        months.put("May", 5);
        months.put("June", 6);
        months.put("July", 7);
        months.put("August", 8);
        months.put("September", 9);
        months.put("October", 10);
        months.put("November", 11);
        months.put("December", 12);
    }

    public void choiceDate(String month, int year) {
        CalendarPage calendarPage = new CalendarPage(getDriver());
        int currentYear = Integer.parseInt(calendarPage.getYear());
        String currentMonth = calendarPage.getMonth();
        String searchedDate = month + " " + year;


        if (currentYear > year) {
            while (!(searchedDate.equals(calendarPage.getMonth()+" "+calendarPage.getYear()))) {
                calendarPage.clickPreviousButton();
            }
        } else if (currentYear < year) {
            while (!(searchedDate.equals(calendarPage.getMonth()+" "+calendarPage.getYear())))
                calendarPage.clickNextButton();
        } else {
            if (months.get(currentMonth) > months.get(month)) {
                while (!currentMonth.equals(searchedDate))
                    calendarPage.clickPreviousButton();
            } else {
                while (!currentMonth.equals(searchedDate))
                    calendarPage.clickNextButton();
            }

        }
    }
}
