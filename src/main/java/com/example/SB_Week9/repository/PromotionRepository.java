package com.example.SB_Week9.repository;

import com.example.SB_Week9.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Long> {
    @Query("SELECT p FROM Promotion p WHERE p.promotionType = :promotionType AND p.promotionDescription = :promotionDescription")
    List<Promotion> findByPromotionTypeAndDeAndPromotionDescription(String promotionType, String promotionDescription);
}
