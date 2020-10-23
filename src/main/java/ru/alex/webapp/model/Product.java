package ru.alex.webapp.model;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "goods")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 512)
    private String name;

    @Column(name = "description",length = 1024)
    private String description;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "place_storage")
    private Long place_storage;

    @Column(name = "reserved",columnDefinition = "false")
    private Boolean reserved;
}
