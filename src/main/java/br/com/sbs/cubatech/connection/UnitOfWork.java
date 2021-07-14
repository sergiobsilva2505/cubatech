package br.com.sbs.cubatech.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface UnitOfWork {
    void doWithPreparedStatement(PreparedStatement preparedStatement) throws SQLException;
    static  void doInTransaction(Connection connection, String sql, UnitOfWork unitOfWork, String errorMessage) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);

            unitOfWork.doWithPreparedStatement(preparedStatement);

            connection.commit();
        } catch (SQLException e){
            try {
                connection.rollback();
                throw new DaoException(errorMessage, e);
            } catch (SQLException ex) {
                throw new DaoException("Unable to rollback", ex);
            }
        }
    }
}
