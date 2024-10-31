package com.example.SB_Week9.repository;

import com.example.SB_Week9.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
