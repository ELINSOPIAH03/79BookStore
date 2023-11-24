import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import child.Comic;
import child.Mangaka;
import child.Novel;
import child.Novelis;
import child.Publisher;
import parent.Author;
import parent.CommercialBook;
import parent.EBook;

public class RepositoryBook {
    private List<EBook> eBooks;
    private List<Novel> novels;
    private List<Comic> comics;
    private List<Mangaka> mangakas;
    private List<Novelis> novelists;
    private List<Author> authors;
    private List<Publisher> publishers;

    // default Constructor
    public RepositoryBook() {
        // inisialisasi list eBooks, novels, comics, mangakas, novelists, authors, dan publishers
        eBooks = new ArrayList<>();
        novels = new ArrayList<>();
        comics = new ArrayList<>();
        mangakas = new ArrayList<>();
        novelists = new ArrayList<>();
        authors = new ArrayList<>();
        publishers = new ArrayList<>();

        // menambahkan data ke dalam list
        initData();
    }

    // method untuk inisialisasi data
    private void initData() {
        // data Author
        Author author1 = new Author("Haidar", "Musyafa", "Indonesia", 30);
        Author author2 = new Author("Bert", "Bates", "United States", 50);
        Author author3 = new Author("Barry", "Burd", "United States", 52);
        Author author4 = new Author("Mark", "Manson", "United States", 38);
        Author author5 = new Author("Andi", "Susanto", "Indonesia", 32);
        Author author6 = new Author("Adi", "Sutanto", "Indonesia", 27);

        // data Novelis
        Novelis novelis1 = new Novelis("J.K", "Rowling", "England", 57, true, "Best Seller");
        Novelis novelis2 = new Novelis("Tere", "Liye", "Indonesia", 35, true, "Best Seller");
        Novelis novelis3 = new Novelis("Dee", "Lestari", "Indonesia", 30, true, "Good");
        Novelis novelis4 = new Novelis("Faisal", "Syahreza", "Indonesia", 40, true, "New Comer");
        Novelis novelis5 = new Novelis("Julia", "Golding", "England", 41, false, "Best Seller");

        // data Mangaka
        Mangaka mangaka1 = new Mangaka("Masashi", "Kishimoto", "Japan", 48, "Best Seller");
        Mangaka mangaka2 = new Mangaka("Yoshihiro", "Togashi", "Japan", 56, "Good");
        Mangaka mangaka3 = new Mangaka("Eiichiro", "Oda", "Japan", 57, "Best Seller");
        Mangaka mangaka4 = new Mangaka("Rizki", "Anwar", "Indonesia", 25, "New Comer");
        Mangaka mangaka5 = new Mangaka("Yusuf", "Fadli", "Indonesia", 32, "New Comer");

        // data Publisher
        Publisher publisher1 = new Publisher("Bloomsbury", "United Kingdom", 30.0);
        Publisher publisher2 = new Publisher("Gramedia", "Indonesia", 50.0);
        Publisher publisher3 = new Publisher("Mizan", "Indonesia", 25.0);
        Publisher publisher4 = new Publisher("Shueisha", "Japan", 25.0);
        Publisher publisher5 = new Publisher("Elex Media Komputindo", "Indonesia", 12.0);
        Publisher publisher6 = new Publisher("Gramedia Pustaka Utama", "Indonesia", 15.0);
        Publisher publisher7 = new Publisher("Lion Hudson", "England", 15.0);
        Publisher publisher8 = new Publisher("O Reilly Media", "United States", 30.0);
        Publisher publisher9 = new Publisher("Harper One", "United States", 25.0);

        // data E-Book
        EBook eBook1 = new EBook("Book-001", "Memahami Hamka", author1, publisher3, 30.0);
        EBook eBook2 = new EBook("Book-002", "Head First Java: Your Brain on Java - A Learner's Guide", author2, publisher8, 36.0);
        EBook eBook3 = new EBook("Book-003", "Java For Dummies", author3, publisher8, 36.0);
        EBook eBook4 = new EBook("Book-004", "Flutter For Dummies", author3, publisher8, 36.0);
        EBook eBook5 = new EBook("Book-005", "The Subtle Art of Not Giving", author4, publisher9, 30.0);
        EBook eBook6 = new EBook("Book-006", "Will", author4, publisher9, 30.0);
        EBook eBook7 = new EBook("Book-007", "Sejarah Indonesia", author5, publisher6, 18.0);
        EBook eBook8 = new EBook("Book-008", "Teknologi Baru", author6, publisher5, 14.5);

        // data Novel
        Novel novel1 = new Novel("Novel-001", "Harry Potter and the Philosopher's Stone", novelis1, publisher1, 45.0, "Fantasy");
        Novel novel2 = new Novel("Novel-002", "Harry Potter and the Chamber of Secrets", novelis1, publisher1, 45.0, "Fantasy");
        Novel novel3 = new Novel("Novel-003", "Harry Potter and the Prisoner of Azkaban", novelis1, publisher1, 45.0, "Fantasy");
        Novel novel4 = new Novel("Novel-004", "Ayah Aku Berbeda", novelis2, publisher2, 75.0, "Drama");
        Novel novel5 = new Novel("Novel-005", "Madre", novelis3, publisher2, 67.5, "Drama");
        Novel novel6 = new Novel("Novel-006", "Lagu untuk Renjana", novelis4, publisher3, 31.5, "Drama");
        Novel novel7 = new Novel("Novel-007", "Semoga Lekas Lega", novelis4, publisher3, 31.5, "Drama");
        Novel novel8 = new Novel("Novel-008", "The Abbey Mystery", novelis5, publisher7, 22.5, "Fiction");

        // data Comic
        Comic comic1 = new Comic("Comic-001", "Uzumaki Naruto", mangaka1, publisher4, 33.75, true, 0.0);
        Comic comic2 = new Comic("Comic-002", "The Worst Client", mangaka1, publisher4, 33.75, true, 0.0);
        Comic comic3 = new Comic("Comic-003", "For the Sake of Dreams...!!", mangaka1, publisher4, 33.75, true, 0.0);
        Comic comic4 = new Comic("Comic-004", "Hunter X Hunter : The Day of Departure", mangaka2, publisher4, 36.25, true, 0.0);
        Comic comic5 = new Comic("Comic-005", "Hunter X Hunter : A Struggle in the Mist", mangaka2, publisher4, 36.25, true, 0.0);
        Comic comic6 = new Comic("Comic-006", "One Piece", mangaka3, publisher2, 75.00, true, 0.0);
        Comic comic7 = new Comic("Comic-007", "Petualangan di Indonesia", mangaka4, publisher6, 18.75, false, 0.0);
        Comic comic8 = new Comic("Comic-008", "Petualangan di Jakarta", mangaka5, publisher5, 15.00, false, 0.0);
        // menambahkan data mangaka ke dalam list mangakas
        mangakas.add(mangaka1);
        mangakas.add(mangaka2);
        mangakas.add(mangaka3);
        mangakas.add(mangaka4);
        mangakas.add(mangaka5);

        novelists.add(novelis1);
        novelists.add(novelis2);
        novelists.add(novelis3);
        novelists.add(novelis4);
        novelists.add(novelis5);

        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
        authors.add(author4);
        authors.add(author5);
        authors.add(author6);

        publishers.add(publisher1);
        publishers.add(publisher2);
        publishers.add(publisher3);
        publishers.add(publisher4);
        publishers.add(publisher5);
        publishers.add(publisher6);
        publishers.add(publisher7);
        publishers.add(publisher8);
        publishers.add(publisher9);

        eBooks.add(eBook1);
        eBooks.add(eBook2);
        eBooks.add(eBook3);
        eBooks.add(eBook4);
        eBooks.add(eBook5);
        eBooks.add(eBook6);
        eBooks.add(eBook7);
        eBooks.add(eBook8);

        novels.add(novel1);
        novels.add(novel2);
        novels.add(novel3);
        novels.add(novel4);
        novels.add(novel5);
        novels.add(novel6);
        novels.add(novel7);
        novels.add(novel8);

        comics.add(comic1);
        comics.add(comic2);
        comics.add(comic3);
        comics.add(comic4);
        comics.add(comic5);
        comics.add(comic6);
        comics.add(comic7);
        comics.add(comic8);
    }

    public List<CommercialBook> getAllBooks() {
    List<CommercialBook> allBooks = new ArrayList<>();

    // menggabungkan semua list menjadi satu dengan addAll
    Collections.addAll(allBooks, eBooks.toArray(new CommercialBook[0]));
    Collections.addAll(allBooks, novels.toArray(new CommercialBook[0]));
    Collections.addAll(allBooks, comics.toArray(new CommercialBook[0]));

    // Mengembalikan list semua buku
    return allBooks;
    }

    public List<Comic> getComics() {
        return comics;
    }

    public List<Comic> getComicsByRating(int userInput) {
        return comics;
    }

    public List<Author> getAuthors() {
    return authors.stream()
                    .filter(author -> author.getClass().equals(Author.class))
                    .collect(Collectors.toList());
    }

    public List<Novelis> getNovelists() {
        return novelists;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

}
