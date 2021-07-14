package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.connection.UnitOfWork;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletaCurso implements UnitOfWork {

    private final String urlCode;

    public DeletaCurso(String urlCode) {
        this.urlCode = urlCode;
    }

    @Override
    public void doWithPreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, urlCode);

        preparedStatement.execute();
        Integer modifiedLines = preparedStatement.getUpdateCount();
        System.out.println("Number of lines that have been modified: " + modifiedLines);
    }

}
