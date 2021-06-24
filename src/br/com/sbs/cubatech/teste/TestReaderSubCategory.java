package br.com.sbs.cubatech.teste;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;

import java.io.IOException;
import java.util.List;

public class TestReaderSubCategory {

    public static void main(String[] args) throws IOException {

        List<Category> categoryList = CsvFileReader.readCategories();
        List<SubCategory> subCategoryList = CsvFileReader.readSubCategories();
        List<Course> courseList = CsvFileReader.readCourses();

//        categoryList.forEach(System.out::println);
//        subCategoryList.forEach(System.out::println);
        courseList.forEach(System.out::println);
    }

//    static List<SubCategory> readSubcategories() throws IOException {
//
//        List<Category> categoryList = TestReaderCategory.readCategories();
//
//        String file = "Subcategoria.csv";
//        List<SubCategory> listSubCategory = new ArrayList<>();
//
//        var bufferedReader = new BufferedReader(new FileReader(file));
//
//        String headerLine = bufferedReader.readLine().toUpperCase();
//        String line = bufferedReader.readLine();
//
//        String[] columnsName = headerLine.split(",");
//
//        while (line != null ){
//
//            String[] valuesSubCategoryColumns = line.split(",");
//
//            String name = valuesSubCategoryColumns[0];
//            String urlCode = valuesSubCategoryColumns[1];
//            Integer order = valuesSubCategoryColumns[2] == "" ? null : Integer.parseInt(valuesSubCategoryColumns[2]);
//            String description = valuesSubCategoryColumns[3];
//            Boolean active = valuesSubCategoryColumns[4] == "ATIVA" ? true : false;
//            String categoryUrlCode = valuesSubCategoryColumns[5];
//
//
//            Optional<Category> category = categoryList.stream()
//                    .filter(category1 -> category1.getUrlCode().equals(categoryUrlCode))
//                    .findAny();
//            if(!category.isEmpty()){
//                SubCategory subCategory = new SubCategory(name, urlCode, order, description,active, category.get());
//                listSubCategory.add(subCategory);
//            }
//
//            line = bufferedReader.readLine();
//        }
//
////        String name = columnsName[0];
////        String urlCode = columnsName[1];
////        String order = columnsName[2];
////        String description = columnsName[3];
////        String active = columnsName[4];
////        String category = columnsName[5];
//
////        System.out.println("---===> SUB CATEGORIES <===---");
////        System.out.format("%-30s - %-30s - %6s - %-155s - %s - %-8s %n", name, urlCode, order, description, active, category);
//
//        bufferedReader.close();
//
//        return listSubCategory;
//    }
}
