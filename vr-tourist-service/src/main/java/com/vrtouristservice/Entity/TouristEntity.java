package com.vrtouristservice.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tourists")
public class TouristEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long touristId;

    @Column(nullable = false)
    @Schema(example = "john", required = true)
    private String firstName;

    @Column(nullable = false)
    @Schema(example = "doe", required = true)
    private String lastName;

    @Column(nullable = false)
    @Schema(example = "Uganda", required = true)
    private String country;

    @Column
    @Schema(example = "aaaa@gmail.com", required = true)
    private String email;

    @Column(nullable = false, unique = true)
    @Schema(example = "+256787946565", required = true)
    private String telephone;

    @Column(nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private boolean status;

    @Column(nullable = false)
    @Schema(example = "john", required = true)
    private String createdBy;

    @Column(nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime whenCreated;

    @Column
    @Schema(example = "john", required = true)
    private String updatedBy;

    @Column
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime whenUpdated;
}
