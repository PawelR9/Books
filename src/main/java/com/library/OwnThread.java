package com.library;

import com.library.DAO.jdbc.AuthorDAO;
import com.library.DAO.jdbc.BookDAO;
import com.library.model.Author;
import com.library.model.Book;

import java.sql.SQLException;

public class OwnThread extends Thread {
    private final AuthorDAO authorDAO;
    private final BookDAO bookDAO;

    public OwnThread(AuthorDAO authorDAO, BookDAO bookDAO) {
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
    }

    @Override
    public void run() {
        Author newAuthor = new Author();
        newAuthor.setName("Author " + Thread.currentThread().getName());
        newAuthor.setBirthYear(1980);
        try {
            authorDAO.create(newAuthor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Author author = null;
        try {
            author = authorDAO.read(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (author != null) {
            System.out.println("Readed author: " + author.getName());
        } else {
            System.out.println("Author not found.");
        }

        Book newBook = new Book();
        newBook.setTitle("Book by " + Thread.currentThread().getName());
        newBook.setAuthor(newAuthor);
        newBook.setPublishedYear(2024);
        try {
            bookDAO.create(newBook);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Book book = null;
        try {
            book = bookDAO.read(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (book != null) {
            System.out.println("Readed book: " + book.getTitle());
        } else {
            System.out.println("Book not found.");
        }
    }
}
