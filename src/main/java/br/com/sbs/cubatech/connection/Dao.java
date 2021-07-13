package br.com.sbs.cubatech.connection;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {

//    Optional<T> get(Integer id);

//    List<T> getAll();

    void save(T t) throws SQLException;

    void update(T t);

    void deleteByUrlCode(String  urlCode) throws SQLException;

}
