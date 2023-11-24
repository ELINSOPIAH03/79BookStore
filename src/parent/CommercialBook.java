package parent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import child.Comic;
import child.Mangaka;
import child.Publisher;


public class CommercialBook {
    // private Publisher publisher;
    // private List<Author> authors;

    public double getPrice() {
        return getPrice();
    }

    public String getTitle() {
        return null;
    }

    public Author getAuthor() {
        return null;
    }

     // metode untuk mendapatkan buku dengan harga paling murah
    public static Optional<CommercialBook> getCheapestBook(List<CommercialBook> books) {
        return books.stream()
                .min(Comparator.comparingDouble(CommercialBook::getPrice));
    }

    // metode untuk menampilkan data buku dengan harga paling murah
    public static void displayCheapestBook(List<CommercialBook> allBooks) {
        Optional<CommercialBook> cheapestBook = getCheapestBook(allBooks);

        if (cheapestBook.isPresent()) {
            CommercialBook book = cheapestBook.get();
            System.out.println("\nJenis Buku: " + book.getClass().getSimpleName());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + (book.getAuthor() != null ? ((Author) book.getAuthor()).getFullName() : "N/A"));
            System.out.println("Price: " + book.getPrice());
        } else {
            System.out.println("Tidak ada buku yang ditemukan.");
        }
    }

    public static List<CommercialBook> getMostExpensiveBooks(List<CommercialBook> books) {
        Optional<CommercialBook> mostExpensiveBook = books.stream()
                .max(Comparator.comparingDouble(CommercialBook::getPrice));

        // Menggunakan filter untuk mengambil semua buku dengan harga yang sama dengan yang paling mahal
        return mostExpensiveBook.map(book ->
                books.stream()
                        .filter(b -> Double.compare(b.getPrice(), book.getPrice()) == 0)
                        .toList())
                .orElse(List.of());
    }

    //method untuk mendapatkan buku paling mahal
    public static void displayMostExpensiveBooks(List<CommercialBook> books) {
        List<CommercialBook> mostExpensiveBooks = getMostExpensiveBooks(books);

        if (!mostExpensiveBooks.isEmpty()) {
            System.out.println("Buku-buku dengan harga paling mahal:");

            for (CommercialBook book : mostExpensiveBooks) {
                System.out.println("\nJenis buku: " + book.getClass().getSimpleName());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + (book.getAuthor() instanceof Author ? ((Author) book.getAuthor()).getFullName() : "N/A"));
                System.out.println("Pricenya: " + book.getPrice());
                System.out.println();
            }
        } else {
            System.out.println("Tidak ada buku yang ditemukan.");
        }
    }

    //method untuk mendapatkan range price
    public static List<CommercialBook> getBooksByPriceRange(List<CommercialBook> books, double maxPrice) {
        List<CommercialBook> booksInPriceRange = new ArrayList<>();

        for (CommercialBook book : books) {
            if (book.getPrice() <= maxPrice) {
                booksInPriceRange.add(book);
            }
        }

        return booksInPriceRange;
    }

    public static void displayBooksByPriceRange(List<CommercialBook> books, double maxPrice) {
        List<CommercialBook> booksInPriceRange = getBooksByPriceRange(books, maxPrice);

        if (!booksInPriceRange.isEmpty()) {
            for (CommercialBook book : booksInPriceRange) {
                System.out.println("Jenis buku: " + book.getClass().getSimpleName());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + (book.getAuthor() instanceof Author ? ((Author) book.getAuthor()).getFullName() : "N/A"));
                System.out.println("Price: " + book.getPrice());
                System.out.println();
            }
        } else {
            System.out.println("Tidak ada buku dalam range harga yang ditentukan.");
        }
    }

    //method untuk mendapatkan comic by rating
    public static List<CommercialBook> getComicsByRating(List<CommercialBook> books, int rating) {
        return books.stream()
                .filter(book -> book instanceof Comic)
                .map(book -> (Comic) book)
                .filter(comic -> {
                    if (rating == 1) {
                        return comic.getMangaka().getRating().equalsIgnoreCase("Best Seller");
                    } else if (rating == 2) {
                        return comic.getMangaka().getRating().equalsIgnoreCase("Good");
                    } else if (rating == 3) {
                        return comic.getMangaka().getRating().equalsIgnoreCase("New Comer");
                    }else{
                        System.out.println("Pilihan hanya 1-3");
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    //method untuk mendapatkn book berdasarkan Publisher country
    public static List<CommercialBook> getBooksByPublisherCountry(List<CommercialBook> books, String country) {
        List<CommercialBook> booksByCountry = new ArrayList<>();
        for (CommercialBook book : books) {
            Publisher publisher = book.getPublisher();

            if (publisher != null && publisher.getCountry().equalsIgnoreCase(country)) {
                booksByCountry.add(book);
            }
        }
    
        return booksByCountry;
    }

    public Publisher getPublisher() {
        return null;
    }

    //method untuk mendapatkan book by author country
    public static List<CommercialBook> getBooksByAuthorCountry(List<CommercialBook> books, String country) {
        return books.stream()
                .filter(book -> book.getAuthor().getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
    }

    //method untuk mendapatkan comic price mahal
    public static Optional<Comic> getMostExpensiveComic(List<CommercialBook> books) {
        return books.stream()
                .filter(book -> book instanceof Comic)
                .map(book -> (Comic) book)
                .max(Comparator.comparingDouble(CommercialBook::getPrice));
    }

    // menampilkan seluruh data mangaka
    public static List<Mangaka> getAllMangakas(List<CommercialBook> books) {
        return books.stream()
                .filter(book -> book instanceof Comic)
                .map(book -> ((Comic) book).getMangaka())
                .collect(Collectors.toList());
    }

    // menampilkan range umur author
    public static List<Author> getAuthorsByAgeRange(List<Author> authors, int maxAge) {
        return authors.stream()
                .filter(author -> author.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    // menampilkan author by coubtry
    public static List<Author> getAuthorsByCountry(List<CommercialBook> books, String country) {
        return books.stream()
                .filter(book -> book.getAuthor() != null && book.getAuthor().getCountry().equalsIgnoreCase(country))
                .map(book -> book.getAuthor())
                .collect(Collectors.toList());
    }

    // menampilkan publisher mahal murah 
    public void displayPublisherWithExpensiveProductionCost(List<Publisher> publishers) {
        Publisher maxProductionCostPublisher = publishers.stream()
                .max(Comparator.comparingDouble(Publisher::getProductionCost))
                .orElse(null);

        System.out.println("Publisher Production Cost Termahal:");
        displayPublisherInfo(maxProductionCostPublisher);
    }

    public void displayPublisherWithCheapProductionCost(List<Publisher> publishers) {
        Publisher minProductionCostPublisher = publishers.stream()
                .min(Comparator.comparingDouble(Publisher::getProductionCost))
                .orElse(null);

        System.out.println("Publisher Production Cost Mahal:");
        displayPublisherInfo(minProductionCostPublisher);
    }

    private void displayPublisherInfo(Publisher publisher) {
        if (publisher != null) {
            System.out.println("\nPublisher: " + publisher.getPublisherName());
            System.out.println("Country: " + publisher.getCountry());
            System.out.println("Production Cost: " + publisher.getProductionCost());
            System.out.println();
        } else {
            System.out.println("No publisher found.");
        }
    }

}
