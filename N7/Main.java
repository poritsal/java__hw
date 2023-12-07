public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger", 224);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 281);

        Wrapper<Book> wbook1 = new Wrapper<>(book1);
        Wrapper<Book> wbook2 = new Wrapper<>(book2);

        System.out.println("Before swap:");
        System.out.println("Book Wrappers: " + wbook1.getData() + ", " + wbook2.getData());
        wbook1.swap(wbook2);

        System.out.println("\nAfter swap:");
        System.out.println("Book Wrappers: " + wbook1.getData() + ", " + wbook2.getData());
    }
}