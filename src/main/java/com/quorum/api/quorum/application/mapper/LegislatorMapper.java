package com.quorum.api.quorum.application.mapper;

import com.quorum.api.quorum.application.dto.LegislatorDTO;
import com.quorum.api.quorum.domain.LegislatorEntity;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface LegislatorMapper {

    LegislatorEntity map(LegislatorDTO dto);

    LegislatorDTO mapToDto(LegislatorEntity pokemon);

    List<LegislatorDTO> mapToDto(List<LegislatorEntity> pokemon);
}
