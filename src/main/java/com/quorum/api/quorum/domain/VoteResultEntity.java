package com.quorum.api.quorum.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vote_results")
public class VoteResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //TODO: verificar esse mapeamento amanhã, quando fiz isso já estava com sono
    @OneToOne
    @JoinColumn(name="sponsor_id")
    private LegislatorEntity legislator;

    //TODO: verificar esse mapeamento amanhã, quando fiz isso já estava com sono
    @OneToOne
    @JoinColumn(name="vote_id")
    private VoteEntity vote;


    @Column(name = "creation_timestamp")
    private LocalDateTime creationTime;

    @Column(name = "last_updated_timestamp")
    private LocalDateTime lastUpdatedTime;
}
