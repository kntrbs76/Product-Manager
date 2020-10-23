package ru.alex.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.webapp.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
