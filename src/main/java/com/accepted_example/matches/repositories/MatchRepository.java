package com.accepted_example.matches.repositories;

import com.accepted_example.matches.model.entities.Match;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findByIdIn(List<Long> ids);

    @EntityGraph(attributePaths = { "matchOdds" })
    Optional<Match> findById(Long id);

}
