package com.quorum.api.quorum.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "bills")
public class BillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name="sponsor_id")
    private LegislatorEntity legislator;

    @OneToMany(targetEntity = VoteEntity.class)
    private List<VoteEntity> votes;

    @Column(name = "creation_timestamp")
    private LocalDateTime creationTime;

    @Column(name = "last_updated_timestamp")
    private LocalDateTime lastUpdatedTime;
}
