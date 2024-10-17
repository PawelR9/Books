package com.library;

import com.library.DAO.jdbc.AuthorDAO;
import com.library.DAO.jdbc.BookDAO;
import com.library.connection.ConnectionPool;
import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Library;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException, ParseException {
       /* ConnectionPool pool = ConnectionPool.create();

        ExecutorService executorService = Executors.newFixedThreadPool(7);

        AuthorDAO authorDAO = new AuthorDAO(pool.getConnection());
        BookDAO bookDAO = new BookDAO(pool.getConnection());

        for (int i = 0; i < 7; i++) {
            executorService.execute(new OwnThread(authorDAO, bookDAO));
        }*/

        marshal();

        Library unmarshalledLibrary = unmarshal();
        System.out.println("Unmarshalled Library: " + unmarshalledLibrary);
    }

    public static Library unmarshal() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Library.class);
        return (Library) context.createUnmarshaller().unmarshal(new FileReader("books.xml"));
    }

    public static void marshal() throws JAXBException, ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date birthDate = simpleDateFormat.parse("1980/01/01");
        Date birthDate2 = simpleDateFormat.parse("1970/02/02");

        Author janKowalski = new Author(1, "Jan Kowalski", 1980, birthDate);
        Author danielLosniak = new Author(2, "Daniel Łosniak", 2013, birthDate2);

        Book solvdBook = new Book(1, "Solvd Book", janKowalski, 2024);
        Book polishBook = new Book(2, "Polish Book", danielLosniak, 2023);

        Library library = new Library();
        List<Book> bookList = new ArrayList<>();
        bookList.add(solvdBook);
        bookList.add(polishBook);
        library.setBookList(bookList);

        JAXBContext context = JAXBContext.newInstance(Library.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(library, new File("books.xml"));
        System.out.println("Book has been marshalled to books.xml");
    }

}