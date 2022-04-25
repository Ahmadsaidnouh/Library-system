/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mywork;

import static java.lang.Integer.parseInt;

/**
 *
 * @author Ahmad Nouh
 */
public class Student extends Person {
    private IssuedBook[] issuedBooks = new IssuedBook[3];
    private int numberOfIssuedBooks;

    public Student(String studentId, String studentName, String studentPassword, String studentEmail, String studentAddress, String studentCity, String studentContact) {
        
        setPersonId(studentId);
        setPersonName(studentName);
        setPersonPassword(studentPassword);
        setPersonEmail(studentEmail);
        setPersonAddress(studentAddress);
        setPersonCity(studentCity);
        setPersonContact(studentContact);
        this.numberOfIssuedBooks = 0;
    }
    public Student(String studentId, String studentName, String studentPassword, String studentEmail, String studentAddress, String studentCity, String studentContact, String numberOfIssuedBooks, IssuedBook[] issuedBooks) {
       
        setPersonId(studentId);
        setPersonName(studentName);
        setPersonPassword(studentPassword);
        setPersonEmail(studentEmail);
        setPersonAddress(studentAddress);
        setPersonCity(studentCity);
        setPersonContact(studentContact);
        this.numberOfIssuedBooks = parseInt(numberOfIssuedBooks);
        this.issuedBooks = issuedBooks;
    }
    
    public Student(String studentId, String studentName, String studentContact)
    {
        setPersonId(studentId);
        setPersonName(studentName);
        setPersonContact(studentContact);
    }
    
    public String getIssuedBook1()
    {
        return issuedBooks[0].getBookCallNo() + "," + issuedBooks[0].getBookName() + "," +  issuedBooks[0].getIssueDate() + "," + issuedBooks[0].getReturnDate(); 
    }

    public String getIssuedBook1_2()
    {        
        return issuedBooks[0].getBookCallNo() + "," + issuedBooks[0].getBookName() + "," +  issuedBooks[0].getIssueDate() + "," + issuedBooks[0].getReturnDate() + "," + issuedBooks[1].getBookCallNo() + "," + issuedBooks[1].getBookName() + "," +  issuedBooks[1].getIssueDate() + "," + issuedBooks[1].getReturnDate(); 
    }
    
    public String getIssuedBook1_2_3()
    {
        return issuedBooks[0].getBookCallNo() + "," + issuedBooks[0].getBookName() + "," +  issuedBooks[0].getIssueDate() + "," + issuedBooks[0].getReturnDate() + "," + issuedBooks[1].getBookCallNo() + "," + issuedBooks[1].getBookName() + "," +  issuedBooks[1].getIssueDate() + "," + issuedBooks[1].getReturnDate() + "," + issuedBooks[2].getBookCallNo() + "," + issuedBooks[2].getBookName() + "," +  issuedBooks[2].getIssueDate() + "," + issuedBooks[2].getReturnDate(); 
        
    }
    public int getNumberOfIssuedBooks() {
        return numberOfIssuedBooks;
    }

    public IssuedBook[] getIssuedBooks()
    {
        return issuedBooks;
    }
    
    public String getIssuedBookCallNo(int i)
    {
        return issuedBooks[i].getBookCallNo();
    }
    
    public IssuedBook getIssuedBookAtIndex(int i)
    {
        
        return issuedBooks[i];
    }

    public void setIssuedBooks(IssuedBook issuedBook) {
        this.issuedBooks[numberOfIssuedBooks++] = issuedBook;
    }
    
    public void setIssuedBooks(IssuedBook[] issuedBooks)
    {
        this.issuedBooks = issuedBooks;
    }

    public void setNumberOfIssuedBooks(int numberOfIssuedBooks) {
        this.numberOfIssuedBooks = numberOfIssuedBooks;
    }
    
    
    
    
    
    
}
