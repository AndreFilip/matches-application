package com.accepted_example.matches.model.entities;

import com.accepted_example.matches.model.enums.SportType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "matches")
@Getter
@Setter
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDate matchDate;

    @Schema(description = "Start time in HH:mm format", example = "14:30", type = "string")
    private LocalTime matchTime;

    @Column(name = "team_a")
    private String teamA;

    @Column(name = "team_b")
    private String teamB;

    private SportType sportType;

    @OneToMany(mappedBy = "match", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"match"}, allowSetters = true)
    private List<MatchOdd> matchOdds;
}
