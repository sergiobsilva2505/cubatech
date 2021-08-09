package br.com.sbs.cubatech.category;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByStatus(Status status);

    Optional<Category> findByUrlCode(String urlCode);
}
