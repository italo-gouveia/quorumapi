package com.quorum.api.quorum.application.gateway;

import com.quorum.api.quorum.domain.LegislatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegislatorGateway extends JpaRepository<LegislatorEntity, String> {

}
