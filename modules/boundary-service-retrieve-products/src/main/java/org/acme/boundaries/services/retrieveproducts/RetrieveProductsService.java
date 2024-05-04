package org.acme.boundaries.services.retrieveproducts;

import io.smallrye.mutiny.Uni;

public interface RetrieveProductsService {
    Uni<RetrieveProductsServiceOutput> execute(RetrieveProductsServiceInput input);
}
