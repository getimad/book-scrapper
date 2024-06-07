package me.getimad;

import java.util.ArrayList;

import me.getimad.modules.Book;

public class App {
    public static void main(String[] args) {
        ArrayList<Book> books = Scrapper.GetBooks();

        System.out.println("Most Read Books This Month:\n");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
