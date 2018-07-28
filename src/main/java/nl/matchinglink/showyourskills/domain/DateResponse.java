package nl.matchinglink.showyourskills.domain;

public class DateResponse {
    public String isLeap;
    public String dayNumberInTheYear;
    public String weekNumber;

    public String daysUntilNextCatholicChristmas;
    public String daysUntilNextEasternOrthodoxChristmas;

    public String daysUntilNow;

    public String traditionalDatesConstellation;


    public void setIsLeap(String isLeap) {
        this.isLeap = isLeap;
    }

    public void setDayNumberInTheYear(String dayNumberInTheYear) {
        this.dayNumberInTheYear = dayNumberInTheYear;
    }

    public void setWeekNumber(String weekNumber) {
        this.weekNumber = weekNumber;
    }

    public void setDaysUntilNextCatholicChristmas(String daysUntilNextCatholicChristmas) {
        this.daysUntilNextCatholicChristmas = daysUntilNextCatholicChristmas;
    }

    public void setDaysUntilNextEasternOrthodoxChristmas(String daysUntilNextEasternOrthodoxChristmas) {
        this.daysUntilNextEasternOrthodoxChristmas = daysUntilNextEasternOrthodoxChristmas;
    }

    public void setDaysUntilNow(String daysUntilNow) {
        this.daysUntilNow = daysUntilNow;
    }

    public void setTraditionalDatesConstellation(String traditionalDatesConstellation) {
        this.traditionalDatesConstellation = traditionalDatesConstellation;
    }
}
