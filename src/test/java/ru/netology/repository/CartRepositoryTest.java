package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CartRepositoryTest {
    CartRepository repository = new CartRepository();
    private Book first = new Book(1, "Война и мир.том1", 1000, "Л.Н.Толстой");
    private Book second = new Book(2, "Война и мир.том2", 1000, "Л.Н.Толстой");

    @BeforeEach
    void init() {
        repository.save(first);
        repository.save(second);
    }

    @Test
    void shouldRemoveByCorrectId() {
        repository.removeById(2);
        Product[] expected = new Product[]{first};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByNotCorrectId() {
        assertThrows(NotFoundException.class, () -> repository.removeById(100));
    }
}