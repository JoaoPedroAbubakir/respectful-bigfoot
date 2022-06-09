package com.abubakir.example.respectfulbigfoot.service;

import com.abubakir.example.respectfulbigfoot.entities.Membership;
import com.abubakir.example.respectfulbigfoot.entities.MembershipPK;
import com.abubakir.example.respectfulbigfoot.exception.NoEntityFoundException;
import com.abubakir.example.respectfulbigfoot.repository.MembershipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MembershipService {

    MembershipRepository membershipRepository;

    public Membership createMembership(Membership membership) {
        return membershipRepository.save(membership);
    }

    public Membership getMembership(MembershipPK membershipPK) {
        return membershipRepository.findById(membershipPK).orElse(null);
    }

    public Membership updateMembership(Membership membership) {
        return membershipRepository.findById(membership.getId()).map(this::createMembership).orElseThrow(() -> new NoEntityFoundException("Could not find membership"));
    }

    public List<Membership> getMemberships() {
        return membershipRepository.findAll();
    }

    public boolean deleteMembership(MembershipPK membershipPK) {
        membershipRepository.delete(this.getMembership(membershipPK));
        return this.getMembership(membershipPK) == null;
    }

}
