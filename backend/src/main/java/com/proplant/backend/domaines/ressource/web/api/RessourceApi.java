package com.proplant.backend.domaines.ressource.web.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import com.proplant.backend.api_wide_pack.error_handler.ApiErrorDto;
import com.proplant.backend.domaines.ressource.repository.entity.Ressource;
import com.proplant.backend.domaines.ressource.web.dto.RessourceRequestDTO;
import com.proplant.backend.domaines.ressource.web.dto.RessourceResponseDTO;

import org.springframework.http.ResponseEntity;

public interface RessourceApi {
    @Operation(summary = "Request to get a new ressource")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Rssource get successful",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Ressource.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request - Invalid request or validation failed.",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class))),
        @ApiResponse(responseCode = "404", description = "No content found",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class)))})
    @GetMapping(path = "/{ressourceId}", produces = {APPLICATION_JSON_VALUE})
    ResponseEntity<RessourceResponseDTO> getRessources(@Parameter(in = ParameterIn.PATH, required = true)  @PathVariable Long ressourceId);  

    @Operation(summary = "Request to get list ressource")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ressource get successful",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Ressource.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request - Invalid request or validation failed.",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class))),
        @ApiResponse(responseCode = "404", description = "No content found",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class)))})
    @GetMapping(path = "/all", produces = {APPLICATION_JSON_VALUE})
    ResponseEntity<List<RessourceResponseDTO>> listRessources();


    @Operation(summary = "Request to post a new ressource ")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ressource post successful",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Ressource.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request - Invalid request or validation failed.",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class))),
        @ApiResponse(responseCode = "404", description = "No content found",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class)))})
    @PostMapping(path = "/new", produces = {APPLICATION_JSON_VALUE})
    ResponseEntity<RessourceResponseDTO> newRessource(@RequestBody RessourceRequestDTO RessourceRequestDTO);  



@Operation(summary = "Request to delete a new ressource ")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ressource delete successful",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Ressource.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request - Invalid request or validation failed.",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class))),
        @ApiResponse(responseCode = "404", description = "No content found",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class)))})
    @PostMapping(path = "/delete/{ressourceId}", produces = {APPLICATION_JSON_VALUE})
    ResponseEntity<Void> deleteRessource(@PathVariable Long ressourceId); 

    
}
