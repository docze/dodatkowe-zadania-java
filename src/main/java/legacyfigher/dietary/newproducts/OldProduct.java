package legacyfigher.dietary.newproducts;

import java.math.BigDecimal;
import java.util.UUID;


/*
   unit test should be enough to secure code base against regression
   it seems that product is from more than one context:
   * Catalog context
   * Storage context
 */
public class OldProduct {

    UUID serialNumber = UUID.randomUUID();

    BigDecimal price;
    // not descriptive variable
    String longDesc;
    // replace it with prymitive type release problem with null-checks
    Integer counter;
    // not descriptive variable
    private String desc;

    // public contract could be higher
    // number of variable, with same type can be error-prone, it would be worth to consider builder
    public OldProduct(BigDecimal price, String desc, String longDesc, Integer counter) {
        this.price = price;
        this.desc = desc;
        this.longDesc = longDesc;
        this.counter = counter;
    }

    // maybe method should be synchronized in case of parallel using
    void decrementCounter() {
        // nested if,  invert logic and if condition is not fullfiled throw new exception
        // duplicated code base;
        if (price != null && price.signum() > 0) {
            // incorrect formatting
            if
            (counter == null) {
                throw new IllegalStateException("null counter");
            }
            counter = counter - 1;
            if (counter < 0) {
                throw new IllegalStateException("Negative counter");
            }
        } else {
            throw new IllegalStateException("Invalid price");

        }

    }

    // maybe method should be synchronized in case of parallel using
    void incrementCounter() {
        if (price != null && price.signum() > 0) {
            if (counter == null) {
                throw new IllegalStateException("null counter");
            }
            if (counter + 1 < 0) {
                throw new IllegalStateException("Negative counter");
            }
            counter = counter + 1;

        } else {
            throw new IllegalStateException("Invalid price");

        }
    }

    void changePriceTo(BigDecimal newPrice) {
        if (counter == null) {
            throw new IllegalStateException("null counter");
        }
        if (counter > 0) {
            // can be outside
            if (newPrice == null) {
                throw new IllegalStateException("new price null");
            }
            this.price = newPrice;
        }
    }

    void replaceCharFromDesc(String charToReplace, String replaceWith) {
        // null check and isEmpty can be replaced with some library function or just house-in made;
        if (longDesc == null || longDesc.isEmpty() ||

                desc == null || desc.isEmpty()) {
            throw new IllegalStateException("null or empty desc");
        }
        longDesc = longDesc.replace(charToReplace, replaceWith);
        desc = desc.replace(charToReplace, replaceWith);
    }

    String formatDesc() {
        if (longDesc == null ||
                longDesc.isEmpty() ||
                desc == null
                || desc.isEmpty()) {
            return "";
        }
        return desc + " *** " + longDesc;
    }
}
