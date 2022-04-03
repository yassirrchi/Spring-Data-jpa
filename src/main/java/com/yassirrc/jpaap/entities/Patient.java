package com.yassirrc.jpaap.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nom",length=100)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date datedenaissance;
    private boolean malade;
    private int score;
}
