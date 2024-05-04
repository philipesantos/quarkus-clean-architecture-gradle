package org.acme.boundaries.services.persistproduct;

public record PersistProductServiceInput(
    String serial,
    String name
) { }
