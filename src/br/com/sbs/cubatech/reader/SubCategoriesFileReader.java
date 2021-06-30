package br.com.sbs.cubatech.reader;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;
import br.com.sbs.cubatech.category.SubCategory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SubCategoriesFileReader {

    public List<SubCategory> readSubCategories(Map<String, Category> categories) throws IOException {

        List<SubCategory> listSubCategory = new ArrayList<>();

        var bufferedReader = new BufferedReader(new FileReader("Subcategoria.csv"));

        bufferedReader.readLine();
        String line = bufferedReader.readLine();


        while (line != null ){

            String[] valuesSubCategoryColumns = line.split(",");

            String name = valuesSubCategoryColumns[0];
            String urlCode = valuesSubCategoryColumns[1];
            Integer order = valuesSubCategoryColumns[2].equals("")? null : Integer.parseInt(valuesSubCategoryColumns[2]);
            String description = valuesSubCategoryColumns[3];
            Status status = valuesSubCategoryColumns[4].equals("ATIVA")  ? Status.ATIVA : Status.INATIVA;
            String categoryUrlCode = valuesSubCategoryColumns[5];

            Category category =  categories.get(categoryUrlCode);
            SubCategory subCategory = new SubCategory(name, urlCode, order, description, status, category);
            listSubCategory.add(subCategory);
            category.addSubCategories(subCategory);

            line = bufferedReader.readLine();
        }


        bufferedReader.close();

        return listSubCategory;
    }
}
