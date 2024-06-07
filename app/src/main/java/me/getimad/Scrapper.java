package me.getimad;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import me.getimad.modules.Book;


public class Scrapper {
    public static final String URL = "https://www.goodreads.com/book/most_read?category=all&country=all&duration=m";

    public static ArrayList<Book> GetBooks() {
        try {
            Document doc = Jsoup.connect(URL).get();

            Elements elements = doc.selectXpath("//table[@class='tableList']/tbody/tr");

            ArrayList<Book> books = new ArrayList<>();

            int count = 0;
            for (Element element : elements) {
                String bookTitle = element.selectXpath(".//a[@class='bookTitle']/span").text();
                String bookAuthor = element.selectXpath(".//a[@class='authorName']/span").text();

                books.add(new Book(count, bookTitle, bookAuthor));

                count++;
            }
    
            return books;
        } catch (IOException e) {
            System.out.println("Error fetching the webpage");
        }
        
        return null;
    }
}
