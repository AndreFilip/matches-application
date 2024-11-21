package com.accepted_example.matches.sevices;

import com.accepted_example.matches.model.entities.Match;
import com.accepted_example.matches.repositories.MatchOddRepository;
import com.accepted_example.matches.repositories.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;

    private final MatchOddRepository matchOddRepository;

    public List<Match> findAll() {
        return this.matchRepository.findAll();
    }

    public List<Match> findByIdIn(List<Long> ids) {
        return this.matchRepository.findByIdIn(ids);
    }

    public Match getMatch(Long id) {
        return this.matchRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Match saveMatch(Match match) {
        Match saved = this.matchRepository.save(match);

        if (!CollectionUtils.isEmpty(match.getMatchOdds())) {
            match.getMatchOdds().forEach(mo -> {
                mo.setMatch(saved);
                this.matchOddRepository.save(mo);
            });
        }

        return saved;
    }

    public Match updateMatch(Long id, Match match) {
       this.matchRepository.findById(id).orElseThrow();

        match.setId(id);
        this.matchRepository.save(match);

        return this.matchRepository.findById(id).get();
    }

    public void deleteMatch(Long matchId) {
        this.matchRepository.deleteById(matchId);
    }
}
