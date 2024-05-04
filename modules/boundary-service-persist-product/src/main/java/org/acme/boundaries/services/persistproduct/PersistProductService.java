package org.acme.boundaries.services.persistproduct;

import io.smallrye.mutiny.Uni;

public interface PersistProductService {
    Uni<PersistProductServiceOutput> execute(PersistProductServiceInput input);
}
