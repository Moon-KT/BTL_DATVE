package com.example.SB_Week9.repository;

import com.example.SB_Week9.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion,Long> {
}
