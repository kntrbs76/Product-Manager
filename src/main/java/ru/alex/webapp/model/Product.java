package ru.alex.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "goods")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 512)
    @NotEmpty(message = "Name should not be empty")
    private String name;

    @Column(name = "description", length = 1025)
    @NotEmpty(message = "Description should not be empty")
    private String description;

    @Column(name = "place_storage")
    @Min(value = 0, message = "Place storage should be greater than zero")
    private BigInteger place_storage;

    @DateTimeFormat
    @Column(name = "create_date")
    @NotNull(message = "Date cannot be null")
    private Date create_date;

    @Column(name = "price")
    @NotNull(message = "Price cannot be null")
    private BigDecimal price;

    @CreationTimestamp
    private Timestamp createAt;

    @UpdateTimestamp
    private Date updatedAt;
}