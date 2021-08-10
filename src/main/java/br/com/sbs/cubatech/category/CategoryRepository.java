package br.com.sbs.cubatech.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT c FROM Category c WHERE c.status = 'ACTIVE' ")
    List<Category> findByStatus(Status status);

    Optional<Category> findByUrlCode(String urlCode);
}
