package nl.matchinglink.showyourskills.domain;

public class DateResponse {
    private String isLeap;
    private String dayNumberInTheYear;
    private String weekNumber;

    private String daysUntilNextCatholicChristmas;
    private String daysUntilNextEasternOrthodoxChristmas;

    private String daysUntilNow;

    private String traditionalDatesConstellation;


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


    public String getIsLeap() {
        return isLeap;
    }

    public String getDayNumberInTheYear() {
        return dayNumberInTheYear;
    }

    public String getWeekNumber() {
        return weekNumber;
    }

    public String getDaysUntilNextCatholicChristmas() {
        return daysUntilNextCatholicChristmas;
    }

    public String getDaysUntilNextEasternOrthodoxChristmas() {
        return daysUntilNextEasternOrthodoxChristmas;
    }

    public String getDaysUntilNow() {
        return daysUntilNow;
    }

    public String getTraditionalDatesConstellation() {
        return traditionalDatesConstellation;
    }
}
