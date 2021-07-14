package br.com.sbs.cubatech.category;

import br.com.sbs.cubatech.connection.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubCategoryDao  {

    private final Connection connection;

    public SubCategoryDao(Connection connection) {
        this.connection = connection;
    }

    public SubCategory findByUrlCode(String urlCode){

        String sqlSelect = "SELECT id FROM subCategory WHERE urlCode =  ? " ;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect)){
            preparedStatement.setString(1, urlCode);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                long subCategoryId = resultSet.getLong( "id");
                return new SubCategory(subCategoryId);
            } else {
                throw new DaoException("SubCategory not found in database: "+ urlCode);
            }
        }catch (SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
    }
}
