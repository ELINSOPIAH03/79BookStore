package parent;

import child.Publisher;

public class EBook extends CommercialBook{
    private String bookCode;
    private String title;
    private Author author;
    private Publisher publisher;
    private double price;
    

    // Default Constructor
    public EBook() {
    }

    // Constructor dengan Parameter
    public EBook(String bookCode, String title, Author author, Publisher publisher, double price) {
        this.bookCode = bookCode;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    // Getter & Setter
    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method calculatePrice
    public void calculatePrice() {
        // implementasi perhitungan harga jika diperlukan
    }


    // Method toString
    @Override
    public String toString() {
        return "EBook{" +
                "bookCode='" + bookCode + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                ", price=" + price +
                '}';
    }
}
