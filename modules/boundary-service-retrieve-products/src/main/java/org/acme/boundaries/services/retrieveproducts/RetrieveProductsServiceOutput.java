package org.acme.boundaries.services.retrieveproducts;

import java.util.List;

public record RetrieveProductsServiceOutput(
    List<Product> products
) {
    public record Product(
        String serial,
        String name
    ) { }
}
