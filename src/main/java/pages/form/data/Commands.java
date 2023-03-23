package pages.form.data;

public enum Commands {
    BROWSER("browser-commands"),
    NAVIGATION("navigation-commands"),
    SWITCH("switch-commands"),
    WAIT("wait-commands"),
    WEB_ELEMENT("webelement-commands");

    private String value;

    Commands(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
