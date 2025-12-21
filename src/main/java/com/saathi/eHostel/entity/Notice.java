package com.saathi.eHostel.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notices")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "created_by_warden_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_notice_warden")
    )
    private Warden createdByWarden;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}