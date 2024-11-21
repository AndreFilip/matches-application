package com.accepted_example.matches.controllers;

import com.accepted_example.matches.model.entities.MatchOdd;
import com.accepted_example.matches.sevices.MatchOddsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match-odds")
@RequiredArgsConstructor
public class MatchOddsController {

    private final MatchOddsService matchOddsService;

    @GetMapping("/getByMatchId")
    public List<MatchOdd> getByMatchId(@RequestParam(value = "id") Long id) {
        return this.matchOddsService.findByMatchId(id);
    }

    @GetMapping("/getByMatchIdIn")
    public List<MatchOdd> getByMatchIdIn(@RequestParam(value = "id") List<Long> ids) {
        return this.matchOddsService.findByMatchIdIn(ids);
    }

    @GetMapping("/{id}")
    public MatchOdd getMatchOdd(@PathVariable Long id) {
        return this.matchOddsService.getMatchOdd(id);
    }

    @PostMapping
    public MatchOdd saveMatchOdd(@RequestBody MatchOdd matchOdd) {
        return this.matchOddsService.saveMatchOdd(matchOdd);
    }

    @PutMapping("/{id}")
    public MatchOdd updateMatchOdd(@PathVariable Long id, @RequestBody MatchOdd matchOdd) {
        return this.matchOddsService.updateMatchOdd(id, matchOdd);
    }

    @DeleteMapping("/{id}")
    public void deleteMatchOdd(@PathVariable Long id) {
        this.matchOddsService.deleteMatchOdd(id);
    }

}
