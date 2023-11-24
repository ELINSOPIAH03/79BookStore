package parent;

public class Author {
    private String firstName;
    private String lastName;
    private String country;
    private int age;

    // default Constructor
    public Author() {
    }

    // constructor dengan Parameter
    public Author(String firstName, String lastName, String country, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
    }

    // Getter & Setter
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Method getFullName
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Method toString
    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName +
                "\nlastName='" + lastName +
                "\ncountry='" + country +
                "\nage=" + age +
                '}';
    }

    
}
