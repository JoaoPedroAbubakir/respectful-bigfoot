package com.abubakir.example.respectfulbigfoot.repository;

import com.abubakir.example.respectfulbigfoot.entities.Membership;
import com.abubakir.example.respectfulbigfoot.entities.MembershipPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, MembershipPK> {
}
