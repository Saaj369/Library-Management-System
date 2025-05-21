package com.example.librarymanagement;

import java.util.ArrayList;

public class Library {
    protected static ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author){
        Book b1 = new Book(title, author, books.size());
        books.add(b1);

    }

    public void addBunchOfBooks(){
        String[] titles = {"Quantum Mechanics", "Statistical Physics", "Earth and Environmental Science","Chemistry","Social Science","Psychology","Biology","Computational Physics","Maths","Linear Algebra","Group Theory","Concept of Physics","NCERT Exempler","Geology", "Geochemistry", "String Theory", "Finance"};
        String[] authors = {"DJ Griffith", "RK Patharia", "S Vinee", "Rakesh Singh","Koli Yadav","Jordan P","R P Sharma", "SP Singh", "Yash Gautam","Shrishti Pandey", "Roshan Dubey", "HC Verma", "NCERT","Venu Pathak","Riya ji","Suvankar", "Nirmala Sitaraman"};
        for(int i = 0; i < titles.length; i++){
            Book b = new Book(titles[i],authors[i],books.size());
            books.add(b);
        }
    }
    public Book getBookbyIndex(int index){
        return books.get(index);
    }
    public int searchTitle(String title){
        for (int i=0; i<books.size(); i++) {
            if (title.equalsIgnoreCase(books.get(i).getTitle())) {
//                System.out.println("Book Found");
//                book.displayBook();
                return i;
            }
        }
        return -1;
    }
    public void displayAllbooks(){
        int index = 0;
        for (Book book : books) {
            System.out.printf("(%d)",index+1);
            book.displayBook();
            index++;
        }
    }
    public void borrowAbook(int index){
        try{
            books.get(index).borrowBook();
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("The book doesn't exist!");
        }
    }
    public void returnAbook(int index){
        try{
            books.get(index).returnBook();
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("The book doesn't exits!");
        }
    }
}
