/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mywork;

/**
 *
 * @author Ahmad Nouh
 */
public class Data {
    public static Admin[] admins = FilesHandler.adminLoad();
    public static Librarian[] librarians = FilesHandler.librarianLoad();
    public static Book[] books = FilesHandler.booksLoad();
    public static IssuedBook[] issuedBooks = FilesHandler.issuedBooksLoad();
    public static Student[] students = FilesHandler.studentsLoad();
    
    
    
}
