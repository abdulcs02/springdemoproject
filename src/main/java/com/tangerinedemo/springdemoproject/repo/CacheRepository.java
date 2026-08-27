package com.tangerinedemo.springdemoproject.repo;

import com.tangerinedemo.springdemoproject.domain.Cache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CacheRepository extends JpaRepository<Cache, Long> {

    @Query("SELECT c FROM Cache c WHERE c.key = :key")
    Optional<Cache> get(String key);

    @Query("DELETE FROM Cache c WHERE c.key = :key")
    void delete(String key);

    @Query("DELETE FROM Cache")
    void clear();

}
