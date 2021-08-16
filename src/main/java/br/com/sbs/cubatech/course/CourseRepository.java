package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.subcategory.SubCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value ="""
            SELECT instructor, COUNT(*) AS qttCourses
            FROM course 
            GROUP BY instructor 
            ORDER BY qttCourses DESC 
            LIMIT 1 
            """ , nativeQuery = true)
    List<CourseProjection> findInstructorWithMoreCourses();

    Page<Course> findAllBySubCategory(SubCategory subCategory, Pageable pageable);

    Course findByUrlCode(String courseCode);
}
