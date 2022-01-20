package com.cartservice.model;

import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private int id;
    private String productTitle;
    private String productSlug;
    private List<String> productImages;
    private int categoryId;
    private int sellerId;
    private double productOriginalPrice;
    private double productFinalPrice;
    private double productRating;
    private int discountPercentage;
    private int quantity;

}
