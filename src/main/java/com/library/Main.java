package com.library;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.library.DAO.jdbc.AuthorDAO;
import com.library.DAO.jdbc.BookDAO;
import com.library.connection.ConnectionPool;
import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Library;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {
       /* ConnectionPool pool = ConnectionPool.create();

        ExecutorService executorService = Executors.newFixedThreadPool(7);

        AuthorDAO authorDAO = new AuthorDAO(pool.getConnection());
        BookDAO bookDAO = new BookDAO(pool.getConnection());

        for (int i = 0; i < 7; i++) {
            executorService.execute(new OwnThread(authorDAO, bookDAO));
        }*/

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date birthDate = simpleDateFormat.parse("1980/01/02");
        Date birthDate2 = simpleDateFormat.parse("1970/02/03");

        Author janKowalski = new Author(1, "Jan Kowalski", "Warsaw", birthDate);
        Author danielLosniak = new Author(2, "Daniel Łosniak", "Kielce", birthDate2);

        Book solvdBook = new Book(1, "Solvd Book", janKowalski, 2024);
        Book polishBook = new Book(2, "Polish Book", danielLosniak, 2023);

        List<Book> bookList = new ArrayList<>();
        bookList.add(solvdBook);
        bookList.add(polishBook);

        Library library = new Library();
        library.setBookList(bookList);

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        objectMapper.writeValue(new File("library.json"), library);

        Library deserializedLibrary = objectMapper.readValue(new File("library.json"), Library.class);

        System.out.println("Deserialized Library: " + deserializedLibrary);

    }
}

