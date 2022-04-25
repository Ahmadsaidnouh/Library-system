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
public class IssuedBook extends Book{
    private Student student;
    private String issueDate;
    private String returnDate; 

    public IssuedBook(String iBookCallNo, String iBookName, String iBookAuthor, String iBookPublisher, String studentId, String studentName,String studentContact, String issueDate,String returnDate) {
        setBookCallNo(iBookCallNo);
        setBookName(iBookName);
        setBookAuthor(iBookAuthor);
        setBookPublisher(iBookPublisher);
        setReturnDate(returnDate);
        student = new Student(studentId, studentName, studentContact);
        this.issueDate = issueDate;
    }

    
    public IssuedBook(String iBookCallNo, String iBookName, String iBookAuthor, String iBookPublisher, String studentId, String studentName,String studentContact, String returnDate) {
        setBookCallNo(iBookCallNo);
        setBookName(iBookName);
        setBookAuthor(iBookAuthor);
        setBookPublisher(iBookPublisher);
        student = new Student(studentId, studentName, studentContact);
        this.setIssueDate();
        this.returnDate = returnDate;
    }
    
    public IssuedBook(String iBookCallNo, String iBookName, String issueDate, String returnDate)
    {
        setBookCallNo(iBookCallNo);
        setBookName(iBookName);
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public IssuedBook(int i, String iBookCallNo, String iBookName, String returnDate)
    {
        setBookCallNo(iBookCallNo);
        setBookName(iBookName);
        this.setIssueDate();
        this.returnDate = returnDate;
    }
    

    public String getStudentId() {
        return student.getPersonId();
    }
    
    public String getStudentName() {
        return student.getPersonName();
    }
    
    public String getStudentContact() {
        return student.getPersonContact();
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }


    public void setStudentId(String studentId) {
        student.setPersonId(studentId);
    }
    
    public void setStudentName(String studentName) {
        student.setPersonName(studentName);
    }
    
    public void setStudentConatct(String studentContact) {
        student.setPersonContact(studentContact);
    }
    
    public void setIssueDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date date = new Date();
        issueDate = dateFormat.format(date);
    }
}
