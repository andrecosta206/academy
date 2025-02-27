package com.ctw.workstation.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="T_TEAM_MEMBER")
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Column(name="CTW_ID",nullable=false,unique=true,length=10)
    private String ctwId;
    @Transient
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="TEAM_ID", nullable=false, insertable=false, updatable=false)
    private Team team;
    @Column(name="TEAM_ID")
    private UUID teamId;
    @CreationTimestamp
    @Column(name="CREATED_AT")
    private Date createdAt;
    @UpdateTimestamp
    @Column(name="MODIFIED_AT")
    private Date updatedAt;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCtwId() {
        return ctwId;
    }

    public Team getTeam() {
        return team;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setCtwId(String ctwId) {
        this.ctwId = ctwId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TeamMember() {
    }
}
