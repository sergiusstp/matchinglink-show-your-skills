package nl.matchinglink.showyourskills.service;

import nl.matchinglink.showyourskills.domain.DateResponse;
import java.time.LocalDate;

public interface DateService {
    // POST
    DateResponse getDateDetails(LocalDate localDate);
}
