package com.quorum.api.quorum.entrypoint.rest.controller;

import com.quorum.api.quorum.application.dto.LegislatorDTO;
import com.quorum.api.quorum.application.usecase.legislator.GetLegislatorsUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/legislator")
public class LegislatorRestController {
    private final GetLegislatorsUseCase getLegislatorsUseCase;

    public LegislatorRestController(GetLegislatorsUseCase getLegislatorsUseCase) {
        this.getLegislatorsUseCase = getLegislatorsUseCase;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LegislatorDTO>> getLegislators() {
        //TODO: solve problem compiling slf4j
        // log.info("M=getLegislators, message=Controller, request received successfully!");

        List<LegislatorDTO> pokemons = getLegislatorsUseCase.execute();
        //TODO: solve problem compiling slf4j
        // log.info("M=getLegislators, message=Controller, Legislators successfully returned");

        return ResponseEntity.ok(pokemons);
    }
}
