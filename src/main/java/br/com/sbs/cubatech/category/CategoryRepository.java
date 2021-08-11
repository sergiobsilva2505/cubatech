package br.com.sbs.cubatech.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT c FROM Category c WHERE c.status = 'ACTIVE' ")
    List<Category> findByStatus(Status status);

    Optional<Category> findByUrlCode(String urlCode);

    @Query(value = "SELECT category.name, count(c.id) AS qttCourses FROM category\n" +
            "LEFT JOIN subCategory sc ON category.id = sc.category_id\n" +
            "LEFT JOIN course c ON sc.id = c.subCategory_id\n" +
            "GROUP BY category.name\n" +
            "ORDER BY count(c.id) DESC;", nativeQuery = true)
    List<CategoryProjection> findCategoriesQttCourses();


}
