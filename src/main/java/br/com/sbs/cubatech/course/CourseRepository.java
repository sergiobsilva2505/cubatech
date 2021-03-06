package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.subcategory.SubCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value ="""
            SELECT instructor, COUNT(*) AS quantityOfCourses
            FROM course 
            GROUP BY instructor 
            ORDER BY quantityOfCourses DESC 
            LIMIT 1 
            """ , nativeQuery = true)
    List<CourseProjection> findInstructorWithMoreCourses();

    Page<Course> findAllBySubCategory(SubCategory subCategory, Pageable pageable);

    Optional<Course> findByUrlCode(String courseCode);

    boolean existsByUrlCode(String urlCode);

    @Deprecated
    boolean existsByUrlCodeAndIdNot(String urlCode, Long id);

    default boolean existsByUrlCodeWithDifferentId(String urlCode, Long id){
        return existsByUrlCodeAndIdNot(urlCode, id);
    }

}
