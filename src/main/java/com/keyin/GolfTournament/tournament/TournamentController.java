package com.keyin.GolfTournament.tournament;

import com.keyin.GolfTournament.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @PostMapping
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return tournamentService.createTournament(tournament);
    }

    @PutMapping("/{tournamentId}/add-member/{memberId}")
    public Tournament addMemberToTournament(
            @PathVariable Long tournamentId,
            @PathVariable Long memberId
    ) {
        return tournamentService.addMemberToTournament(tournamentId, memberId);
    }

    @GetMapping("/search/by-start-date")
    public List<Tournament> searchByStartDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate) {
        return tournamentService.searchByStartDate(startDate);
    }

    @GetMapping("/search/by-location")
    public List<Tournament> searchByLocation(@RequestParam String location) {
        return tournamentService.searchByLocation(location);
    }

    @GetMapping("/{tournamentId}/members")
    public List<Member> getMembersInTournament(@PathVariable Long tournamentId) {
        return tournamentService.getMembersInTournament(tournamentId);
    }
}
