package com.library.service;

import com.library.DAO.IBookDAO;
import com.library.DAO.jdbc.BookDAO;
import com.library.DAO.mybatis.BookDao;

import java.util.ResourceBundle;

public class BookService {

    public static IBookDAO getBookSelect() {
        return new BookDao();
    }
}

