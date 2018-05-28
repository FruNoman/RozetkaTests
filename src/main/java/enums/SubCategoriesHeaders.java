package enums;

public enum SubCategoriesHeaders {
    DOMESTIC_CHEMICAL("Бытовая химия");

    private final String categoryHeader;
    SubCategoriesHeaders(String categoryHeader){
        this.categoryHeader=categoryHeader;
    }

    @Override
    public String toString() {
        return this.categoryHeader;
    }
}
