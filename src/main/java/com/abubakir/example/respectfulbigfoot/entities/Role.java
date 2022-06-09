package com.abubakir.example.respectfulbigfoot.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, unique = false)
    private String roleName;
    //3 pre-defined, is expandable?

}
