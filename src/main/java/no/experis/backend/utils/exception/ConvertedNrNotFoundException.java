package no.experis.backend.utils.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ConvertedNrNotFoundException extends RuntimeException{
    public ConvertedNrNotFoundException(String id){

        super(String.format("Roman %s not found",id));
    }
}
