package com.example.stsapi.repository;

import com.example.stsapi.entity.KeywordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordsRepository extends JpaRepository<KeywordsEntity,Integer> {
}
