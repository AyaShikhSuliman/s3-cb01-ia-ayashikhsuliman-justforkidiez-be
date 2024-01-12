package com.example.justyourkidiez.persistence;

import com.example.justyourkidiez.persistence.entity.CoachEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<CoachEntity, Long> {
}
