package br.com.sbs.cubatech.subcategory;

import br.com.sbs.cubatech.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    Optional<SubCategory> findByUrlCode(String urlCode);

    @Query(value = """
              SELECT DISTINCT su FROM SubCategory su 
              JOIN FETCH su.courses c
              WHERE c.courseVisibility = 'PUBLIC'
              AND su.status = 'ACTIVE'
              AND su.category = :category
               """)
    List<SubCategory> finAllActiveSubCategories(@Param("category")Category category);

    boolean existsByUrlCode(String urlCode);

    @Deprecated
    boolean existsByUrlCodeAndIdNot(String urlCode, Long id);

    default boolean existsByUrlCodeWithDifferentId(String urlCode, Long id){
        return existsByUrlCodeAndIdNot(urlCode, id);
    }

}
