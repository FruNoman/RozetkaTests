package products;

public class Smartphone implements Product {
    private String name;
    private String price;

    public void setName(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(String price) {
        this.price=price;
    }

    public String getPrice() {
        return price;
    }
}
