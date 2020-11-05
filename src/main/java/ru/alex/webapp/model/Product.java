package ru.alex.webapp.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "goods")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 512)
    @NotNull(message = "Name cannot be null")
    private String name;

    @Column(name = "description", length = 1025)
    private String description;

    @Column(name = "place_storage")
    private BigInteger place_storage;

    @DateTimeFormat
    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "price")
    private BigDecimal price;

    @CreationTimestamp
    private Timestamp createAt;

    @UpdateTimestamp
    private Date updatedAt;
}