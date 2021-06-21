package br.com.sbs.cubatech.teste;

import br.com.sbs.cubatech.category.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestReaderCategory {

    public static void main(String[] args) throws IOException {

        String file = "Categoria.csv";
        List<Category> listCategory = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String headerLine = bufferedReader.readLine().toUpperCase();
        String line = bufferedReader.readLine();

        String[] columnsName = headerLine.split(",");

        String headerName = columnsName[0];
        String headerUrlCode = columnsName[1];
        String headerOrder = columnsName[2];
        String headerDescription = columnsName[3];
        String headerStatus = columnsName[4];
        String headerIcon = columnsName[5];
        String headerColor = columnsName[6];


        while (line != null){

            String[] vect = line.split(",");

            String name = vect[0];
            String urlCode = vect[1];
            Integer order = vect[2] == "" ? null : Integer.parseInt(vect[2]);
            String description = vect[3];
            Boolean active = vect[4] == "ATIVA" ? true : false;
            String iconPath = vect[5];
            String colorCode = vect[6];

            Category category = new Category(name, urlCode, order, description, active, iconPath, colorCode );
            listCategory.add(category);

            line = bufferedReader.readLine();
        }

        System.out.println("CATEGORIES:");

        String header = String.format("%-15s - %-15s - %-150s - %-6s - %6s - %-100s - %-8s", headerName, headerUrlCode, headerDescription, headerStatus, headerOrder, headerIcon, headerColor);

        System.out.println(header);
        for (Category category : listCategory) {
            System.out.println(category);
        }

        bufferedReader.close();
    }
}
