package com.quorum.api.quorum.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "votes")
public class VoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = BillEntity.class)
    @JoinColumn(name="bill_id")
    private List<BillEntity> bill;

    @Column(name = "creation_timestamp")
    private LocalDateTime creationTime;

    @Column(name = "last_updated_timestamp")
    private LocalDateTime lastUpdatedTime;
}
