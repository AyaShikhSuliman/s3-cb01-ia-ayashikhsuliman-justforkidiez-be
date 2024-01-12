package com.example.justyourkidiez.persistence;

import com.example.justyourkidiez.persistence.entity.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParentRepository extends JpaRepository<ParentEntity, Long> {
    ParentEntity findByName(String name);
    boolean existsByName(String name);
    List<ParentEntity> findAllByCourse_TitleOrderByNameAsc(String courseTitle);

//    select avg(age) as "AverageAgeOfParents"
//    from parent
    //getAverageAgeOfParents
}
