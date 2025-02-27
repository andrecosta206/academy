package com.ctw.workstation.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="T_TEAM")
public class Team extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    public String name;

    public String product;

    @Column(name="DEFAULT_LOCATION")
    public String defaultLocation;

    @OneToMany(mappedBy = "team",fetch = FetchType.LAZY)
    public List<Rack> racks;

    @OneToMany(mappedBy = "teamId",fetch = FetchType.LAZY)
    public List<TeamMember> teamMembers;
//
    @CreationTimestamp
    @Column(name="CREATED_AT")
    public LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="MODIFIED_AT")
    public LocalDateTime updatedAt;

    public Team() {

    }

    public Team(UUID id, String name, String product, String defaultLocation) {
        this.id = id;
        this.name = name;
        this.product = product;
        this.defaultLocation = defaultLocation;
    }

//    public List<TeamMember> getTeamMembers() {
//        return teamMembers;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public void setRacks(List<Rack> racks) {
//        this.racks = racks;
//    }
//
//    public void setTeamMembers(List<TeamMember> teamMembers) {
//        this.teamMembers = teamMembers;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public List<Rack> getRacks() {
//        return racks;
//    }
//
//
//    public UUID getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getProduct() {
//        return product;
//    }
//
//    public String getDefaultLocation() {
//        return defaultLocation;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setProduct(String product) {
//        this.product = product;
//    }
//
//    public void setDefaultLocation(String defaultLocation) {
//        this.defaultLocation = defaultLocation;
//    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", product='" + product + '\'' +
                ", defaultLocation='" + defaultLocation + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
//                ", racks=" + racks +
//                ", teamMembers=" + teamMembers +
                '}';
    }
}
