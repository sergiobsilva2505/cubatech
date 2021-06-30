package br.com.sbs.cubatech.reader;

import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.course.CourseVisibility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CoursesFileReader {

    public List<Course> readCourses(Map<String, SubCategory> subCategories) throws IOException {

        List<Course> courseList = new ArrayList<>();

        var bufferedReader = new BufferedReader(new FileReader("Curso.csv"));

        bufferedReader.readLine();
        String line = bufferedReader.readLine();

        while ( line != null){

            String[] courseColumnValues = line.split(",");

            String name = courseColumnValues[0];
            String courseUrlCode = courseColumnValues[1];
            Integer timeToFinishInHours = courseColumnValues[2].equals("")? null : Integer.parseInt(courseColumnValues[2]);
            CourseVisibility courseVisibility = courseColumnValues[3].equals("PRIVADA")? CourseVisibility.PRIVATE : CourseVisibility.PUBLIC;
            String targetAudience = courseColumnValues[4];
            String instructor = courseColumnValues[5];
            String summary = courseColumnValues[6];
            String skillsDeveloped = courseColumnValues[7];
            String subCategoryUrlCode = courseColumnValues[8];

            if(!subCategories.isEmpty()){
                Course course = new Course(name, courseUrlCode, timeToFinishInHours, courseVisibility, targetAudience,  instructor, summary, skillsDeveloped,  subCategories.get(subCategoryUrlCode));
                courseList.add(course);

            }

            line = bufferedReader.readLine();
        }

        bufferedReader.close();

        return courseList;

    }
}
