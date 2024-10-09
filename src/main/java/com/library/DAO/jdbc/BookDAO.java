package com.library.DAO.jdbc;

import com.library.DAO.IBookDAO;
import com.library.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBookDAO {

    private Connection connection;

    public BookDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Book book) throws SQLException{
        String sql = "INSERT INTO Book (title, author_id, published_year) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setInt(2, book.getAuthor().getId());
            pstmt.setInt(3, book.getPublishedYear());
            pstmt.executeUpdate();
        }
    }

    @Override
    public Book read(int id) throws SQLException{
        String sql = "SELECT * FROM Book WHERE id = ?";
        Book book = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
            }
        }
        return book;
    }

    @Override
    public List<Book> readAll() throws SQLException{
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Book";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public void update(Book book) throws SQLException{
        String sql = "UPDATE Book SET title = ?, author_id = ?, published_year = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setInt(2, book.getAuthor().getId());
            pstmt.setInt(3, book.getPublishedYear());
            pstmt.setInt(4, book.getId());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException{
        String sql = "DELETE FROM Book WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
