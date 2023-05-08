package no.experis.backend.services.convertedNr;

import no.experis.backend.models.ConvertedNr;
import no.experis.backend.models.Logs;
import no.experis.backend.services.CrudService;

import java.util.Collection;
import java.util.Set;

public interface ConvertedNrService extends CrudService<ConvertedNr,String> {
    int convert(String s);
    Set<Logs> getLogsById(String id);
}
