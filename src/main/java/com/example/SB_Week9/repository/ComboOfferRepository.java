package com.example.SB_Week9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ComboOfferRepository extends JpaRepository<com.example.SB_Week9.entity.ComboOffer,Long> {
}
