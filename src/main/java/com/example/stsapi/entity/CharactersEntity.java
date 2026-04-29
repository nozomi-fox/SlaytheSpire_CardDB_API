package com.example.stsapi.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "characters")
public class CharactersEntity {
    @Id
    @Column(name = "characterID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter

    private int characterID;
    @Column(name = "characterName")
    @Getter
    private String characterName;
}
