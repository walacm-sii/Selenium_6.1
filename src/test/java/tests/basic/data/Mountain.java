package tests.basic.data;

public record Mountain(int rank, String peak, String mountainRange, String state, int height) {

    @Override
    public String toString() {
        return String.format("Rank: %s, Peak: %s, Mountain range: %s", rank, peak, mountainRange);
    }
}
