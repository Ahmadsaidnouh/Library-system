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
public class Helping {
    public static void incrementIssueColumnOfBook(String bookCallNo)
    {
        int length = Data.books.length;
        int i = 0;
        while(i < length)
        {
            if(bookCallNo.equals(Data.books[i].getBookCallNo()))
            {
               Data.books[i].setNumberIssued(Integer.toString(parseInt(Data.books[i].getnumberIssued()) + 1));
               return;
               
            }
            i++;
        }
    }
    
    public static void decrementIssueColumnOfBook(String bookCallNo)
    {
        int length = Data.books.length;
        int i = 0;
        while(i < length)
        {
            if(bookCallNo.equals(Data.books[i].getBookCallNo()))
            {
               Data.books[i].setNumberIssued(Integer.toString(parseInt(Data.books[i].getnumberIssued()) - 1));
               return;
               
            }
            i++;
        }
    }
    
    public static void addNewIssuedBook(String bookCallNo, String sId, String sName, String sContact, String returnDate)
    {
        String bookName = "", bookAuthor = "", bookPublisher = "";
        int length = Data.books.length;
        int i = 0;
        while(i < length)
        {
            if(bookCallNo.equals(Data.books[i].getBookCallNo()))
            {
                bookName = Data.books[i].getBookName();
                bookAuthor = Data.books[i].getBookAuthor();
                bookPublisher = Data.books[i].getBookPublisher();
                break;
            }
            i++;
        }
        i = 0;
        length = Data.issuedBooks.length;
        IssuedBook[] newIssuedBooks = new IssuedBook[length + 1];
        while(i < length)
        {
            newIssuedBooks[i] = Data.issuedBooks[i];
            i++;
        }
        newIssuedBooks[i] = new IssuedBook(bookCallNo, bookName, bookAuthor, bookPublisher, sId, sName, sContact, returnDate);
        Data.issuedBooks = newIssuedBooks;
        
    }
    
    public static void deleteIssuedBook(String bookCallNo, String sId)
    {
        int i,j;
        i = j = 0;
        int length = Data.issuedBooks.length;
        IssuedBook[] newIssuedBooks = new IssuedBook[length - 1];
        while(i < length)
        {
            if(!(bookCallNo.equals(Data.issuedBooks[i].getBookCallNo()) && sId.equals(Data.issuedBooks[i].getStudentId())))
            {
                newIssuedBooks[j] = Data.issuedBooks[i];
                j++;
            }
                
            i++;
        }
        Data.issuedBooks = newIssuedBooks;
        
    }
    
    public static void addIssuedBookToStudent(String bookCallNo, String sId, String sName, String sContact, String returnDate)
    {
        String bookName = "";
        int len = Data.books.length;
        int i = 0;
        while(i < len)
        {
            if(bookCallNo.equals(Data.books[i].getBookCallNo()))
            {
                bookName = Data.books[i].getBookName();
                break;
            }
            i++;
        }
        int length = Data.students.length;
        i = 0;
        while(i < length)
        {
            if(sId.equals(Data.students[i].getPersonId()) && sName.equals(Data.students[i].getPersonName()) && sContact.equals(Data.students[i].getPersonContact()))
            {
                Data.students[i].setIssuedBooks(new IssuedBook(1, bookCallNo, bookName, returnDate));
                break;
            }
            i++;
        }
    }
    
    public static void deleteIssuedBookFromStudent(String bookCallNo, String sId)
    {
        int length = Data.students.length;
        
        int i;
        for(i = 0; i < length; i++)
        {
            if(sId.equals(Data.students[i].getPersonId()))
            {
                int numHeIssue = Data.students[i].getNumberOfIssuedBooks();
                
                if(numHeIssue == 1)
                {
//                    IssuedBook[] nIssuedBooks = null;
//                    Data.students[i].setIssuedBooks(nIssuedBooks);
                    Data.students[i].setNumberOfIssuedBooks(0);
                    return;
                }
                else
                {
                    IssuedBook[] nIssuedBooks = new IssuedBook[3];
                    int j,k;
                    k = 0;
                    for(j = 0; j < (numHeIssue); j++)
                    {
                        if(!bookCallNo.equals(Data.students[i].getIssuedBookCallNo(j)))
                        {
                            nIssuedBooks[k++] = Data.students[i].getIssuedBookAtIndex(j);
                        }
                    }
                    Data.students[i].setIssuedBooks(nIssuedBooks);
                    Data.students[i].setNumberOfIssuedBooks(numHeIssue - 1);
                    return;
                }   
            }
        }
    }
    
    public static void addNewBook(Book newBook)
    {
        int i = 0;
        Book[] oldBooks = Data.books;
        int length = oldBooks.length;
        Book[] newBooks = new Book[length + 1];
        while (i < length) {
            newBooks[i] = oldBooks[i];
            i++;
        }
        newBooks[i] = newBook;
        Data.books = newBooks;
    }
    
    public static int bookExistsAt(Book book)
    {
        Book[] books = Data.books;
        int length = books.length;
        for(int i = 0; i < length; i++)
        {
            if(book.getBookCallNo().equals(books[i].getBookCallNo()) &&
                    book.getBookName().equals(books[i].getBookName()) &&
                    book.getBookAuthor().equals(books[i].getBookAuthor()) &&
                    book.getBookPublisher().equals(books[i].getBookPublisher()) )
                return i;
                
        }
        return 0;
    }
    
    
    public static void addNewLibrarian(Librarian nLib)
    {
        int length = Data.librarians.length;
        Librarian[] nLibs = new Librarian[length + 1];
        int i;
        for(i = 0; i < length; i++)
            nLibs[i] = Data.librarians[i];
        nLibs[i] = nLib;
        Data.librarians = nLibs;
    }
    
    public static void addNewStudent(Student std)
    {
        int length = Data.students.length;
        Student[] nStds = new Student[length + 1];
        int i;
        for(i = 0; i < length; i++)
            nStds[i] = Data.students[i];
        nStds[i] = std;
        Data.students = nStds;
    }
    
    public static void deleteLibrarian(String id)
    {
        int length = Data.librarians.length;
        Librarian[] nLbs = new Librarian[length - 1];
        int i, j = 0;
        
        for(i = 0; i < length; i++)
        {
            if(!id.equals(Data.librarians[i].getPersonId()))
            {
               nLbs[j++] = Data.librarians[i];
            }
        }
        Data.librarians = nLbs;
    }
    
    public static Student findStudent(String name, String password)
    {
        int length = Data.students.length;
        for(int i = 0; i < length; i++)
        {
            if(name.equals(Data.students[i].getPersonName()) && password.equals(Data.students[i].getPersonPassword()))
                return Data.students[i];
        }
        return null;
    }
}
