package com.pg.obv.models;

public class Book {


    private  int id;
    private String name;
    private int value;
    private String author;

    public Book() {
    }

    public Book(int id, String name, int value, String author) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", author='" + author + '\'' +
                '}';
    }
}
