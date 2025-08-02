package com.keyin.GolfTournament.tournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    List<Tournament> findByStartDate(Date startDate);

    List<Tournament> findByLocationContainingIgnoreCase(String location);

    @Query("SELECT t.participants FROM Tournament t WHERE t.id = :tournamentId")
    List<com.keyin.GolfTournament.member.Member> findParticipantsByTournamentId(Long tournamentId);
}
