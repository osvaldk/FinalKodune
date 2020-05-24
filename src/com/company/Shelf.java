package com.company;

public class Shelf {
    private String shelfName;
    private Product product;

    public Shelf(String shelfName, Product product) {
        this.shelfName = shelfName;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public String getShelfName() {
        return shelfName;
    }
}
