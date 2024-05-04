package org.acme.entrypoints.restful.jakarta.getproducts;

import java.util.List;

public record GetProductsResponse(
    List<Product> items
) {
    public record Product(
        String serial,
        String name
    ) { }
}