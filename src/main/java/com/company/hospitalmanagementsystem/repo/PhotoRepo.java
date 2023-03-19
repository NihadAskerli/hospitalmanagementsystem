package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PhotoRepo extends JpaRepository<Photo, Long> {
    Photo getById(Long id);

    //    List<Photo>getAll();
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update Photo p set p.url = :url where p.fileName = :fileName")
    void updateUrl(@Param("fileName") String fileName , @Param("url") String url);
}
