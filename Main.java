import java.util.HashSet;
import java.util.Scanner;

class Library{

    HashSet<String> availableBooks = new HashSet<String>();
    HashSet<String> issuedBooks = new HashSet<String>();
    Scanner sc = new Scanner(System.in);

    Library(){
        availableBooks.add("The Alchemist");
        availableBooks.add("The Diary of a Young Girl");
        availableBooks.add("The Kite Runner");
        availableBooks.add("The God of Small Things");
        availableBooks.add("Norwegian Wood");
        availableBooks.add("Ikigai");
        availableBooks.add("The Great Gatsby");
        availableBooks.add("Rich Dad Poor Dad");

        issuedBooks.add("The Subtle Art of Not Giving a F*ck");
        issuedBooks.add("The Power of No");
        issuedBooks.add("The Old Man and the Sea");
    }

    public void showAvailableBooks(){
        System.out.println("The available books are-");
        for(String book: availableBooks){
            System.out.println("* "+book);
        }
        System.out.println();
    }

    public void addBook(){
        System.out.print("Name of the book to be added: ");
        String book = sc.nextLine();
        availableBooks.add(book);
        System.out.println("The book "+book+" is successfully added.\n");
        showAvailableBooks();
    }

    public void showIssuedBooks(){
        System.out.println("The issued books are-");
        for(String book: issuedBooks){
            System.out.println("* "+book);
        }
        System.out.println();
    }

    public void issueBook() {
        System.out.print("Name of the book to be issued: ");
        String book = sc.nextLine();
        if(availableBooks.contains(book)){
            issuedBooks.add(book);
            availableBooks.remove(book);
            System.out.println("The book "+book+" has been successfully issued.\n");
        }
        else{
            System.out.println("This book is not available.\n");
        }
        showAvailableBooks();
        showIssuedBooks();
    }

    public void returnBook() {
        System.out.print("Name of the book to be returned: ");
        String book = sc.nextLine();
        issuedBooks.remove(book);
        availableBooks.add(book);
        System.out.println("The book "+book+" has been successfully returned.\n");
        showAvailableBooks();
        showIssuedBooks();
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("WELCOME TO THE LIBRARY!!!\n");
        int n = -1;
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Show the available books \n2.Add a book \n3.Show the issued books \n4.Issue a book \n5.Return a book \n6.Exit");

        while(n!=6) {
            System.out.print("Enter your choice: ");
            n = sc.nextInt();
            System.out.println();

            switch(n){
                case 1 -> lib.showAvailableBooks();
                case 2 -> lib.addBook();
                case 3 -> lib.showIssuedBooks();
                case 4 -> lib.issueBook();
                case 5 -> lib.returnBook();
                case 6 -> System.out.println("Thank you...");
                default -> System.out.println("Invalid input!!!");
            }
        }
    }
}