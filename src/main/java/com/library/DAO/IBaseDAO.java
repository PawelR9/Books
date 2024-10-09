package com.library.DAO;

import com.library.model.BaseModel;

import java.sql.SQLException;
import java.util.List;

public interface IBaseDAO<T extends BaseModel> {
    void create(T entity) throws SQLException;

    T read(int id) throws SQLException;

    List<T> readAll() throws SQLException;

    void update(T entity) throws SQLException;

    void delete(int id) throws SQLException;
}
