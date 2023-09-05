import java.util.ArrayList;
public class Author {
    private int id ;
    private String name ;
    private ArrayList<Book> books;

    public Author(int id , String name ){
        this.id = id ;
        this.name = name ;
    }

    public Author(){
    }
    //id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}

