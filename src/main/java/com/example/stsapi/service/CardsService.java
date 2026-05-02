package com.example.stsapi.service;


import com.example.stsapi.entity.CardsEntity;
import com.example.stsapi.entity.KeywordsEntity;
import com.example.stsapi.repository.CardRepository;
import com.example.stsapi.repository.KeywordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private KeywordsRepository keywordsRepository;
    //全カード情報取得
    public List<CardsEntity> getAllCardInfo(){
        return cardRepository.findAll();
    }
    //カード名検索
    public List<CardsEntity>searchCardName(String message){
        return cardRepository.findByCardNameContaining(message);
    }

    //全キーワード取得
    public List<KeywordsEntity> getAllKeywordsInfo(){
        return keywordsRepository.findAll();
    }
    //逆引き検索
    public List<CardsEntity> searchCardsFOfConditions(String cost, String rarity,String type,String charname, String keyword1, String keyword2){
        return cardRepository.searchCardsOfConditions(cost,rarity,charname,type,keyword1,keyword2);
    };
}
