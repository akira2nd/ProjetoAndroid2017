package com.example.aluno.myapplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aluno on 23/03/2017.
 */
public class BookList {

    List<Book> books = new LinkedList<Book>();
    Connection connection = new Connection();

    public void getBooks() {
        try {
            books = connection.sendGet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> livroSelect(ArrayList<String> listaLivro){
        List<Book> lista = new LinkedList<Book>();
        getBooks();
        for (String i:listaLivro){
            for(Book book : books) {
                if (book.getBook().toString().equals(i)) {
                    lista.add(book);
                }
            }
        }
        return lista;
    }

}
