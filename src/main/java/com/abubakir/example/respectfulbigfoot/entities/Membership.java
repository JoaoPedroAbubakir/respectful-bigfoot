package com.abubakir.example.respectfulbigfoot.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "MEMBERSHIP")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Membership {

    @EmbeddedId
    private MembershipPK id;

    @ManyToOne
    private Role role;


}
