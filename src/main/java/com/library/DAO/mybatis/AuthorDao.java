package com.library.DAO.mybatis;

import com.library.DAO.IAuthorDAO;
import com.library.MyBatisConf;
import com.library.model.Author;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class AuthorDao implements IAuthorDAO {

    static SqlSessionFactory sqlSessionFactory
            = MyBatisConf.buldFactoryXml();

    @Override
    public void create(Author author) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Author existingAuthor = session.selectOne("com.library.DAO.mybatis.AuthorMapper.getAuthorById", author.getId());
            if (existingAuthor == null) {
                session.insert("com.library.DAO.mybatis.AuthorMapper.insertAuthor", author);
                session.commit();
            } else {
                session.update("com.library.DAO.mybatis.AuthorMapper.updateAuthor", author);
                session.commit();
            }
        }
    }

    @Override
    public Author read(int id) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("com.library.DAO.mybatis.AuthorMapper.getAuthorById", id);
        }
    }

    @Override
    public List<Author> readAll() throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("com.library.DAO.mybatis.AuthorMapper.getAllAuthors");
        }
    }

    @Override
    public void update(Author author) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.update("com.library.DAO.mybatis.AuthorMapper.updateAuthor", author);
            session.commit();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.delete("com.library.DAO.mybatis.AuthorMapper.deleteAuthor", id);
            session.commit();
        }
    }
}