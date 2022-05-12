package com.proplant.backend.domaines.account.web.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.security.Principal;
import java.util.List;

import com.proplant.backend.api_wide_pack.error_handler.ApiErrorDto;
import com.proplant.backend.domaines.account.repository.entity.Register;
import com.proplant.backend.domaines.account.web.dto.UserResponseDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface AccountApi {
    @Operation(summary = "Request to post a new user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User post successful",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Register.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request - Invalid request or validation failed.",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class))),
        @ApiResponse(responseCode = "404", description = "No content found",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class)))})
    @PostMapping(path = "/register", produces = {APPLICATION_JSON_VALUE})
    ResponseEntity<UserResponseDTO> register(@Parameter(in = ParameterIn.PATH, required = true)  @RequestBody Register register);  

    @Operation(summary = "Request to get user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User get successful",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request - Invalid request or validation failed.",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class))),
        @ApiResponse(responseCode = "404", description = "No content found",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class)))})
    @GetMapping(path = "/profile", produces = {APPLICATION_JSON_VALUE})
    ResponseEntity<UserResponseDTO> profile(@Parameter(in = ParameterIn.PATH, required = true) Principal principal);  

    @Operation(summary = "Request to get list user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List User get successful",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request - Invalid request or validation failed.",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class))),
        @ApiResponse(responseCode = "404", description = "No content found",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class)))})
    @GetMapping(path = "/list", produces = {APPLICATION_JSON_VALUE})
    ResponseEntity<List<UserResponseDTO>> getAllUsers();

    @Operation(summary = "Request to get list user by username")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List User get successful",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request - Invalid request or validation failed.",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class))),
        @ApiResponse(responseCode = "404", description = "No content found",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class)))})
    @GetMapping(path = "/list/bYusername", produces = {APPLICATION_JSON_VALUE})
    ResponseEntity<List<UserResponseDTO>> getAllUsers(@PathVariable String username);

    @Operation(summary = "Request to sort users by param")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User get successful",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request - Invalid request or validation failed.",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class))),
        @ApiResponse(responseCode = "404", description = "No content found",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class)))})
    @GetMapping(path = "/list/param", produces = {APPLICATION_JSON_VALUE})
    ResponseEntity<List<UserResponseDTO>> getAllUsersSortByParam(@RequestParam(required=false) String contextId, @RequestParam(required = false) String dirdId);









}
