package com.library.DAO;

import com.library.model.Author;

import java.sql.SQLException;
import java.util.List;

public interface IAuthorDAO extends IBaseDAO<Author> {
    @Override
    void create(Author author) throws SQLException;

    @Override
    Author read(int id) throws SQLException;

    @Override
    List<Author> readAll() throws SQLException;

    @Override
    void update(Author author) throws SQLException;

    @Override
    void delete(int id) throws SQLException;
}
