package br.com.sbs.cubatech.reader;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesFileReader {

    public List<Category> readCategories() {

        List<Category> categoryList = new ArrayList<>();

        try (var bufferedReader = new BufferedReader(new FileReader("Categoria.csv"))){
            bufferedReader.readLine();
            String line = bufferedReader.readLine();

            while (line != null){

                String[] valuesCategoryColumns = line.split(",");

                String name = valuesCategoryColumns[0];
                String urlCode = valuesCategoryColumns[1];
                Integer order = valuesCategoryColumns[2].equals("") ? null : Integer.parseInt(valuesCategoryColumns[2]);
                String description = valuesCategoryColumns[3];
                Status status = valuesCategoryColumns[4].equals("ATIVA")? Status.ACTIVE : Status.INACTIVE;
                String iconPath = valuesCategoryColumns[5];
                String colorCode = valuesCategoryColumns[6];

                Category category = new Category(name, urlCode, order, description, status, iconPath, colorCode );
                categoryList.add(category);

                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return categoryList;
    }
}
