package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.connection.UnitOfWork;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SetaCursoParaPublico implements UnitOfWork {

    @Override
    public void doWithPreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.executeUpdate();
        Integer modifiedLines = preparedStatement.getUpdateCount();
        System.out.println("Number of lines that have been modified: " + modifiedLines);
    }

}
