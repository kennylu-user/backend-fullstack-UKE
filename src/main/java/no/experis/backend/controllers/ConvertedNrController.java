package no.experis.backend.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.experis.backend.mappers.ConvertedNrMapper;
import no.experis.backend.mappers.LogsMapper;
import no.experis.backend.models.ConvertedNr;
import no.experis.backend.services.convertedNr.ConvertedNrService;
import no.experis.backend.utils.error.ApiErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/v1/convertednr")
public class ConvertedNrController {

    private final ConvertedNrService convertedNrService;
    private final ConvertedNrMapper convertedNrMapper;
    private final LogsMapper logsMapper;

    public ConvertedNrController(ConvertedNrService convertedNrService, ConvertedNrMapper convertedNrMapper, LogsMapper logsMapper) {
        this.convertedNrService = convertedNrService;
        this.convertedNrMapper = convertedNrMapper;
        this.logsMapper = logsMapper;
    }

    @Operation(summary = "Get all converted numbers")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConvertedNr.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content ={ @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Users not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(convertedNrMapper.convertedNrToConvertedNrDto(convertedNrService.findAll()));
    }
    @Operation(summary = "Get a converted number by id")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConvertedNr.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "User not found with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable String id) {
        return ResponseEntity.ok(convertedNrMapper.convertedNrToConvertedNrDto(convertedNrService.findById(id)));
    }
    @Operation(summary = "Get a converted number logs by id")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConvertedNr.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "User not found with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("{id}/logs")
    public ResponseEntity getLogsById(@PathVariable String id) {
        return ResponseEntity.ok(logsMapper.logsToLogsDTO(convertedNrService.getLogsById(id)));
    }

}
