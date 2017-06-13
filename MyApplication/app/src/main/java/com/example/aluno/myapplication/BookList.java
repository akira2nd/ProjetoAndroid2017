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




    /*
    public List<String> returnAllBands() {
        List<String> bands = new LinkedList<String>();
        for (Music music : musics) {
            bands.add(music.getBand());
        }
        return bands;
    }

    public List<String> returnMusicsByBand(String band) {
        List<String> found = new LinkedList<String>();
        for (Music music : musics) {
            if (music.getBand().equals(band))
                found.add(music.getMusicName());
        }
        return found;
    }

    public String returnChords(String band, String musicName) {
        for (Music music : musics) {
            if (music.getBand().equals(band) && music.getMusicName().equals(musicName))
                return music.getChords();
        }
        return "Sorry...";
    }
    */
}
