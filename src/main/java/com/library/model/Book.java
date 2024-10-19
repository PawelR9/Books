package com.library.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Book extends BaseModel {
    @JsonProperty("title")
    private String title;
    @JsonProperty("author")
    private Author author;
    @JsonProperty("published_year")
    private int publishedYear;
    private List<Book> bookList;

    public Book() {
    }

    public Book(int id, String title, Author author, int publishedYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }


    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }


    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                "title='" + title + '\'' +
                ", author=" + author +
                ", publishedYear=" + publishedYear +
                '}';
    }
}
