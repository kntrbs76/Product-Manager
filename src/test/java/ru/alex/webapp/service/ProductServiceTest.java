package ru.alex.webapp.service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.alex.webapp.model.Product;
import ru.alex.webapp.repository.ProductRepository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
@DataJpaTest
public class ProductServiceTest {


    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void whenFindAll_thenReturnProductList() {
        Product product = Product.builder()
                .name("Name")
                .description("Description")
                .place_storage(new BigInteger("1"))
                .create_date(new Date(2020-10-29))
                .price(new BigDecimal("1"))
                .build();
        List<Product> expectedProducts = Collections.singletonList(product);

        doReturn(expectedProducts).when(productRepository).findAll();

        List<Product> actualProducts = productService.findAll();

        assertThat(actualProducts).isEqualTo(expectedProducts);
    }

    @Test
    public void whenFindById_thenReturnProduct() {

        Optional<Product> expectedProduct = productService.findById(1L);

        doReturn(expectedProduct).when(productRepository).findById(1L);

        Optional<Product> actualProduct = productService.findById(1L);

        assertThat(actualProduct).isEqualTo(expectedProduct);
    }

    @Test
    public void whenSaveById_thenReturnSavedProduct() {
        Product product = Product.builder()
                .name("Name")
                .description("Description")
                .place_storage(new BigInteger("1"))
                .create_date(new Date(2020-10-29))
                .price(new BigDecimal("1"))
                .build();

        Product productExpectedToBeSaved = (productService.save(product));

        doReturn(productExpectedToBeSaved).when(productRepository).save(product);

        Product actualProduct = (productService.save(product));

        assertThat(actualProduct).isEqualTo(productExpectedToBeSaved);
    }

    @Test
    public void whenDeleteById_thenDoNotReturnProduct() {
        Product product = Product.builder()
                .name("Name")
                .description("Description")
                .place_storage(new BigInteger("1"))
                .create_date(new Date(2020-10-29))
                .price(new BigDecimal("1"))
                .build();

        when(productRepository.findById(1L)).thenReturn(Optional.ofNullable(product));

        productService.deleteById(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }
}
