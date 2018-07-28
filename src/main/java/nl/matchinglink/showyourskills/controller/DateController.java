package nl.matchinglink.showyourskills.controller;

import nl.matchinglink.showyourskills.domain.DateDocument;
import nl.matchinglink.showyourskills.domain.DateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

@RestController
@RequestMapping("/")
public class DateController {

    @PostMapping(value = "/date", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DateResponse> getInformationForDate(@RequestBody DateDocument document) {

        // get all this from DateService
        //List<String> list = searchService.getKeysByCondition(document.condition);


        // Working with LocalDate
        // Java 8 introduced new APIs for Date and Time
        // to address the shortcomings
        // of the older java.util.Date and java.util.Calendar.


        LocalDate localDate;
        try {
            localDate = LocalDate.parse(document.getDate());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        DateResponse dateResponse = new DateResponse();

        // 1. isLeap?
        boolean isLeapYear = localDate.isLeapYear();

        // old way of doing things
        // int year = localDate.getYear();
        // boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));

        if (isLeapYear)
            dateResponse.setIsLeap("yes");
        else
            dateResponse.setIsLeap("no");

        // 2. dayNumberInTheYear?
        int dayOfYear = localDate.getDayOfYear();
        //System.out.println(dayOfYear);
        dateResponse.setDayNumberInTheYear(Integer.toString(dayOfYear));

        // 3. weekNumber?

        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        int weekNumber = localDate.get(woy);
        dateResponse.setWeekNumber(Integer.toString(weekNumber));

        int year = localDate.getYear();
        // 4. daysUntilNextCatholicChristmas (Dec, 25)
        LocalDate nextCatholicChristmas = LocalDate.of(year, 12, 25);

        long untilDec25 = Duration.between(localDate.atStartOfDay(), nextCatholicChristmas.atStartOfDay()).toDays();
        if (untilDec25 < 0)
            nextCatholicChristmas = LocalDate.of(year + 1, 12, 25);

        untilDec25 = Duration.between(localDate.atStartOfDay(), nextCatholicChristmas.atStartOfDay()).toDays();
        dateResponse.setDaysUntilNextCatholicChristmas(Long.toString(untilDec25));


        // 5. daysUntilNextEasternOrthodoxChristmas (Jan, 07)
        LocalDate nextEasternOrthodoxChristmas = LocalDate.of(year, 01, 07);

        long untilJan07 = Duration.between(localDate.atStartOfDay(), nextEasternOrthodoxChristmas.atStartOfDay()).toDays();
        if (untilJan07 < 0)
            nextEasternOrthodoxChristmas = LocalDate.of(year + 1, 01, 07);

        untilJan07 = Duration.between(localDate.atStartOfDay(), nextEasternOrthodoxChristmas.atStartOfDay()).toDays();
        dateResponse.setDaysUntilNextEasternOrthodoxChristmas(Long.toString(untilJan07));


        // 6. daysUntilNow
        LocalDate today = LocalDate.now();
        long untilNow = Duration.between(localDate.atStartOfDay(), today.atStartOfDay()).toDays();

        dateResponse.setDaysUntilNow(Long.toString(untilNow));


        // 7. traditionalDatesConstellation (TRADITIONAL ASTROLOGICAL DATES)
        // repeat that like 12 times
        LocalDate aries1 = LocalDate.of(year, 3, 21).minus(1, ChronoUnit.DAYS);
        LocalDate aries2 = LocalDate.of(year, 4, 19).plus(1, ChronoUnit.DAYS);

        if (localDate.isAfter(aries1) && localDate.isBefore(aries2))
            dateResponse.setTraditionalDatesConstellation("Aries");


        LocalDate taurus1 = LocalDate.of(year, 4, 20).minus(1, ChronoUnit.DAYS);
        LocalDate taurus2 = LocalDate.of(year, 5, 20).plus(1, ChronoUnit.DAYS);

        if (localDate.isAfter(taurus1) && localDate.isBefore(taurus2))
            dateResponse.setTraditionalDatesConstellation("Taurus");


        LocalDate gemini1 = LocalDate.of(year, 5, 21).minus(1, ChronoUnit.DAYS);
        LocalDate gemini2 = LocalDate.of(year, 6, 20).plus(1, ChronoUnit.DAYS);

        if (localDate.isAfter(gemini1) && localDate.isBefore(gemini2))
            dateResponse.setTraditionalDatesConstellation("Gemini");


        LocalDate cancer1 = LocalDate.of(year, 6, 21).minus(1, ChronoUnit.DAYS);
        LocalDate cancer2 = LocalDate.of(year, 7, 22).plus(1, ChronoUnit.DAYS);

        if (localDate.isAfter(cancer1) && localDate.isBefore(cancer2))
            dateResponse.setTraditionalDatesConstellation("Cancer");





        LocalDate leo1 = LocalDate.of(year, 7, 23).minus(1, ChronoUnit.DAYS);
        LocalDate leo2 = LocalDate.of(year, 8, 22).plus(1, ChronoUnit.DAYS);

        if (localDate.isAfter(leo1) && localDate.isBefore(leo2))
            dateResponse.setTraditionalDatesConstellation("Leo");



        LocalDate virgo1 = LocalDate.of(year, 8, 23).minus(1, ChronoUnit.DAYS);
        LocalDate virgo2 = LocalDate.of(year, 9, 22).plus(1, ChronoUnit.DAYS);

        if (localDate.isAfter(virgo1) && localDate.isBefore(virgo2))
            dateResponse.setTraditionalDatesConstellation("Virgo");


        LocalDate libra1 = LocalDate.of(year, 9, 23).minus(1, ChronoUnit.DAYS);
        LocalDate libra2 = LocalDate.of(year, 10, 22).plus(1, ChronoUnit.DAYS);

        if (localDate.isAfter(libra1) && localDate.isBefore(libra2))
            dateResponse.setTraditionalDatesConstellation("Libra");


        LocalDate scorpio1 = LocalDate.of(year, 10, 23).minus(1, ChronoUnit.DAYS);
        LocalDate scorpio2 = LocalDate.of(year, 11, 21).plus(1, ChronoUnit.DAYS);

        if (localDate.isAfter(scorpio1) && localDate.isBefore(scorpio2))
            dateResponse.setTraditionalDatesConstellation("Scorpio");




        LocalDate saggitarius1 = LocalDate.of(year, 11, 22).minus(1, ChronoUnit.DAYS);
        LocalDate saggitarius2 = LocalDate.of(year, 12, 21).plus(1, ChronoUnit.DAYS);

        if (localDate.isAfter(saggitarius1) && localDate.isBefore(saggitarius2))
            dateResponse.setTraditionalDatesConstellation("Sagittarius");



        // split case
        LocalDate capricorn1 = LocalDate.of(year, 12, 22).minus(1, ChronoUnit.DAYS);
        LocalDate capricorn2 = LocalDate.of(year, 12, 31).plus(1, ChronoUnit.DAYS);

        if (localDate.isAfter(capricorn1) && localDate.isBefore(capricorn2))
            dateResponse.setTraditionalDatesConstellation("Capricorn");


        LocalDate capricorn1Fix = LocalDate.of(year, 1, 1).minus(1, ChronoUnit.DAYS);
        LocalDate capricorn2Fix = LocalDate.of(year, 1, 19).plus(1, ChronoUnit.DAYS);

        if (localDate.isAfter(capricorn1Fix) && localDate.isBefore(capricorn2Fix))
            dateResponse.setTraditionalDatesConstellation("Capricorn");




        LocalDate aquarius1 = LocalDate.of(year, 1, 20).minus(1, ChronoUnit.DAYS);
        LocalDate aquarius2 = LocalDate.of(year, 2, 18).plus(1, ChronoUnit.DAYS);

        if (localDate.isAfter(aquarius1) && localDate.isBefore(aquarius2))
            dateResponse.setTraditionalDatesConstellation("Aquarius");

        LocalDate pisces1 = LocalDate.of(year, 2, 19).minus(1, ChronoUnit.DAYS);
        LocalDate pisces2 = LocalDate.of(year, 3, 20).plus(1, ChronoUnit.DAYS);

        if (localDate.isAfter(pisces1) && localDate.isBefore(pisces2))
            dateResponse.setTraditionalDatesConstellation("Pisces");


        return new ResponseEntity<>(dateResponse, HttpStatus.OK);

    }

}
