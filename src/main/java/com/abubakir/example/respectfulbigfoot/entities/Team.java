package com.abubakir.example.respectfulbigfoot.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Team {

    @Id
    private String id;

    @Column(name = "name", nullable = false, unique = false)
    private String name;

}
