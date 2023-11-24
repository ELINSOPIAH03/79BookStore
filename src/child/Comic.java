package child;

import parent.EBook;

public class Comic extends EBook {
    private boolean volumeSeries;
    private double tax;
    private Mangaka mangaka;

    // default Constructor
    public Comic() {
        
    }

    // constructor dengan Parameter
    public Comic(String bookCode, String title, Mangaka mangaka, Publisher publisher, double price, boolean volumeSeries, double tax) {
        super(bookCode, title, mangaka, publisher, price);
        this.volumeSeries = volumeSeries;
        this.tax = tax;
        this.mangaka = mangaka;
    }

    // override method calculatePrice
    @Override
    public void calculatePrice() {
    }
    
    // override method toString
    public String toString() {
        return "Comic{" +
                "volumeSeries=" + volumeSeries +
                ", tax=" + tax +
                ", mangaka=" + mangaka +
                "} " + super.toString();
    }

    // Getter & Setter
    public boolean isVolumeSeries() {
        return volumeSeries;
    }

    public void setVolumeSeries(boolean volumeSeries) {
        this.volumeSeries = volumeSeries;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public Mangaka getMangaka() {
        return this.mangaka;
    }

}
