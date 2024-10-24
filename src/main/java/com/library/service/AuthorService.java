package com.library.service;

import com.library.DAO.IAuthorDAO;
import com.library.DAO.jdbc.AuthorDAO;
import com.library.DAO.mybatis.AuthorDao;

import java.util.ResourceBundle;

public class AuthorService {

    public static IAuthorDAO getAuthorSelect() {
        return new AuthorDao();
    }
}

