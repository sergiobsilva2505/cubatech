package br.com.sbs.cubatech.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository <SubCategory, Long> {

    List<SubCategory> findByUrlCode(String urlCode);
}
