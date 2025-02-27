package com.ctw.workstation.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="T_BOOKING")
public class Booking extends PanacheEntityBase {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   public UUID id;
   @ManyToOne
   @JoinColumn(name = "RACK_ID")
   public Rack rack;
   @ManyToOne
   @JoinColumn(name = "REQUESTER_ID")
   public TeamMember requester;
   @Column(name = "BOOK_FROM")
   public LocalDateTime bookFrom;
   @Column(name = "BOOK_TO")
   public LocalDateTime bookTo;
   @CreationTimestamp
   @Column(name="CREATED_AT")
   public LocalDateTime createdAt;
   @UpdateTimestamp
   @Column(name="MODIFIED_AT")
   public LocalDateTime updatedAt;

    public Booking() {
    }
}
