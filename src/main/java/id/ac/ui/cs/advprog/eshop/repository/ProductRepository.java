package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String productId) {
        if (productId == null) {
            return null;
        }

        for (Product product : productData) {
            if (productId.equals(product.getProductId())) {
                return product;
            }
        }

        return null;
    }

    public Product update(String productId, Product updatedProduct) {
        Product existingProduct = findById(productId);
        if (existingProduct == null) {
            return null;
        }

        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setProductQuantity(updatedProduct.getProductQuantity());
        return existingProduct;
    }

    public boolean delete(String productId) {
        if (productId == null) {
            return false;
        }

        Iterator<Product> iterator = productData.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (productId.equals(product.getProductId())) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }
}
