package com.library.DAO.mybatis;

import com.library.MyBatisConf;
import com.library.DAO.IBookDAO;
import com.library.model.Book;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class BookDao implements IBookDAO {
    static SqlSessionFactory sqlSessionFactory = MyBatisConf.buldFactoryXml();

    @Override
    public Book read(int id) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("com.library.DAO.mybatis.BookMapper.getBookById", id);
        }
    }

    @Override
    public List<Book> readAll() throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("com.library.DAO.mybatis.BookMapper.getAllBooks");
        }
    }

    @Override
    public void create(Book book) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Book existingBook = session.selectOne("com.library.DAO.mybatis.BookMapper.getBookById", book.getId());
            if (existingBook == null) {
                session.insert("com.library.DAO.mybatis.BookMapper.insertBook", book);
                session.commit();
            } else {
                session.update("com.library.DAO.mybatis.BookMapper.updateBook", book);
                session.commit();
            }
        }
    }

    @Override
    public void update(Book book) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.update("com.library.DAO.mybatis.BookMapper.updateBook", book);
            session.commit();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.delete("com.library.DAO.mybatis.BookMapper.deleteBook", id);
            session.commit();
        }
    }
}

