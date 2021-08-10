package br.com.sbs.cubatech.subcategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    List<SubCategory> findByCategoryUrlCode(String urlCode);

}
