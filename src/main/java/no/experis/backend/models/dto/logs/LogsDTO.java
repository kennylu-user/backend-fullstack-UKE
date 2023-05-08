package no.experis.backend.models.dto.logs;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import no.experis.backend.models.ConvertedNr;

@Data
public class LogsDTO {
    private int id;
    private String timeStamp;
//    private String romanNr;
    private String convertedNr;
}
