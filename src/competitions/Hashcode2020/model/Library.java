package competitions.Hashcode2020.model;

import java.util.ArrayList;

public class Library {

    public int id;
    public int numOfBooks;
    public int signUpDays;
    public int amountPerDay;
    public ArrayList<Book> bookArray;
    public int score;

    public int ratio;

    public Library(int id, int numOfBooks, int signUpDays, int amountPerDay, ArrayList<Book> bookArray, int score) {
        this.id = id;
        this.numOfBooks = numOfBooks;
        this.signUpDays = signUpDays;
        this.amountPerDay = amountPerDay;
        this.bookArray = bookArray;
        this.score = score;
        ratio = numOfBooks / amountPerDay;
    }
}
