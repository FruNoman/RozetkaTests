package enums;

public enum SubCategories {
    SMARTPHONES("Смартфоны"),
    BUTTONS_PHONE("Кнопочные телефоны");

    private final String category;
    SubCategories(String category){
        this.category=category;
    }

    @Override
    public String toString() {
        return this.category;
    }
}
