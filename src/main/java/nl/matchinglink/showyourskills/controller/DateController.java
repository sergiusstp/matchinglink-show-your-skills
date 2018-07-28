package nl.matchinglink.showyourskills.controller;

import nl.matchinglink.showyourskills.domain.DateDocument;
import nl.matchinglink.showyourskills.domain.DateResponse;
import nl.matchinglink.showyourskills.service.DateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/")
public class DateController {

    private final DateService dateService;
    public DateController(DateService dateService) {
        this.dateService = dateService;
    }

    @PostMapping(value = "/date", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DateResponse> getInformationForDate(@RequestBody DateDocument document) {

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

        DateResponse dateResponse = dateService.getDateDetails(localDate);
        return new ResponseEntity<>(dateResponse, HttpStatus.OK);

    }

}
