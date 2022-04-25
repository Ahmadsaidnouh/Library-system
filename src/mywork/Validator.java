/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mywork;

import static java.lang.Integer.parseInt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ahmad Nouh
 */
public class Validator {
    
    
    public static boolean isNewBookCallNo(String callNo, Book[] books) {
        int length = books.length;
        int i = 0;
        while (i < length) {
            if (callNo.equals(books[i].getBookCallNo())) {
                return false;
            }
            i++;
        }
        return true;
    }
    
    public static boolean isValidReturnDate(int yearR, int monthR, int dayR, String returnDate, String currentDate) {
        
        int length = returnDate.length();
        if (length != 10) {
            return false;
        }
        if (!((dayR >= 1 && dayR <= 31) && (monthR >= 1 && monthR <= 12))) {
            return false;
        }
        if (monthR == 2 && dayR == 29 && yearR % 4 != 0) {
            return false;
        } else if (monthR == 2 && dayR > 29) {
            return false;
        } else if ((monthR == 2 || monthR == 4 || monthR == 6 || monthR == 9 || monthR == 11) && (dayR == 31)) {
            return false;
        }
        DateFormat dateFormat = new SimpleDateFormat("YYYY");
        Date date = new Date();
        int yearC = parseInt(dateFormat.format(date));
        dateFormat = new SimpleDateFormat("MM");
        int monthC = parseInt(dateFormat.format(date));
        dateFormat = new SimpleDateFormat("dd");
        int dayC = parseInt(dateFormat.format(date));

        if (yearR < yearC) {
            return false;
        } else if (yearR == yearC && monthR < monthC) {
            return false;
        } else if (yearR == yearC && monthR == monthC && dayR < dayC) {
            return false;
        } else {
            return true;
        } 

    }
    
    public static boolean isNewStudentId(String sId, Student[] students) {
        int length = students.length;
        int i = 0;
        while (i < length) {
            if (sId.equals(students[i].getPersonId())) {
                return false;
            }
            i++;
        }
        return true;
    }
    
    public static boolean isBookExisting(Book book)
    {
        Book[] books = Data.books;
        int length = books.length;
        for(int i = 0; i < length; i++)
        {
            if(book.getBookCallNo().equals(books[i].getBookCallNo()) &&
                    book.getBookName().equals(books[i].getBookName()) &&
                    book.getBookAuthor().equals(books[i].getBookAuthor()) &&
                    book.getBookPublisher().equals(books[i].getBookPublisher()) )
                return true;
                
        }
        return false;
    }
    
    public static boolean isStudentExisting(String sId, String sName, String sContact, Student[] students)
    {
        int length = students.length;
        int i = 0;
        while(i < length)
        {
            if(sId.equals(students[i].getPersonId()) && sName.equals(students[i].getPersonName()) && sContact.equals(students[i].getPersonContact()))
                return true;
            i++;
        }
        return false;
    }
    
    public static boolean heCanIssue(String sId, String sName, String sContact, Student[] students)
    {
        int length = students.length;
        int i = 0;
        while(i < length)
        {
            if(sId.equals(students[i].getPersonId()) && sName.equals(students[i].getPersonName()) && sContact.equals(students[i].getPersonContact()))
                if(students[i].getNumberOfIssuedBooks() < 3)
                    return true;
            i++;
        }
        return false;
    }
    
    public static boolean aBookToIssueExists(String bookCallNo, Book[] books)
    {
        int length = books.length;
        int i = 0;
        while(i < length)
        {
            if(bookCallNo.equals(books[i].getBookCallNo()))
                if((parseInt(books[i].getnumberIssued()) + 1) <= (parseInt(books[i].getBookQuantity())))
                    return true;
            i++;
            
        }
        return false;
    }
    
    public static boolean heIssueThisBook(String sId, String bkCallNo)
    {
        IssuedBook[] issBks = Data.issuedBooks;
        int length = issBks.length;
        for(int i = 0; i < length; i++)
        {
            if(sId.equals(issBks[i].getStudentId()) && bkCallNo.equals(issBks[i].getBookCallNo()))
                return true;
        }
        return false;
        
    }
    
