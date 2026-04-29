package com.example.stsapi.controller;

import com.example.stsapi.entity.CardsEntity;
import com.example.stsapi.entity.KeywordsEntity;
import com.example.stsapi.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StsApiController {
    @Autowired
    CardsService cardsService;
//接続確認用
    @GetMapping("/")
    public String index(){
        return "This is index page!";
    }
//bot動作チェック用
    @GetMapping("/getgreet")
    public Map<String,String>greeting(){
        Map<String,String> greetmessage = new HashMap<>();
        greetmessage.put("greet","Hello!");
        return greetmessage;
    }
//全カード取得
    @GetMapping("/getAllCardsInfo")
    public List<CardsEntity> getAllCardInfo() {
        cardsService.getAllCardInfo();
        return cardsService.getAllCardInfo();
    }
//カード名検索
    @GetMapping("/name")
    public List<CardsEntity> searchCardName(@RequestParam("name")String name){
        return cardsService.searchCardName(name);
    }
//逆引き検索
    @GetMapping("/search")
    public List<CardsEntity>serchCardConditions(
            @RequestParam(required = false)String cost,
            @RequestParam(required = false)String rarity,
            @RequestParam(required = false)String type,
            @RequestParam(required = false)String charname,
            @RequestParam(required = false)String keyword1,
            @RequestParam(required = false)String keyword2)
    {
        System.out.println("Receive:"+cost+"/"+rarity+"/"+charname+"/"+type+"/"+keyword1+"/"+keyword2);
        return cardsService.searchCardsFOfConditions(cost,rarity,charname,type,keyword1,keyword2);
    }
//キーワードリスト出力
    @GetMapping("/keywords")
    public List<KeywordsEntity> getAllKeywords(){
        return cardsService.getAllKeywordsInfo();
    }
}
