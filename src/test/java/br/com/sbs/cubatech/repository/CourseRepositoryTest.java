package br.com.sbs.cubatech.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.sbs.cubatech.course.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CourseRepositoryTest {

    private CourseRepository courseRepository;

    public CourseRepositoryTest(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Test
    public void contextLoads(){
        assertTrue(true);
    }
}
