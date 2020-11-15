package ru.alex.webapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.alex.webapp.model.Product;
import ru.alex.webapp.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Optional <Product> findById(Long id) {
        log.info("In ProductService findById {}", id);
        return productRepository.findById(id);

    }

    public List<Product> findAll() {
        log.info("In ProductService find all");
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        log.info("In ProductService deleteById {}", id);
        productRepository.deleteById(id);
    }

    public Product save(Product product) {
        log.info("In ProductService save {}", product);
        return productRepository.save(product);
    }

}
