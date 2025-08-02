package com.keyin.GolfTournament.member;

import com.keyin.GolfTournament.tournament.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByNameContainingIgnoreCase(String name);

    List<Member> findByPhoneNumberContaining(String phoneNumber);

    List<Member> findByMembershipDuration(int duration);

    @Query("SELECT m FROM Member m JOIN m.tournaments t WHERE t.startDate = :startDate")
    List<Member> findByTournamentStartDate(Date startDate);
}
