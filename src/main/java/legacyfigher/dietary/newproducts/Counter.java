package legacyfigher.dietary.newproducts;

public class Counter {
    Integer value;

    public Counter(Integer counter) {
        this.value = counter;
    }

    void incrementCounter() {
        if (value == null) {
            throw new IllegalStateException("null counter");
        }
        if (value + 1 < 0) {
            throw new IllegalStateException("Negative counter");
        }

        value = value + 1;
    }

    void decrementCounter() {
        if (value == null) {
            throw new IllegalStateException("null counter");
        }
        value = value - 1;

        if (value < 0) {
            throw new IllegalStateException("Negative counter");
        }
    }

    boolean isPositive() {
        return value > 0;
    }

    Integer value() {
        return this.value;
    }
}
