package child;


import parent.Author;

public class Mangaka extends Author {
    private String rating;

    // default Constructor
    public Mangaka() {
    }

    // Constructor dengan Parameter
    public Mangaka(String firstName, String lastName, String country, int age, String rating) {
        super(firstName, lastName, country, age);
        this.rating = rating;
    }

    // Getter & Setter
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    //override method getFullName
    @Override
    public String getFullName() {
        return super.getFullName() + " (Mangaka)";
    }

    //override method toString
    @Override
    public String toString() {
        return "Mangaka{" +
                "rating='" + rating + '\'' +
                "} " + super.toString();
    }
}
