package com.accepted_example.matches.repositories;

import com.accepted_example.matches.model.entities.MatchOdd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchOddRepository extends JpaRepository<MatchOdd, Long> {

    List<MatchOdd> findByMatchId(Long id);

    List<MatchOdd> findByMatchIdIn(List<Long> ids);
}
