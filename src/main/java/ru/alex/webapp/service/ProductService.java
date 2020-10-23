package ru.alex.webapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alex.webapp.model.Product;
import ru.alex.webapp.repository.ProductRepository;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(Long id) {
        log.info("In ProductService findById {}", id);
        return productRepository.getOne(id);
    }

    public List<Product> findAll() {
        log.info("In ProductService find all");
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        log.info("In ProductService deleteById {}", id);
        productRepository.deleteById(id);
    }

    public Product saveProduct(Product product) {
        log.info("In ProductService saveProduct {}", product);
        return productRepository.save(product);
    }
}
