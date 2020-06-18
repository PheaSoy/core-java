package book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {

    @Test
    void test_book_price_should_not_allow_zero() {
        Book book = new Book();
        book.setPrice(0);
        Assertions.assertThrows(BookException.class, () -> book.price());
    }
}
