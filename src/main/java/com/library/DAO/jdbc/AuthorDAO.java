package com.library.DAO.jdbc;

import com.library.DAO.IAuthorDAO;
import com.library.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO implements IAuthorDAO {

    private Connection connection;

    public AuthorDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Author author) throws SQLException {
        String sql = "INSERT INTO Author (name, birth_year) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, author.getName());
            pstmt.setInt(2, author.getBirthYear());
            pstmt.executeUpdate();
        }
    }

    @Override
    public Author read(int id) throws SQLException {
        String sql = "SELECT * FROM Author WHERE id = ?";
        Author author = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                author = new Author();
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));
                author.setBirthYear(rs.getInt("birth_year"));
            }
        }
        return author;
    }

    @Override
    public List<Author> readAll() throws SQLException {
        List<Author> authors = new ArrayList<>();
        String sql = "SELECT * FROM Author";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Author author = new Author();
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));
                author.setBirthYear(rs.getInt("birth_year"));
                authors.add(author);
            }
        }
        return authors;
    }

    @Override
    public void update(Author author) throws SQLException {
        String sql = "UPDATE Author SET name = ?, birth_year = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, author.getName());
            pstmt.setInt(2, author.getBirthYear());
            pstmt.setInt(3, author.getId());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Author WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
