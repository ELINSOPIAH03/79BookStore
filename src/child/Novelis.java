package child;

import parent.Author;

public class Novelis extends Author {
    private boolean serial;
    private String rating;

    // default Constructor
    public Novelis() {
    }

    // Constructor dengan Parameter
    public Novelis(String firstName, String lastName, String country, int age, boolean serial, String rating) {
        super(firstName, lastName, country, age);
        this.serial = serial;
        this.rating = rating;
    }

    // Getter & Setter
    public boolean isSerial() {
        return serial;
    }

    public void setSerial(boolean serial) {
        this.serial = serial;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    // override method getFullName
    @Override
    public String getFullName() {
        return super.getFullName() + " (Novelist)";
    }

    // override method toString
    @Override
    public String toString() {
        return "Novelist{" +
                "serial=" + serial +
                ", rating='" + rating + '\'' +
                "} " + super.toString();
    }
}
