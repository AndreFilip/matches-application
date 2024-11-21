package com.accepted_example.matches.model.entities;

import com.accepted_example.matches.model.enums.SpecifierType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "match_odds", uniqueConstraints = { @UniqueConstraint(columnNames = { "match_id", "specifier" }) })
@Getter
@Setter
public class MatchOdd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "match_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Match match;

    private SpecifierType specifier;

    private Double odd;
}
