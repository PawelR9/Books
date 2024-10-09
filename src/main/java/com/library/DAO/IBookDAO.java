package com.library.DAO;

import com.library.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookDAO extends IBaseDAO<Book> {
    @Override
    void create(Book book) throws SQLException;

    @Override
    Book read(int id) throws SQLException;

    @Override
    List<Book> readAll() throws SQLException;

    @Override
    void update(Book book) throws SQLException;

    @Override
    void delete(int id) throws SQLException;
}
