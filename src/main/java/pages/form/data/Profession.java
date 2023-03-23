package pages.form.data;

public enum Profession {
    MANUAL_TESTER("gridCheckManualTester"),
    AUTOMATION_TESTER("gridCheckAutomationTester"),
    OTHER("gridCheckOther");

    private String id;

    Profession(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
