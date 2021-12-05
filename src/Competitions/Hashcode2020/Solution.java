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
        Collections.sort(librariesInput, Comparator.comparingInt(o -> o.signUpDays));
        ArrayList<ArrayList<Library>> halfList = new ArrayList<>();

        ArrayList<Library> newInput = new ArrayList<>();

        for (int i = 52; i < librariesInput.size(); i += 52) {
            List<Library> temp;
            temp = librariesInput.subList(i - 52, i);
            Collections.sort(temp, Comparator.comparingInt(o -> o.ratio));
            Collections.reverse(temp);
            newInput.addAll(temp);
        }

        if (newInput.isEmpty()) {
            newInput = librariesInput;
        }
        for(int i = newInput.size()+1;  i< librariesInput.size(); i++){
            newInput.add(librariesInput.get(i));
        }
        System.out.println(librariesInput.size());
        System.out.println(newInput.size());

        librariesOutput = newInput;
        for (int j = 0; j < librariesOutput.size(); j++) {
            Library library = librariesInput.get(j);
            ArrayList<Book> toRemove = new ArrayList<>();
            for (int k = 0; k < library.numOfBooks; k++) {
                Book book = library.bookArray.get(k);
                if (!usedBooks.contains(library.bookArray.get(k).id)) {
                    usedBooks.add(library.bookArray.get(k).id);
                } else {
                    toRemove.add(book);
                }
            }

            library.bookArray.removeAll(toRemove);
        }

        ArrayList<Library> toRe = new ArrayList<>();
        for (int i = 0; i < librariesOutput.size(); i++) {
            if (librariesOutput.get(i).bookArray.isEmpty()) {
                toRe.add(librariesOutput.get(i));
            } else {
                librariesOutput.get(i).bookArray.sort(Comparator.comparingInt(o -> o.score));
                Collections.reverse(librariesOutput.get(i).bookArray);
            }
        }
        librariesOutput.removeAll(toRe);
    }

    public void parseOutput(String filename) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename, "UTF-8");

            writer.print(librariesOutput.size());
            writer.println();
            for (int j = 0; j < librariesOutput.size(); j++) {
                Library library = librariesOutput.get(j);
                writer.print(String.format("%d %d\n", library.id, library.bookArray.size()));
                for (int k = 0; k < library.bookArray.size(); k++) {
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
