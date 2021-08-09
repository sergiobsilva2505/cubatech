package br.com.sbs.cubatech.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository <SubCategory, Long> {

    List<SubCategory> findByCategoryUrlCode(String urlCode);
}
