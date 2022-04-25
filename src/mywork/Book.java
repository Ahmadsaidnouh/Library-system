/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mywork;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ahmad Nouh
 */
public class Book {
    private String bookCallNo;
    private String bookName;
    private String bookAuthor;
    private String bookPublisher;
    private String bookQuantity;
    private String numberIssued;
    private String addedDate;

    public Book(){}
    
    public Book(String bookCallNo, String bookName, String bookAuthor, String bookPublisher, String bookQuantity, String numberIssued, String addedDate ) {
        this.bookCallNo = bookCallNo;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookQuantity = bookQuantity;
        this.numberIssued = numberIssued;
        this.addedDate = addedDate;
    }
    
    public Book(String bookCallNo, String bookName, String bookAuthor, String bookPublisher, String bookQuantity) {
        this.bookCallNo = bookCallNo;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookQuantity = bookQuantity;
        setNumberIssued();
        setAddedDate();
    }
    public String getBookCallNo() {
        return bookCallNo;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public String getBookQuantity() {
        return bookQuantity;
    }
    public String getAddedDate() {
        return addedDate;
    }
    public String getnumberIssued()
    {
        return numberIssued;
    }
    public void setBookCallNo(String bookCallNo) {
        this.bookCallNo = bookCallNo;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public void setBookQuantity(String bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public void setAddedDate() {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date date = new Date();
        this.addedDate = dateFormat.format(date) ;
    }

    public void setNumberIssued() {
        IssuedBook[] issuedBooks = Data.issuedBooks;
        int numIssued = 0;
        int length = issuedBooks.length;
        for(int i = 0; i < length; i++)
        {
            if(bookCallNo.equals(issuedBooks[i].getBookCallNo()) && bookName.equals(issuedBooks[i].getBookName()) && bookAuthor.equals(issuedBooks[i].getBookAuthor()) &&bookPublisher.equals(issuedBooks[i].getBookPublisher()))
                numIssued++;
        }
        this.numberIssued = Integer.toString(numIssued);
    }
    
    public void setNumberIssued(String numberIssued)
    {
        this.numberIssued = numberIssued;
    }
    
    
    
    
}
