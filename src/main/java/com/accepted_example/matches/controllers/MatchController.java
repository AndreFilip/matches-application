package com.accepted_example.matches.controllers;

import com.accepted_example.matches.model.entities.Match;
import com.accepted_example.matches.sevices.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @GetMapping
    public List<Match> getAllMatches() {
        return this.matchService.findAll();
    }

    @GetMapping("/getAllMatchesByIdIn")
    public List<Match> getAllMatchesByIdIn(@RequestParam(value = "id") List<Long> ids) {
        return this.matchService.findByIdIn(ids);
    }

    @GetMapping("/{id}")
    public Match getMatch(@PathVariable Long id) {
        return this.matchService.getMatch(id);
    }

    @PostMapping
    public Match saveMatch(@RequestBody Match match) {
        return this.matchService.saveMatch(match);
    }

    @PutMapping("/{id}")
    public Match updateMatch(@PathVariable Long id, @RequestBody Match match) {
        return this.matchService.updateMatch(id, match);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        this.matchService.deleteMatch(id);
    }
}
