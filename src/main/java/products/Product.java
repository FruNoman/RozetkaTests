package products;

public interface Product {
    void setName(String name);
    String getName();
    void setPrice(int price);
    int getPrice();
    boolean getPopular();
    void setPopular(boolean popular);
}
