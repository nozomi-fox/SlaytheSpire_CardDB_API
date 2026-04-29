package com.example.stsapi.repository;

import com.example.stsapi.entity.CardsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<CardsEntity,Integer> {
    //カード名検索
    List<CardsEntity> findByCardNameContaining(String CardName);
    //逆引き検索

    @Query("SELECT DISTINCT  c FROM CardsEntity c " +
            "LEFT JOIN c.character ch " +
            "WHERE " +
            "(:cost IS NULL OR c.cost = :cost) AND " +
            "(:rarity IS NULL OR c.rarity = :rarity) AND " +
            "(:type IS NULL OR c.cardType = :type) AND " +
            "(:charName IS NULL OR ch.characterName = :charName) AND " +
            "(:keywordName1 IS NULL OR EXISTS (SELECT k1 FROM CardsEntity c1 JOIN c1.keyword k1 WHERE c1 = c AND k1.keywordName = :keywordName1)) AND " +
            "(:keywordName2 IS NULL OR EXISTS (SELECT k2 FROM CardsEntity c2 JOIN c2.keyword k2 WHERE c2 = c AND k2.keywordName = :keywordName2))"
    )
    List<CardsEntity> searchCardsOfConditions(
            @Param("cost") String cost,
            @Param("rarity") String rarity,
            @Param("type") String type,
            @Param("charName") String charName,
            @Param("keywordName1") String keywordName1,
            @Param("keywordName2") String keywordName2
    );
}
