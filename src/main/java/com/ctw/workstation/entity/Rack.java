package com.ctw.workstation.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="T_RACK")
public class Rack extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Column(name = "SERIAL_NUMBER",length = 20)
    public String serialNumber;

    @Column(name = "DEFAULT_LOCATION")
    public String defaultLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TEAM_ID")
    public Team team;

    @Column(name="IS_RESERVED")
    public boolean isReserved;

    @CreationTimestamp
    @Column(name="CREATED_AT")
    public LocalDateTime createdAt;

    public Rack(UUID id, String serialNumber, String defaultLocation, Team team, boolean isReserved) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.defaultLocation = defaultLocation;
        this.team = team;
        this.isReserved = isReserved;
    }

    public Rack() {
    }

    @Override
    public String toString() {
        return "Rack{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", defaultLocation='" + defaultLocation + '\'' +
                ", team=" + team.id +
                ", isReserved=" + isReserved +
                ", createdAt=" + createdAt +
                '}';
    }
}
