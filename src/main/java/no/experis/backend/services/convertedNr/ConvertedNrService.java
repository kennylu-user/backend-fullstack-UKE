package no.experis.backend.services.convertedNr;

import no.experis.backend.models.ConvertedNr;
import no.experis.backend.services.CrudService;

public interface ConvertedNrService extends CrudService<ConvertedNr,String> {
    int convert(String s);
}
