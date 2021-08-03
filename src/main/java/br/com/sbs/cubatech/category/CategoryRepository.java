package br.com.sbs.cubatech.category;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT c FROM Category c WHERE c.status = 'ACTIVE' ")
    List<Category> findByStatusActive();

//    @Query(value = "SELECT c FROM Category c WHERE c.urlCode = :urlCode")
    Optional<Category> findByUrlCode(String urlCode);
}
