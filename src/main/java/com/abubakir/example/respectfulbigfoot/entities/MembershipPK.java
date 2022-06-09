package com.abubakir.example.respectfulbigfoot.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MembershipPK implements Serializable {
    private static final long serialVersionUID = 2443086424664158151L;

    @OneToOne(optional = false)
    @JoinColumn(name = "team_id", nullable = false)
    private Team teamId;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;
}
