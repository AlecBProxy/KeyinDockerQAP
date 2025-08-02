package com.keyin.GolfTournament.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @GetMapping("/search/by-name")
    public List<Member> searchByName(@RequestParam String name) {
        return memberService.searchByName(name);
    }

    @GetMapping("/search/by-phone")
    public List<Member> searchByPhone(@RequestParam String phone) {
        return memberService.searchByPhone(phone);
    }

    @GetMapping("/search/by-duration")
    public List<Member> searchByMembershipDuration(@RequestParam int duration) {
        return memberService.searchByMembershipDuration(duration);
    }

    @GetMapping("/search/by-tournament-start")
    public List<Member> searchByTournamentStartDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate) {
        return memberService.searchByTournamentStartDate(startDate);
    }
}
