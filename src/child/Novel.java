package child;

import parent.Author;
import parent.EBook;

public class Novel extends EBook {
    private String genre;

    // default Constructor
    public Novel() {
    }

    // Constructor dengan Parameter
    public Novel(String bookCode, String title, Author author, Publisher publisher, double price, String genre) {
        super(bookCode, title, author, publisher, price);
        this.genre = genre;
    }
    
    // Getter & Setter
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // override method calculatePrice
    @Override
    public void calculatePrice() {
    }

    // override method toString
    @Override
    public String toString() {
        return "Novel{" +
                "genre='" + genre + '\'' +
                "} " + super.toString();
    }

    

}
