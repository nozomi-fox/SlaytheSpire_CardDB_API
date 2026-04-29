package com.example.stsapi.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "keywords")
public class KeywordsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keywordID")
    @Getter
    private int keywordID;

    @Getter
    @Column(name = "keywordName")
    private String keywordName;

    @ManyToMany(mappedBy = "keyword")
    private List<CardsEntity> cards =new ArrayList<>();
}
