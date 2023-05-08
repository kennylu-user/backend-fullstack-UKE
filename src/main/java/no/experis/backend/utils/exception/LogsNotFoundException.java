package no.experis.backend.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class LogsNotFoundException extends RuntimeException{
    public LogsNotFoundException(int id){

            super(String.format("Logs %d not found",id));
    }
}
