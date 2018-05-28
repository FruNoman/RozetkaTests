package products;

public class Smartphone implements Product,Comparable<Smartphone> {
    private String name;
    private int price;
    private boolean popular;

    public void setName(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price=price;
    }

    public int getPrice() {
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

    @Override
    public int compareTo(Smartphone o) {
        int price = ((Smartphone) o).getPrice();

        return this.price - price;
    }
}
