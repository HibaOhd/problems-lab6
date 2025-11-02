package problem3;

import java.util.Scanner;

public class test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter library capacity: ");
        int n = sc.nextInt();
        sc.nextLine();
        Library library = new Library(n);

        library.add(new Novel("The Alchemist", "Paulo Coelho", 197, 12.99));
        library.add(new Magazine("Tech Today", "October", 2025));

        int choice;
        do {
            System.out.println("\n1.Display Documents");
            System.out.println("2.Add Document");
            System.out.println("3.Delete Document");
            System.out.println("4.Search by numRec");
            System.out.println("5.Display Authors");
            System.out.println("0.Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    library.displayDocuments();
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author (or leave blank if not a book): ");
                    String author = sc.nextLine();
                    Document doc;
                    if (!author.isEmpty()) {
                        System.out.print("Enter number of pages: ");
                        int pages = sc.nextInt();
                        sc.nextLine();
                        doc = new Book(title, author, pages);
                    }else{
                        doc = new Magazine(title, "November", 2025);
                    }
                    if (library.add(doc))
                        System.out.println("Document added!");
                    else
                        System.out.println("Library full!");
                    break;
                case 3:
                    System.out.print("Enter document numRec to delete: ");
                    int num = sc.nextInt();
                    Document d = library.document(num);
                    if (d != null && library.delete(d))
                        System.out.println("Document deleted.");
                    else
                        System.out.println("Document not found.");
                    break;
                case 4:
                    System.out.print("Enter numRec: ");
                    int id = sc.nextInt();
                    Document found = library.document(id);
                    System.out.println(found != null ? found : "Not found");
                    break;
                case 5:
                    library.displayAuthors();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice!= 0);
        sc.close();
    }
}
