package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryEditDeleteTest {
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        this.productRepository = new ProductRepository();
    }

    @Test
    void update_existingProduct_updatesFields() {
        Product product = new Product();
        product.setProductId("id-1");
        product.setProductName("Old Name");
        product.setProductQuantity(1);
        productRepository.create(product);

        Product updated = new Product();
        updated.setProductName("New Name");
        updated.setProductQuantity(10);

        Product result = productRepository.update("id-1", updated);

        assertNotNull(result);
        assertEquals("id-1", result.getProductId());
        assertEquals("New Name", result.getProductName());
        assertEquals(10, result.getProductQuantity());
    }

    @Test
    void update_missingProduct_returnsNull() {
        Product updated = new Product();
        updated.setProductName("New Name");
        updated.setProductQuantity(10);

        assertNull(productRepository.update("missing-id", updated));
    }

    @Test
    void delete_existingProduct_removesProduct() {
        Product product = new Product();
        product.setProductId("id-1");
        product.setProductName("Name");
        product.setProductQuantity(1);
        productRepository.create(product);

        assertTrue(productRepository.delete("id-1"));

        Iterator<Product> iterator = productRepository.findAll();
        assertFalse(iterator.hasNext());
    }

    @Test
    void delete_missingProduct_returnsFalse() {
        assertFalse(productRepository.delete("missing-id"));
    }
}
