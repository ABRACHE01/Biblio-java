import java.util.ArrayList;
public class TestClass {
    public static void main(String[] args ){

        Author author = new Author();
        author.setId(34);
        System.out.println(author.getId());

        BookCopy boit = new BookCopy();
        boit.setStatus(Status.LOST);
        System.out.println(boit.getStatus());

    }

}
