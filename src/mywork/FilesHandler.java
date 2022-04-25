/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mywork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.System.exit;
import java.util.Scanner;
 /*
 * @author Ahmad Nouh
 */
public class FilesHandler {
    public static int getNumberOfAdmins()
    {
        File adminsFile = new File("Admins.txt");
        int i = 0;
        try {
            Scanner adminSc = new Scanner(adminsFile);
            
            while(adminSc.hasNextLine())
            {
                adminSc.nextLine();
                i++;
            }
                
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException!!");
            exit(-1);
        }
        return i;
    }
    public static Admin[] adminLoad()
    {
        File adminsFile = new File("Admins.txt");
        int numberOfAdmins = getNumberOfAdmins();
        Admin[] admins = new Admin[numberOfAdmins];
        try {
            Scanner adminSc = new Scanner(adminsFile);
            int i = 0;
            while(i < numberOfAdmins)
            {
                String[] info = adminSc.nextLine().split(",");
                admins[i++] = new Admin(info[0],info[1]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException!!");
            exit(-1);
        }
        return admins;
        
    }
    public static int getNumberOfLibrarians()
    {
        File librariansFile = new File("Librarians.txt");
        int i = 0;
        try {
            Scanner librarianSc = new Scanner(librariansFile);
            
            while(librarianSc.hasNextLine())
            {
                librarianSc.nextLine();
                i++;
            }
                
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException!!");
            exit(-1);
        }
        return i;
    }
    public static Librarian[] librarianLoad()
    {
        
        File librarianFile = new File("Librarians.txt");
        Librarian[] librarians = new Librarian[getNumberOfLibrarians()];
        try {
            Scanner librarianSc = new Scanner(librarianFile);
            int i = 0;
            while(i < getNumberOfLibrarians())
            {
                String[] info = librarianSc.nextLine().split(",");
        
                librarians[i++] = new Librarian(info[0],info[1],info[2],info[3],info[4],info[5],info[6]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException!!");
            exit(-1);
        }
        
        return librarians;
        
    }
    public static void librarianUpload()
    {
        try {
            FileWriter writer = new FileWriter("Librarians.txt");
            Librarian[] lbs = Data.librarians;
            int length = lbs.length;
            for(int i =0; i<length; i++)
                writer.write( lbs[i].getPersonId() + "," + lbs[i].getPersonName() + "," + lbs[i].getPersonPassword() + "," + lbs[i].getPersonEmail() + "," + lbs[i].getPersonAddress() + "," + lbs[i].getPersonCity() + "," + lbs[i].getPersonContact() + "\n");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Can't write in file!!");
            exit(-1);
        }
    }
    public static int getNumberOfBooks()
    {
        File bookFile = new File("Books.txt");
        int i = 0;
        try {
            Scanner bookSc = new Scanner(bookFile);
            while(bookSc.hasNextLine())
            {
                bookSc.nextLine();
                i++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException!!");
            exit(-1);
        }
        
        return i;
    }
    public static Book[] booksLoad()
    {
        
        File bookFile = new File("Books.txt");
        Book[] books = new Book[getNumberOfBooks()];
        try {
            Scanner bookSc = new Scanner(bookFile);
            int i = 0;
            while(i < getNumberOfBooks())
            {
                String[] info = bookSc.nextLine().split(",");
                books[i++] = new Book(info[0],info[1],info[2],info[3],info[4],info[5],info[6]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException!!");
            exit(-1);
        }
        return books;
        
    }
    public static void booksUpload()
    {
        try {
            FileWriter writer = new FileWriter("Books.txt");
            int length = Data.books.length;
            for(int i =0; i<length; i++)
                writer.write(Data.books[i].getBookCallNo() + "," + Data.books[i].getBookName()+ "," + Data.books[i].getBookAuthor() + "," + Data.books[i].getBookPublisher() + "," + Data.books[i].getBookQuantity() + "," + Data.books[i].getnumberIssued() + "," + Data.books[i].getAddedDate() + "\n");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Can't write in file!!");
            exit(-1);
        }
    }
    public static int getNumberOfIBooks()
    {
        File iBookFile = new File("IssuedBooks.txt");
        int i = 0;
        try {
            Scanner iBookSc = new Scanner(iBookFile);
            while(iBookSc.hasNextLine())
            {
                iBookSc.nextLine();
                i++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException!!");
            exit(-1);
        }
        return i++;
    }
    public static IssuedBook[] issuedBooksLoad()
    {
        File iBookFile = new File("IssuedBooks.txt");
        IssuedBook[] iBooks = new IssuedBook[getNumberOfIBooks()];
        try {
            Scanner iBookSc = new Scanner(iBookFile);
            int i = 0;
            while(i < getNumberOfIBooks())
            {
                String[] info = iBookSc.nextLine().split(",");
                iBooks[i++] = new IssuedBook(info[0],info[1],info[2],info[3],info[4],info[5],info[6],info[7],info[8]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException!!");
            exit(-1);
        }
        return iBooks;
        
    }
    public static void issuedBooksUpload()
    {
        try {
            FileWriter writer = new FileWriter("IssuedBooks.txt");
            int length = Data.issuedBooks.length;
            IssuedBook[] iBks = Data.issuedBooks;
            for(int i =0; i<length; i++)
                writer.write( iBks[i].getBookCallNo() + "," + iBks[i].getBookName() + "," + iBks[i].getBookAuthor() + "," + iBks[i].getBookPublisher() + "," + iBks[i].getStudentId() + "," + iBks[i].getStudentName() + "," + iBks[i].getStudentContact() + "," + iBks[i].getIssueDate() + "," + iBks[i].getReturnDate() + "\n");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Can't write in file!!");
            exit(-1);
        }
    }
    public static int getNumberOfStudents()
    {
        File studentFile = new File("Students.txt");
        int i = 0;
        try {
            Scanner studentSc = new Scanner(studentFile);
            while(studentSc.hasNextLine())
            {
                studentSc.nextLine();
                i++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException!!");
            exit(-1);
        }
        return i++;
    }
    public static Student[] studentsLoad()
    {
        File studentFile = new File("Students.txt");
        int numStudents = getNumberOfStudents();
        Student[] students = new Student[numStudents];
        int i = 0;
        try {
            Scanner studentSc = new Scanner(studentFile);
            while(i < numStudents)
            {
                String[] info = studentSc.nextLine().split(",");
                if(info[7].equals("0"))
                {
                    students[i++] = new Student(info[0], info[1], info[2], info[3], info[4], info[5], info[6]);
                }
                else
                {
                    int numHeIssue = parseInt(info[7]);
                    IssuedBook[] booksHeIssue = new IssuedBook[3];
                    int j = 0;
                    while(j < numHeIssue)
                    {
                        booksHeIssue[j] = new IssuedBook(info[8+(j*4)], info[9+(j*4)], info[10+(j*4)], info[11+(j*4)]);
                        j++;
                    }
                    students[i++] = new Student(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], booksHeIssue);
                }
                
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException!!");
            exit(-1);
        }
        return students;
    }
    
    public static void studentsUpload()
    {
        try {
            FileWriter writer = new FileWriter("Students.txt");
            int length = Data.students.length;
            Student[] std = Data.students;
            for(int i =0; i<length; i++)
            {
                switch (std[i].getNumberOfIssuedBooks()) {
                    case 0:
                        writer.write( std[i].getPersonId() + "," + std[i].getPersonName() + "," + std[i].getPersonPassword() + "," + std[i].getPersonEmail() + "," + std[i].getPersonAddress() + "," + std[i].getPersonCity() + "," + std[i].getPersonContact() + ",0\n");
                        break;
                    case 1:
                        writer.write( std[i].getPersonId() + "," + std[i].getPersonName() + "," + std[i].getPersonPassword() + "," + std[i].getPersonEmail() + "," + std[i].getPersonAddress() + "," + std[i].getPersonCity() + "," + std[i].getPersonContact() + "," + std[i].getNumberOfIssuedBooks() + "," + std[i].getIssuedBook1() + "\n");
                        break;
                    case 2:
                        writer.write( std[i].getPersonId() + "," + std[i].getPersonName() + "," + std[i].getPersonPassword() + "," + std[i].getPersonEmail() + "," + std[i].getPersonAddress() + "," + std[i].getPersonCity() + "," + std[i].getPersonContact() + "," + std[i].getNumberOfIssuedBooks() + "," + std[i].getIssuedBook1_2() + "\n");
                        break;
                    case 3:
                        writer.write( std[i].getPersonId() + "," + std[i].getPersonName() + "," + std[i].getPersonPassword() + "," + std[i].getPersonEmail() + "," + std[i].getPersonAddress() + "," + std[i].getPersonCity() + "," + std[i].getPersonContact() + "," + std[i].getNumberOfIssuedBooks() + "," + std[i].getIssuedBook1_2_3() + "\n");
                        break;
                    default:
                        break;
                }
            }   
            writer.close();
        } catch (IOException ex) {
            System.out.println("Can't write in file!!");
            exit(-1);
        }
    }
    
}
