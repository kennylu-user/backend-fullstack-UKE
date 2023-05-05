package no.experis.backend.mappers;


import no.experis.backend.models.ConvertedNr;
import no.experis.backend.models.dto.convertedNr.ConvertedNrDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class ConvertedNrMapper {

    public abstract ConvertedNrDTO convertedNrToConvertedNrDto(ConvertedNr cn);
    public abstract Collection<ConvertedNrDTO> convertedNrToConvertedNrDto(Collection<ConvertedNr> cn);
}
