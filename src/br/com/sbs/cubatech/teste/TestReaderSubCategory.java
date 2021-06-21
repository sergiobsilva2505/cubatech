package br.com.sbs.cubatech.teste;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.SubCategory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestReaderSubCategory {

    public static void main(String[] args) throws IOException {

        String file = "Subcategoria.csv";
        List<SubCategory> listSubCategory = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String headerLine = bufferedReader.readLine().toUpperCase();
        String line = bufferedReader.readLine();

        String[] columnsName = headerLine.split(",");

        while (line != null ){

            String[] vect = line.split(",");

            String name = vect[0];
            String urlCode = vect[1];
            Integer order = vect[2] == "" ? null : Integer.parseInt(vect[2]);
            String description = vect[3];
            Boolean active = vect[4] == "ATIVA" ? true : false;
            Category category = new Category(vect[5]);

            SubCategory subCategory = new SubCategory(name, urlCode, order, description, active, category );
            listSubCategory.add(subCategory);

            line = bufferedReader.readLine();

        }


        String name = columnsName[0];
        String urlCode = columnsName[1];
        String order = columnsName[2];
        String description = columnsName[3];
        String active = columnsName[4];
        String category = columnsName[5];
        
        System.out.println("SUB CATEGORIES: ");
        System.out.format("%-30s - %-30s - %6s - %-155s - %s - %-8s %n", name, urlCode, order, description, active, category);

        for (SubCategory subCategory : listSubCategory) {
            System.out.println(subCategory);
        }

        bufferedReader.close();
    }


}
