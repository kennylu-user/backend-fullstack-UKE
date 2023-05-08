package no.experis.backend.models.dto.convertedNr;

import lombok.Data;
import no.experis.backend.models.Logs;

import java.util.Set;

@Data
public class ConvertedNrDTO {

    private String id;
    private Set<String> logs;
    private int converted;
}
