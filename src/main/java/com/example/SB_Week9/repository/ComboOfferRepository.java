package com.example.SB_Week9.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComboOfferRepository extends JpaRepository<com.example.SB_Week9.entity.ComboOffer,Long> {
    List<ComboOfferRepository> findComboOffersByMovieId(Long movieId);
}
