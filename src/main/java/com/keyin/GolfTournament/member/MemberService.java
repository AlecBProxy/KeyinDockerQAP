package com.keyin.GolfTournament.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> searchByName(String name) {
        return memberRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Member> searchByPhone(String phone) {
        return memberRepository.findByPhoneNumberContaining(phone);
    }

    public List<Member> searchByMembershipDuration(int duration) {
        return memberRepository.findByMembershipDuration(duration);
    }

    public List<Member> searchByTournamentStartDate(Date startDate) {
        return memberRepository.findByTournamentStartDate(startDate);
    }
}
