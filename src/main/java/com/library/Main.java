package com.library;

import com.library.DAO.jdbc.AuthorDAO;
import com.library.DAO.jdbc.BookDAO;
import com.library.connection.ConnectionPool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ConnectionPool pool = ConnectionPool.create();

        ExecutorService executorService = Executors.newFixedThreadPool(7);

        AuthorDAO authorDAO = new AuthorDAO(pool.getConnection());
        BookDAO bookDAO = new BookDAO(pool.getConnection());

        for (int i = 0; i < 7; i++) {
            executorService.execute(new OwnThread(authorDAO, bookDAO));
        }

        executorService.shutdown();

    }
}
