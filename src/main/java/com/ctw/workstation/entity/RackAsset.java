package com.ctw.workstation.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="T_RACK_ASSET")
public class RackAsset extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "ASSET_TAG",unique = true,length = 20, nullable = false)
    private String assetTag;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "RACK_ID",updatable=false,insertable=false,nullable=false)
    private Rack rack;
    @Column(name="RACK_ID")
    private UUID rackId;

    public RackAsset() {
    }
}
