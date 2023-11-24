import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import child.Comic;
import child.Mangaka;
import child.Novelis;
import parent.Author;
import parent.CommercialBook;

public class Main {
    public static void main(String[] args) throws Exception {
        //code
        Scanner scanner = new Scanner(System.in);
        RepositoryBook repositoryBook = new RepositoryBook();
        System.out.println("============================");
        
        while (true) {
            System.out.println("Main Menu");
            System.out.println("1. Book");
            System.out.println("2. Author");
            System.out.println("3. Publisher");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    bookMenu(scanner, repositoryBook);
                    break;
                case 2:
                    authorMenu(scanner, repositoryBook);
                    break;
                case 3:
                    publisherMenu(scanner, repositoryBook);
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void bookMenu(Scanner scanner, RepositoryBook repositoryBook) {
        while (true) {
            System.out.println("\nBook Menu Searching");
            System.out.println("1. Cari data book yang memiliki price paling Murah");
            System.out.println("2. Cari data book yang memiliki price paling Mahal");
            System.out.println("3. Cari data book berdasarkan range Price");
            System.out.println("4. Cari Comic Berdasarkan Rating mangaka");
            System.out.println("5. Cari Book berdasarkan Country dari Publishernya");
            System.out.println("6. Cari Book berdasarkan Country dari Authornya");
            System.out.println("7. Cari data Comic yang memiliki price paling Mahal");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose option: ");

            int bookChoice = scanner.nextInt();
            scanner.nextLine(); 
            RepositoryBook repository = new RepositoryBook();
            List<CommercialBook> allBooks = repository.getAllBooks();
            
            switch (bookChoice) {
                case 1:
                    // Menampilkan buku dengan harga paling murah
                    CommercialBook.displayCheapestBook(allBooks);
                    break;
                case 2:
                    CommercialBook.displayMostExpensiveBooks(allBooks);
                    break;
                case 3:
                    System.out.print("\nMasukan range : ");
                    double range = scanner.nextDouble();
                    System.out.println("Data Book price dibawah "+range+"\n");
                    CommercialBook.displayBooksByPriceRange(allBooks, range);
                    break;
                case 4:
                    displayBooksByCategory(allBooks);
                    break;
                case 5:
                    displayPublisherByCountry(allBooks);
                    break;
                case 6:
                    displayBooksByCountryAuthor(allBooks);
                    break;
                case 7:
                    Optional<Comic> mostExpensiveComic = CommercialBook.getMostExpensiveComic(allBooks);

                    if (mostExpensiveComic.isPresent()) {
                        CommercialBook comic = mostExpensiveComic.get();
                        System.out.println("\nTitle: " + comic.getTitle());
                        System.out.println("Author: " + (comic.getAuthor() != null ? comic.getAuthor().getFullName() : "N/A"));
                        System.out.println("Publisher: " + (comic.getPublisher() != null ? comic.getPublisher().getPublisherName() : "N/A"));
                        System.out.println("Price: " + comic.getPrice());
                    } else {
                        System.out.println("No comic found.");
                    }
                    break;
                case 0:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void authorMenu(Scanner scanner, RepositoryBook repositoryBook) {
        while (true) {
            System.out.println("\nAuthor Menu Searching");
            System.out.println("1. Cari Data semua Mangaka");
            System.out.println("2. Cari Data semua Author");
            System.out.println("3. Cari Data semua Novelis");
            System.out.println("4. Cari author berdasarkan Range umur");
            System.out.println("5. Cari author berdasarkan Country");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose option: ");

            int authorChoice = scanner.nextInt();
            scanner.nextLine();
            RepositoryBook repository = new RepositoryBook();
            List<CommercialBook> allBooks = repository.getAllBooks();

            switch (authorChoice) {
                case 1:
                    displayAllDataMangaka(allBooks);
                    break;
                case 2:
                    displayAllDataAuthor();
                    break;
                case 3:
                    displayAllDataNovelist();
                    break;
                case 4:
                    displayAllDataAuthorRangeAge();
                    break;
                case 5:
                    displayAllDataAuthorByCountry();
                    break;
                case 0:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void publisherMenu(Scanner scanner, RepositoryBook repositoryBook) {
        while (true) {
            System.out.println("\nPublisher Menu Searching");
            System.out.println("1. Cari Publisher dengan productionCost paling Mahal");
            System.out.println("2. Cari Publisher dengan productionCost paling Murah");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose option: ");

            int publisherChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            RepositoryBook repository = new RepositoryBook();
            CommercialBook commercialBook = new CommercialBook();

            switch (publisherChoice) {
                case 1:
                    commercialBook.displayPublisherWithExpensiveProductionCost(repository.getPublishers());
                    break;
                    case 2:
                    commercialBook.displayPublisherWithCheapProductionCost(repository.getPublishers());
                    break;
                case 0:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void displayBooksByCategory(List<CommercialBook> allBooks) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nMasukkan pilihan untuk menampilkan buku komik:");
        System.out.println("1. Best Seller");
        System.out.println("2. Good");
        System.out.println("3. New Comer");
        System.out.print("Choose option :");

        int rating = scanner.nextInt();
        
        List<CommercialBook> bestSellerComics = CommercialBook.getComicsByRating(allBooks, rating);

        // menampilkan hasil
        for (CommercialBook book : bestSellerComics) {
            if (book instanceof Comic) {
                Comic comic = (Comic) book;
                System.out.println("\nRating: " + comic.getMangaka().getRating());
                System.out.println("Mangaka: " + comic.getMangaka().getFullName());
                System.out.println("Title: " + comic.getTitle());
            }
        }

    }

    private static void displayPublisherByCountry(List<CommercialBook> allBooks) {
        System.out.println("\nPilih country publisher");
        System.out.println("1. Indonesia");
        System.out.println("2. Japan");
        System.out.println("3. United Kingdom");
        System.out.println("4. England");
        System.out.println("5. United States");
        System.err.print("Choose option :");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        String selectedCountry = "";
        switch (choice) {
            case 1:
                selectedCountry = "Indonesia";
                break;
            case 2:
                selectedCountry = "Japan";
                break;
            case 3:
                selectedCountry = "United Kingdom";
                break;
            case 4:
                selectedCountry = "England";
                break;
            case 5:
                selectedCountry = "United States";
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        List<CommercialBook> booksByCountry = CommercialBook.getBooksByPublisherCountry(allBooks, selectedCountry);

        for (CommercialBook book : booksByCountry) {
            System.out.println("\nJenis buku: " + book.getClass().getSimpleName());
            System.out.println("Publisher: " + book.getPublisher().getPublisherName());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + (book.getAuthor() instanceof Author ? ((Author) book.getAuthor()).getFullName() : "N/A"));
            System.out.println("Pricenya: " + book.getPrice());
        }
    }
    
    private static void displayBooksByCountryAuthor(List<CommercialBook> allBooks) {
        System.out.println("\nPilih Country Author:");
        System.out.println("1. Indonesia");
        System.out.println("2. Japan");
        System.out.println("3. United States");
        System.out.println("4. England");
        System.err.print("Choose option :");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        String country;
        switch (choice) {
            case 1:
                country = "Indonesia";
                break;
            case 2:
                country = "Japan";
                break;
            case 3:
                country = "United States";
                break;
            case 4:
                country = "England";
                break;
            default:
                country = "N/A";
        }

        List<CommercialBook> booksByAuthorCountry = CommercialBook.getBooksByAuthorCountry(allBooks, country);

        // menampilkan hasil pencarian
        for (CommercialBook book : booksByAuthorCountry) {
            System.out.println("Jenis Buku: " + book.getClass().getSimpleName());
            System.out.println("Country Author: " + book.getAuthor().getCountry());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + (book.getAuthor() instanceof Author ? ((Author) book.getAuthor()).getFullName() : "N/A"));
            System.out.println("Price: " + book.getPrice());
            System.out.println("Publisher: " + book.getPublisher().getPublisherName());
            System.out.println();
        }
    }

    private static void displayAllDataMangaka(List<CommercialBook> allBooks) {
        List<Mangaka> allMangakas = CommercialBook.getAllMangakas(allBooks);

        if (!allMangakas.isEmpty()) {
            System.out.println("List of all Mangakas:");

            for (Mangaka mangaka : allMangakas) {
                System.out.println("\nNama: " + mangaka.getFullName());
                System.out.println("Country: " + mangaka.getCountry());
                System.out.println("Age: " + mangaka.getAge());
                System.out.println("Rating: " + mangaka.getRating());
            }
        } else {
            System.out.println("No Mangaka found.");
        }
    }

    private static void displayAllDataNovelist() {
        RepositoryBook repositoryBook = new RepositoryBook();
        List<Novelis> novelists = repositoryBook.getNovelists();

        // Menampilkan data novelis
        System.out.println("Data Novelis:");
        for (Novelis novelist : novelists) {
            System.out.println("\nNama: " + novelist.getFullName());
            System.out.println("Country: " + novelist.getCountry());
            System.out.println("Age: " + novelist.getAge());
            System.out.println("Rating: " + novelist.getRating());
            System.out.println();
        }
        
    }
    
    private static void displayAllDataAuthor() {
        RepositoryBook repositoryBook = new RepositoryBook();
        List<Author> authors = repositoryBook.getAuthors();

        // Menampilkan data author
        System.out.println("\nData Author:");
        for (Author author : authors) {
            System.out.println("Nama: " + author.getFullName());
            System.out.println("Country: " + author.getCountry());
            System.out.println("Age: " + author.getAge());
            System.out.println();
        }
    }

    private static void displayAllDataAuthorRangeAge(){
        RepositoryBook repositoryBook = new RepositoryBook();
        List<Author> allAuthors = repositoryBook.getAuthors();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan range umur : ");
        int maxAge = scanner.nextInt();
        List<Author> authorsInAgeRange = CommercialBook.getAuthorsByAgeRange(allAuthors, maxAge);

        System.out.println("\nData Authors (Mangaka, Novelis, Author) dengan Range Umur " + maxAge + " ke bawah:");
        if (authorsInAgeRange.isEmpty()) {
            System.out.println("Tidak ada data author dalam range umur yang dimasukkan.");
        } else {
            for (Author author : authorsInAgeRange) {
                System.out.println("Nama: " + author.getFullName());
                System.out.println("Country: " + author.getCountry());
                System.out.println("Age: " + author.getAge());
                System.out.println();
            }
        }
    }

    private static void displayAllDataAuthorByCountry(){
        RepositoryBook repository = new RepositoryBook();
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("\nPilih Country Author:");
        System.out.println("1. Indonesia");
        System.out.println("2. Japan");
        System.out.println("3. United States");
        System.out.println("4. England");

        System.out.print("Choose option: ");
        int option = scanner.nextInt();

        String selectedCountry = "";
        switch (option) {
            case 1:
                selectedCountry = "Indonesia";
                break;
            case 2:
                selectedCountry = "Japan";
                break;
            case 3:
                selectedCountry = "United States";
                break;
            case 4:
                selectedCountry = "England";
                break;
            default:
                System.out.println("Invalid option");
                return;
        }

        List<Author> authorsInCountry = CommercialBook.getAuthorsByCountry(repository.getAllBooks(), selectedCountry);

        System.out.println("\nCountry Author: " + selectedCountry);
        for (Author author : authorsInCountry) {
            System.out.println("Author Name: " + author.getFullName());
            System.out.println("Age: " + author.getAge());
            System.out.println();
        }
    }
}
