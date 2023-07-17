package com.example.test.model.dao;

import com.example.test.model.entity.Clicker;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Взаимодействие с Базой данных
 */
@Repository
public interface CounterRepository extends CrudRepository<Clicker, Integer> {
    @Transactional
    @Modifying
    @Query("update Clicker c set c.counter = :counter where c.id =1")
    int update(@Param("counter") String counter);

}
