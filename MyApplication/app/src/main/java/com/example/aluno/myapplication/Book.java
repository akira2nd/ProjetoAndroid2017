package com.example.aluno.myapplication;

/**
 * Created by Aluno on 20/03/2017.
 */
public class Book {

    private Integer book;
    private Integer lesson;
    private String sIngles;
    private String sPortugues;

    public Book(Integer book, Integer lesson, String sIngles, String sPortugues) {
        this.book = book;
        this.lesson = lesson;
        this.sIngles = sIngles;
        this.sPortugues = sPortugues;
    }

    public Integer getBook() {
        return book;
    }

    public Integer getLesson() {
        return lesson;
    }

    public String getsIngles() {
        return sIngles;
    }

    public String getsPortugues() {
        return sPortugues;
    }
}
