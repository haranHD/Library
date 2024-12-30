import java.util.Scanner;
import java.util.ArrayList;
class Lib{
    Integer id;
    String title;
    String author;
    boolean borrow;
    public Lib(Integer id,String title ,String author){
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public void borrowBook() {
        this.borrow = true;
    }
    public void returnBook() {
        this.borrow = false;
    }
}
class Book{
    private static ArrayList<Lib> library = new ArrayList<>();
    //MENU:
    public static void display(){
        System.out.println("MENU:\n 1 . Add_Book\n 2 . Search\n 3 . View_Book\n 4 . Borrow\n 5 . Return_Book\n 6 . EXIT");
    }

    //ADD_BOOK:
    public static void Add_Book(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID :");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Title : ");
        String title = sc.nextLine();
        System.out.print("Author Name : ");
        String author = sc.nextLine();

        library.add(new Lib(id,title,author));
        System.out.println("Book Is Added Successfully..");
    }

    //VIEW_BOOK:
    public static void View_Book(){
        for(Lib book : library){
            System.out.println("ID : "+book.id + "\nTITLE : "+book.title+"\nAuthor : "+book.author+"\nBorrowed : "+book.borrow);
        }
    }

    //SEARCH:
    public static void Search(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Title :");
        String find = sc.nextLine().toLowerCase();
        boolean found = false;
        for(Lib book : library){
            if(book.title.toLowerCase().contains(find)){
                System.out.println("ID : "+book.id + "\nTITLE : "+book.title+"\nAuthor : "+book.author+"\nBorrowed : "+book.borrow);
                found = true;
            }
        }
        if(!found)
        System.out.println("Not Found.");
    }

    //BORROW:
    public static void Borrow(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Book name :");
        String status = sc.nextLine();
        for(Lib book : library){
            if(book.title.contains(status)){
                book.borrow =true;
                System.out.println("ID : "+book.id + "\nTITLE : "+book.title+"\nAuthor : "+book.author+"\nBorrowed : "+book.borrow);
            }
        }
         
    }

    //RETURN:
    public static void Return(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Book name You Returning:");
        String status = sc.nextLine();
        for(Lib book : library){
            if(book.title.contains(status)){
                book.borrow =false;
                System.out.println("ID : "+book.id + "\nTITLE : "+book.title+"\nAuthor : "+book.author+"\nBorrowed : "+book.borrow);
            }
        }
    }

    public static void main(String[] a){
        Scanner sc = new Scanner(System.in);
        while(true){
            display();
            System.out.println("Enter the Function Number You want :");
            int num =sc.nextInt();
            
            switch(num){
                case 1:
                    Add_Book();
                    break;
                case 2:
                    Search();
                    break;
                case 3:
                    View_Book();
                    break;
                case 4:
                    Borrow();
                    break;
                case 5:
                    Return();
                    break;
                case 6:
                    System.out.print("Exiting...");
                    return;
                default:
                    System.out.print("Invalid Input.");
            }
        }
    }
    
}