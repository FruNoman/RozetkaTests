package products;

public class Smartphone implements Product {
    private String name;
    private String price;
    private boolean popular;

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

    public boolean getPopular() {
        return popular;
    }

    public void setPopular(boolean popular) {
        this.popular=popular;
    }

    @Override
    public String toString() {
        return "Smartphone: "+name+" | Price: "+price+" | Popular: "+popular;
    }
}
