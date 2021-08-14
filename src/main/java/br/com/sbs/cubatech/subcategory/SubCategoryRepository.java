package br.com.sbs.cubatech.subcategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    List<SubCategory> findByCategoryUrlCode(String urlCode);

    @Override
    Optional<SubCategory> findById(Long id);

    SubCategory findByUrlCode(String urlCode);

}
