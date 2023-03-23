package pages.form.data;

public enum Continent {
    ASIA("asia"),
    EUROPE("europe"),
    AFRICA("africa"),
    ANTARCTICA("antarctica"),
    NORTH_AMERICA("north-america"),
    SOUTH_AMERICA("south-america"),
    AUSTRALIA("australia");

    private String value;

    Continent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