    public static boolean willBePenalized(String bkCallNo) {
        String returnDate = "";
        String currentDate;
        int length = Data.issuedBooks.length;
        for (int i = 0; i < length; i++) {
            if (bkCallNo.equals(Data.issuedBooks[i].getBookCallNo())) {
                returnDate = Data.issuedBooks[i].getReturnDate();
                break;
            }
        }
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        Date date = new Date();
        currentDate = dateFormat.format(date);

        String[] crd = currentDate.split("-");
        int yearC = parseInt(crd[0]);
        int monthC = parseInt(crd[1]);
        int dayC = parseInt(crd[2]);
        String[] rd = returnDate.split("-");
        int yearR = parseInt(rd[0]);
        int monthR = parseInt(rd[1]);
        int dayR = parseInt(rd[2]);

        if (yearR < yearC) {
                //System.out.println("case 1:(yearR<yearC)\nyearR = " + yearR + "\nyearC = " + yearC);
                return true;
            
        } else if (yearR == yearC && monthR < monthC) {
            //System.out.println("case 2:(yearR==yearC && monthR<monthC)\nyearR = " + yearR + "\nyearC = " + yearC + "\nmonthR = " + monthR + "\nmonthC = " + monthC);
            return true;
        } else if (yearR == yearC && monthR == monthC && dayR < dayC) {
            //System.out.println("case 3:(yearR==yearC && monthR==monthC && dayR<dayC)\nyearR = " + yearR + "\nyearC = " + yearC + "\nmonthR = " + monthR + "\nmonthC = " + monthC + "\ndayR = " + dayR + "\ndayC = " + dayC );
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean isValidEmail(String string)
    {
        int length = string.length();
        int i;
        boolean isAtBeforeDot = false;
        int atIndex = 0;
        int dotIndex = 0;
        
         //validate that the string is atleast 6 characters
        if(length < 7)
            return false;
        //validate that the first character is either A--->Z or a--->z
        if(!((string.charAt(0) >= 'A' && string.charAt(0) <='Z') || (string.charAt(0) >= 'a' && string.charAt(0) <='z')))
            return false;
        
        //validate that the last character is from A--->Z or a--->z
        if(!((string.charAt(length - 1) >= 'A' && string.charAt(length -1) <='Z') || (string.charAt(length - 1) >= 'a' && string.charAt(length - 1) <='z')))
            return false;
        
        //validate that there is atleast two characters before the first '@'
        if(string.charAt(0) == '@' || string.charAt(1) == '@')
            return false;
        
        //validate that the whole string contains allowed characters which are A--->Z or a--->z or 0--->9 0r '.' or '-' or '_' or '@'
        for(i = 0; i < length; i++)
            if(!((string.charAt(i) >= 'A' && string.charAt(i) <='Z') || (string.charAt(i) >= 'a' && string.charAt(i) <='z') || (string.charAt(i) >= '0' && string.charAt(i) <='9') || string.charAt(i) == '_' || string.charAt(i) =='-' || string.charAt(i) == '.' || string.charAt(i) =='@'))
                return false;
        //validate that there is a '@' charcter in the string and there is '.' character that is after that '@'
        for(i = 0; i < length; i++)
        {
            if(string.charAt(i) == '@')
            {
                atIndex = i;
                if(string.charAt(i - 1) == '_' || string.charAt(i - 1) == '-' || string.charAt(i - 1) == '.')
                    return false;
                if(string.charAt(i + 1) == '_' || string.charAt(i - 1) == '-' || string.charAt(i - 1) == '.')
                    return false;
                for(int j = i; j < length; j++)
                { 
                    
                    if(string.charAt(j) == '.')
                    {
                        if (string.charAt(j - 1) == '_' || string.charAt(i - 1) == '-')
                            return false;
                        if (string.charAt(j + 1) == '_' || string.charAt(i - 1) == '-')
                            return false;
                        dotIndex = j;
                        isAtBeforeDot = true;
                    }
                }
                break;
            }
        }
        if(isAtBeforeDot)
        {
            for(i = (atIndex + 1); i < length; i++)
            {
                //validate that all what is after the '@' is either A--->z or a--->z or 0--->9 or '.'
                if(!(string.charAt(i) == '.' || (string.charAt(i) >= 'A' && string.charAt(i) <='Z') || (string.charAt(i) >= 'a' && string.charAt(i) <='z')))
                    return false;
                //validate that no '.' exactly after a '.'
                if(string.charAt(i) == '.' && string.charAt(i + 1) == '.')
                    return false;
            }
                
            return true;
        }
        else
            return false;
    }
    
    public static boolean isLibrarianExisting(String id, String name, String password, String email, String address, String city, String contact)
    {
        int length = Data.librarians.length;
        for(int i = 0; i < length; i++)
        {
            if(id.equals(Data.librarians[i].getPersonId()) && name.equals(Data.librarians[i].getPersonName()) && password.equals(Data.librarians[i].getPersonPassword()) && email.equals(Data.librarians[i].getPersonEmail()) && address.equals(Data.librarians[i].getPersonAddress()) && city.equals(Data.librarians[i].getPersonCity()) && contact.equals(Data.librarians[i].getPersonContact()))
                return true;
        }
        return false;
    }
    
    public static boolean isStudentExisting(String id, String name, String password, String email, String address, String city, String contact)
    {
       
        int length = Data.students.length;
        for(int i = 0; i < length; i++)
        {
            if(id.equals(Data.students[i].getPersonId()) && name.equals(Data.students[i].getPersonName()) && password.equals(Data.students[i].getPersonPassword()) && email.equals(Data.students[i].getPersonEmail()) && address.equals(Data.students[i].getPersonAddress()) && city.equals(Data.students[i].getPersonCity()) && contact.equals(Data.students[i].getPersonContact()))
                return true;
        }
        return false;
    }
    
    public static boolean isStudentExisting(String name, String password)
    {
       
        int length = Data.students.length;
        for(int i = 0; i < length; i++)
        {
            if(name.equals(Data.students[i].getPersonName()) && password.equals(Data.students[i].getPersonPassword()))
                return true;
        }
        return false;
    }
    
    
    public static boolean isNewLibrarianId(String id)
    {
        int length = Data.librarians.length;
        for(int i = 0; i < length; i++)
        {
            if(id.equals(Data.librarians[i].getPersonId())) 
                return false;
        }
        return true;
    }
    
    public static boolean isAvailablePasswordLibrarian(String name, String password)
    {
        int len = password.length();
        int i;
        for(i = 0; i < len; i++)
        {
            if(password.charAt(i) == ' ')
                return false;
        }
        int length = Data.librarians.length;
        for(i = 0; i < length; i++)
        {
            if( name.equals(Data.librarians[i].getPersonName()) && password.equals(Data.librarians[i].getPersonPassword()) )
                return false;
        }
        return true;
    }
    
    public static boolean isAvailablePasswordStudent(String name, String password)
    {
        int len = password.length();
        int i;
        for(i = 0; i < len; i++)
        {
            if(password.charAt(i) == ' ')
                return false;
        }
        int length = Data.students.length;
        for(i = 0; i < length; i++)
        {
            if( name.equals(Data.students[i].getPersonName()) && password.equals(Data.students[i].getPersonPassword()) )
                return false;
        }
        return true;
    }
    
}
