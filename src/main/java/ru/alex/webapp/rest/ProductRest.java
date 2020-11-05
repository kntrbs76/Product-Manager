package ru.alex.webapp.rest;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.webapp.model.Product;
import ru.alex.webapp.service.ProductService;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
@RequiredArgsConstructor
public class ProductRest {
    private final ProductService productService;

    @GetMapping(name = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Internal server error"), @ApiResponse(code = 404, message = "Product not found")})
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping(name = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Internal server error"), @ApiResponse(code = 404, message = "Product not found")})
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if(id == null) {
            log.error("Id" + id + " doesn't not exist");
            ResponseEntity.badRequest().build();
        }
        if(!product.isPresent()) {
            log.error("Product" + product + " doesn't not exist");
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(product.get());
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Internal server error"), @ApiResponse(code = 404, message = "Product not found")})
    public ResponseEntity<Product> update(@PathVariable Long id,@Valid @RequestBody Product product) {
        if(id == null) {
            log.error("Id" + id + " doesn't not exist");
            ResponseEntity.badRequest().build();
        }
        if(!productService.findById(id).isPresent()) {
            log.error("Product" + product + " doesn't not exist");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productService.save(product));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Internal server error"), @ApiResponse(code = 404, message = "Product not found")})
    public ResponseEntity delete(@PathVariable Long id) {
        if(!productService.findById(id).isPresent()) {
            log.error("Id " + id + " does not exist");
            ResponseEntity.notFound().build();
        }
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

