package no.experis.backend.mappers;

import no.experis.backend.models.ConvertedNr;
import no.experis.backend.models.Logs;
import no.experis.backend.models.dto.convertedNr.ConvertedNrDTO;
import no.experis.backend.models.dto.logs.LogsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class LogsMapper {

    @Mapping(target = "convertedNr", source = "convertedNr", qualifiedByName = "cnToIds")
    public abstract LogsDTO logsToLogsDTO(Logs log);
    public abstract Collection<LogsDTO> logsToLogsDTO(Collection<Logs> log);

    @Named("cnToIds")
    String map(ConvertedNr source) {
        if (source == null) return null;
        return source.getId();
    }
}

