public class ProductEx2 extends Product{

    private String country;
    private double weight;

    public ProductEx2(String name, double price, int grade, String country, double weight) {
        super(name, price, grade);
        this.country = country;
        this.weight = weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
