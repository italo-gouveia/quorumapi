package com.quorum.api.quorum.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "legislators")
public class LegislatorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "bills")
    private List<BillEntity> bills;

    @Column(name = "creation_timestamp")
    private LocalDateTime creationTime;

    @Column(name = "last_updated_timestamp")
    private LocalDateTime lastUpdatedTime;

}
