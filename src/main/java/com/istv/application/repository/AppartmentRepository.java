package com.istv.application.repository;

import com.istv.application.model.Appartment;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("appartmentRepository")
@Primary
public interface AppartmentRepository extends JpaRepository<Appartment,Integer> {
    Appartment findById(int id);

    @Query("SELECT a FROM Appartment a WHERE a.owner.id = :owner_id")
    List<Appartment> findByOwnerId(@Param("owner_id") int owner_id);
}
