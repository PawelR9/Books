package com.library.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName(value = "library")
public class Library {
    @JsonProperty("book_list")
    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

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

