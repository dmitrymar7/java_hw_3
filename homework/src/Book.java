public class Book {

    private String name;
    private String surnameAuthor;
    private double price;
    private int year;
    private int countPages;


    public Book(String name, String surnameAuthor, double price, int year, int countPages) {
        this.name = name;
        this.surnameAuthor = surnameAuthor;
        this.price = price;
        this.year = year;
        this.countPages = countPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnameAuthor() {
        return surnameAuthor;
    }

    public void setSurnameAuthor(String surnameAuthor) {
        this.surnameAuthor = surnameAuthor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }
}
