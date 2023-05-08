package no.experis.backend.mappers;


import no.experis.backend.models.ConvertedNr;
import no.experis.backend.models.Logs;
import no.experis.backend.models.dto.convertedNr.ConvertedNrDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ConvertedNrMapper {

    @Mapping(target = "logs", source = "logs", qualifiedByName = "logsToIds")
    public abstract ConvertedNrDTO convertedNrToConvertedNrDto(ConvertedNr cn);
    public abstract Collection<ConvertedNrDTO> convertedNrToConvertedNrDto(Collection<ConvertedNr> cn);

    @Named("logsToIds")
    Set<String> map(Set<Logs> source) {
        if (source == null) return null;
        return source.stream().map(p -> p.getTimeStamp()
        ).collect(Collectors.toSet());
    }
}
