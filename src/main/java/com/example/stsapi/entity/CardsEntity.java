package com.example.stsapi.entity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cards")
public class CardsEntity {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardID")
    private Integer cardID;

    @Getter
    @Column(name = "cardName", nullable = false)
    private String cardName;

    @Getter
    @Column(name = "cardType", nullable = false)
    private String cardType;

    @Getter
    @Column
    private String rarity;

    @Getter
    @Column(nullable = false)
    private String cost;

    @Getter
    @Column(nullable = false)
    private String effect;

    @Getter
    @Column(name = "upgraded_Card_ID")
    private Integer upgradedCardId;

    @ManyToOne
    @JoinColumn(name = "characterID")
    private CharactersEntity character;

    @ManyToMany
    @JoinTable(
            name = "card-keywords",
            joinColumns = @JoinColumn(name = "cardID"),
            inverseJoinColumns = @JoinColumn(name = "keywordID")
    )
    List<KeywordsEntity> keyword = new ArrayList<>();

}

