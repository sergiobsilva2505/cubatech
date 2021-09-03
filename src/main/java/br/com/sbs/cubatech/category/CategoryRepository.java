package br.com.sbs.cubatech.category;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByStatus(Status status);

    Optional<Category> findByUrlCode(String urlCode);

    @Query(value = """
            SELECT category.name, count(c.id) AS quantityOfCourses FROM category 
            LEFT JOIN subCategory sc ON category.id = sc.category_id 
            LEFT JOIN course c ON sc.id = c.subCategory_id 
            GROUP BY category.name 
            ORDER BY count(c.id) DESC;
            """, nativeQuery = true)
    List<CategoryProjection> findCategoriesQuantityOfCourses();

    @Query(value = """
        SELECT DISTINCT c FROM Category c 
        JOIN FETCH c.subCategories s
        JOIN s.courses co 
        WHERE c.status = 'ACTIVE'
        AND s.status = 'ACTIVE' 
        AND co.courseVisibility = 'PUBLIC'
        ORDER BY c.orderInSystem, s.orderInSystem        
        """)
    List<Category> findActiveCategoriesWithActiveSubCategoriesAndPublicCourses();

    boolean existsByUrlCode(String urlCode);

    @Deprecated
    boolean existsByUrlCodeAndIdNot(String urlCode, Long id);

    default boolean existsByUrlCodeWithDifferentId(String urlCode, Long id){
        return existsByUrlCodeAndIdNot(urlCode, id);
    }

}
