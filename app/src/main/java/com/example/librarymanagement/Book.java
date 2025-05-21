package com.example.librarymanagement;

public class Book {
    private String title;
    private String author;
    private boolean isBorrowed;
    protected int index;

    Book(String title, String author, int index){
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
        this.index = index;
    }


    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }
    public boolean isBorrowed(){return isBorrowed; }

    public void borrowBook(){
        if(isBorrowed){
            System.out.println("Sorry! but the book is already borrowed.");
        }
        else{
            System.out.println("Book borrowed successfully!");
            isBorrowed = true;
        }
    }

    public void returnBook(){
        if(isBorrowed){
            isBorrowed = false;
            System.out.println("Book returned successfully!");
        }
        else{
            System.out.println("You can not return a book you never borrowed!");
        }
    }

    public void displayBook(){
        System.out.printf(":::Book Details:::\tTitle : %s;\tAuthor : %s;\tBorrowed : %b;\n",title,author,isBorrowed);
    }
}


