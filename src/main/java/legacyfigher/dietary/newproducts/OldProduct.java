package legacyfigher.dietary.newproducts;

import java.math.BigDecimal;
import java.util.UUID;


/*
   unit test should be enough to secure code base against regression,
   but
   it seems that product is from more than one context:
   * Catalog context
   * Storage context
 */
public class OldProduct {

    UUID serialNumber = UUID.randomUUID();

    BigDecimal price;
    // replace it with prymitive type release problem with null-checks
    Counter counter;
    Description description;

    // public contract could be higher
    // number of variable, with same type can be error-prone, it would be worth to consider builder
    @Deprecated
    public OldProduct(BigDecimal price, String description, String longDescription, Integer counter) {
        this.price = price;
        this.description = new Description(description, longDescription);
        this.counter = new Counter(counter);
    }

    // maybe method should be synchronized in case of parallel using
    void decrementCounter() {
        // nested if,  invert logic and if condition is not fullfiled throw new exception
        // duplicated code base;
        throwInvalidStateIfNullPrice();

        // incorrect formatting
        counter.decrementCounter();
    }

    // maybe method should be synchronized in case of parallel using
    void incrementCounter() {
        throwInvalidStateIfNullPrice();
        counter.incrementCounter();
    }

    void changePriceTo(BigDecimal newPrice) {
        if (counter == null) {
            throw new IllegalStateException("null counter");
        }
        if (newPrice == null) {
            throw new IllegalStateException("new price null");
        }

        if (counter.isPositive()) {
            this.price = newPrice;
        }
    }

    void replaceCharFromDescription(String charToReplace, String replaceWith) {
        description.replaceCharFromDescription(charToReplace, replaceWith);
    }

    private void throwInvalidStateIfNullPrice() {
        if (price == null || price.signum() <= 0) {
            throw new IllegalStateException("Invalid price");
        }
    }

    String formatDescription() {
        return description.formatDescription();
    }
}
