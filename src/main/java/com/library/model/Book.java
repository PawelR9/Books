package com.library.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlRootElement(name = "book")
@XmlType(propOrder = {"title", "author", "publishedYear"})
public class Book extends BaseModel {
    private String title;
    private Author author;
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


    @XmlElement(name = "title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    @XmlElement(name = "author")
    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    @XmlElement(name = "yearOfPublished")
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
