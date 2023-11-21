package com.data.model.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = -6899008321788368926L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank(message = "Product name can't be empty")
    private String name;

    @NotBlank(message = "Product description can't be empty")
    @Column(name = "description")
    private String desc;

    @NotNull(message = "Price can't be empty")
    private Integer price;

    @NotNull(message = "Stock Quantity can't be empty")
    private Integer stockQuantity;



}
