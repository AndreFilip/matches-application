package com.accepted_example.matches.sevices;

import com.accepted_example.matches.model.entities.MatchOdd;
import com.accepted_example.matches.repositories.MatchOddRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchOddsService {

    private final MatchOddRepository matchOddRepository;

    public List<MatchOdd> findByMatchId(Long id) {
        return this.matchOddRepository.findByMatchId(id);
    }

    public List<MatchOdd> findByMatchIdIn(List<Long> ids) {
        return this.matchOddRepository.findByMatchIdIn(ids);
    }

    public MatchOdd getMatchOdd(Long id) {
        return this.matchOddRepository.findById(id).orElseThrow();
    }
    
    public MatchOdd saveMatchOdd(MatchOdd matchOdd) {
        return this.matchOddRepository.save(matchOdd);
    }

    public void deleteMatchOdd(Long id) {
        this.matchOddRepository.deleteById(id);
    }

    public MatchOdd updateMatchOdd(Long id, MatchOdd matchOdd) {
        MatchOdd saved = this.matchOddRepository.findById(id).orElseThrow();

        matchOdd.setId(id);
        this.matchOddRepository.save(matchOdd);

        return this.matchOddRepository.findById(id).get();
    }
}
