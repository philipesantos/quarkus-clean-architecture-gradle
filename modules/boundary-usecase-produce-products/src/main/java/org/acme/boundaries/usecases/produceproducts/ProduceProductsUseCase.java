package org.acme.boundaries.usecases.produceproducts;

import io.smallrye.mutiny.Uni;

public interface ProduceProductsUseCase {
    Uni<ProduceProductsUseCaseOutput> execute(ProduceProductsUseCaseInput input);
}
