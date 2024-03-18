package com.quorum.api.quorum.application.usecase.legislator;

import com.quorum.api.quorum.application.dto.LegislatorDTO;
import com.quorum.api.quorum.application.gateway.LegislatorGateway;
import com.quorum.api.quorum.application.mapper.LegislatorMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Slf4j
@Service
public class GetLegislatorsUseCase {
    private final LegislatorGateway gateway;
    private final LegislatorMapper mapper;

    public List<LegislatorDTO> execute() {
        List<LegislatorDTO> legislatorDTOS = mapper.mapToDto(gateway.findAll());

        //TODO: solve problem compiling slf4j
        //log.info("M=getLegislators, message=UseCase, legislators return successfully, list={}", legislatorDTOS);

        return legislatorDTOS;
    }
}
