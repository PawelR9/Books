package com.library.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "library")
public class Library {
    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    @XmlElement(name = "book")
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Library{\n");
        for (Book book : bookList) {
            sb.append(book).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}

