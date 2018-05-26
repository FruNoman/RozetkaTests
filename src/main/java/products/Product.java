package products;

public interface Product {
    void setName(String name);
    String getName();
    void setPrice(String price);
    String getPrice();
    boolean getPopular();
    void setPopular(boolean popular);
}
