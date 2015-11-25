package com.lnu.agile.model;

/**
 * Created by olefir on 11/23/2015.
 */
public class Product {
    private long productId;

    public Product(long productId) {
        this.productId = productId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
