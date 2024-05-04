package org.acme.domain;

import java.util.UUID;

public record Factory(
    String name
) {
    public static Factory findAvailable() {
        return new Factory("Acme Inc.");
    }

    public Product manufacture(Specification specification) {
        String serial = UUID.randomUUID().toString();
        return new Product(serial, specification.name());
    }
}
