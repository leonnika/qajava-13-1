package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.CartRepository;

public class CartManager {
    private CartRepository repository;

    public void removeById(int id) {
        repository.removeById(id);
    }

    public CartManager(CartRepository repository) {
        this.repository = repository;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] getAll() {
        Product[] items = repository.findAll();
        Product[] result = new Product[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
