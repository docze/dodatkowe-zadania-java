package legacyfigher.dietary.newproducts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;

class OldProductTest {

    @Test
    void shouldBeIncreasedCounter() {
        // given
        final OldProduct oldProduct = new OldProduct(new BigDecimal(1), "desc", "longDesc", 0);
        // when
        oldProduct.incrementCounter();

        //then
        Assertions.assertEquals(1, oldProduct.counter.value());
    }

    @Test
    void shouldBeDecreasedCounter() {
        // given
        final OldProduct oldProduct = new OldProduct(new BigDecimal(1), "desc", "longDesc", 1);
        // when
        oldProduct.decrementCounter();

        //then
        Assertions.assertEquals(0, oldProduct.counter.value());
    }

    @Test
    void shouldBeThrownExceptionNegativeCounter() {
        // given
        final OldProduct oldProduct = new OldProduct(new BigDecimal(1), "desc", "longDesc", 0);
        // when
        final Executable decrementCounterAction = oldProduct::decrementCounter;

        //then
        Assertions.assertThrows(IllegalStateException.class, decrementCounterAction, "Negative counter");
    }

    @Test
    void givenAtLeastOneProductAndHasNewPrice() {
        // given
        final OldProduct oldProduct = new OldProduct(new BigDecimal(1), "desc", "longDesc", 1);
        // when
        final BigDecimal expectedPrice = new BigDecimal(5);
        oldProduct.changePriceTo(expectedPrice);

        //then
        Assertions.assertEquals(expectedPrice, oldProduct.price);
    }

    @Test
    void shouldReplacedDescription() {
        // given
        final OldProduct oldProduct = new OldProduct(new BigDecimal(1), "desc", "longDesc", 1);

        // when
        oldProduct.replaceCharFromDescription("esc", "");

        // then

        Assertions.assertEquals("longD", oldProduct.description.getLongDescription());
        Assertions.assertEquals("d *** longD", oldProduct.formatDescription());
    }



    @Test
    void shouldReturnEmptyDescription() {
        // given
        final OldProduct oldProduct = new OldProduct(new BigDecimal(1), "desc", "longDesc", 1);

        // when
        oldProduct.replaceCharFromDescription("desc", "");

        // then
        Assertions.assertEquals("", oldProduct.formatDescription());
    }
}