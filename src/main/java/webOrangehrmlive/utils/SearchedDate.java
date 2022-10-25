package webOrangehrmlive.utils;

public class SearchedDate {
    private int number;
    private String month;
    private int year;

    public SearchedDate(int number, String month, int year) {
        this.number = number;
        this.month = month;
        this.year = year;
    }


    public int getNumber() {
        return number;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }


    public void setNumber(int number) {
        this.number = number;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return number + " " + month + " " + year;
    }
}
