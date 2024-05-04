package org.acme.boundaries.usecases.produceproducts;

import java.util.List;

public record ProduceProductsUseCaseOutput(
    List<Product> products
) {
    public record Product(
        String serial,
        String name
    ) { }
}
