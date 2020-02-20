package Competitions.Hashcode2020;

import Competitions.Hashcode2020.model.Book;
import Competitions.Hashcode2020.model.Library;

import java.io.*;
import java.util.*;

public class Solution {

    int numOfBooks, numOfLibraries, numOfDays;
    private Book[] books;
    private Set<Integer> usedBooks = new HashSet<Integer>();
    private ArrayList<Library> librariesInput;
    private ArrayList<Library> librariesOutput;


    public void parseInput(String filename) {
        int bufferSize = 8 * 1024;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename), bufferSize);

            String line = bufferedReader.readLine();
            String[] arr = line.split(" ");

            //Get all numbers of stuffs
            numOfBooks = Integer.parseInt(arr[0]);
            numOfLibraries = Integer.parseInt(arr[1]);
            numOfDays = Integer.parseInt(arr[2]);

            //Get All Books
            books = new Book[numOfBooks];
            String[] array = bufferedReader.readLine().split(" ");
            for (int i = 0; i < numOfBooks; i++) {
                books[i] = new Book(i, Integer.parseInt(array[i]));
            }

            librariesInput = new ArrayList<>();
            for (int j = 0; j < numOfLibraries; j++) {
                String[] a1 = bufferedReader.readLine().split(" ");
                int nBooks = Integer.parseInt(a1[0]);
                int nSignUp = Integer.parseInt(a1[1]);
                int nAmountPerDay = Integer.parseInt(a1[2]);

                String[] a2 = bufferedReader.readLine().split(" ");
                ArrayList<Book> tempBooks = new ArrayList<>();
                int score = 0;
                for (int k = 0; k < nBooks; k++) {
                    int id = Integer.parseInt(a2[k]);
                    int sc = books[id].score;
                    tempBooks.add(new Book(id, sc));
                    score += sc;
                }
                librariesInput.add(new Library(j, nBooks, nSignUp, nAmountPerDay, tempBooks, score));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void simulate() {
        Collections.sort(librariesInput, Comparator.comparingInt(o -> o.score));
        Collections.reverse(librariesInput);
        for (int j = 0; j < librariesOutput.size(); j++) {
            Library library = librariesInput.get(j);
            for (int k = 0; k < library.numOfBooks; k++) {
                Book book = library.bookArray.get(k);
                if (usedBooks.contains(book.id)) {

                    usedBooks.add(book.id);
                }
            }
        }
    }

    public void parseOutput(String filename) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename, "UTF-8");

            writer.print(librariesOutput.size());
            writer.println();
            for (int j = 0; j < librariesOutput.size(); j++) {
                Library library = librariesOutput.get(j);
                writer.print(String.format("%d %d\n", library.id, library.numOfBooks));
                for (int k = 0; k < library.numOfBooks; k++) {
                    writer.print(library.bookArray.get(k).id + " ");
                }
                writer.println();
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
